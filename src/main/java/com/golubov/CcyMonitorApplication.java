package com.golubov;

import com.golubov.model.CcyAPIResponseWrapper;
import com.golubov.model.CcyEntity;
import com.golubov.repo.CcyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan
@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
public class CcyMonitorApplication {

    public static void main(String[] args) throws URISyntaxException {
        ApplicationContext context = SpringApplication.run(CcyMonitorApplication.class, args);
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 3128));
        CcyRepository ccyRepository = context.getBean(CcyRepository.class);
        clientHttpRequestFactory.setProxy(proxy);
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        String API_KEY = "7aeec31b7c1a469b9abc072b0581545b";
        String API_URI = "https://openexchangerates.org/api/latest.json?app_id={api_key}";
        CcyAPIResponseWrapper apiWrapper = restTemplate.getForObject(API_URI, CcyAPIResponseWrapper.class, API_KEY);
        apiWrapper.getRates().entrySet().stream().forEach(o -> convertAndSaveCcyEntity(o, ccyRepository));
        List<CcyEntity> ccyEntities = ccyRepository.findAll();
        System.out.println("----------->>>><<<<----------");
        ccyEntities.stream().forEach(o -> System.out.print(o.getCcy() + ", "));
        System.out.println("----------->>>><<<<----------");
    }

    private static void convertAndSaveCcyEntity(Map.Entry<String, BigDecimal> entry, CcyRepository ccyRepository) {
        CcyEntity ccyEntity = new CcyEntity(entry.getKey(), entry.getValue());
        ccyRepository.save(ccyEntity);
    }

}
