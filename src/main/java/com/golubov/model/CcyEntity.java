package com.golubov.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by SGolubov on 7/28/2015.
 */
@Entity
public class CcyEntity implements Serializable {

    private static final long serialVersionUID = -5306337999074811800L;

    @Id
    private String ccy;

    private BigDecimal value;

    public CcyEntity() {
    }

    public CcyEntity(String ccy, BigDecimal value) {
        this.ccy = ccy;
        this.value = value;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
