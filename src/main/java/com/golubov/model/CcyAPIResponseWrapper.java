package com.golubov.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by SGolubov on 7/29/2015.
 */
public class CcyAPIResponseWrapper implements Serializable {

    private static final long serialVersionUID = 942542194248360161L;

    private String disclaimer;

    private String license;

    private Long timestamp;

    private String base;

    private Map<String, BigDecimal> rates;

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }
}
