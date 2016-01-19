package com.golubov.repo;

import com.golubov.model.CcyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SGolubov on 7/28/2015.
 */
public interface CcyRepository extends JpaRepository<CcyEntity, Long> {

    List<CcyEntity> findAll();

    CcyEntity save(CcyEntity ccyEntity);

}
