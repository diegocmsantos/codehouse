package com.clearbases.codehouse.models;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * Created by diego on 5/11/17.
 */
@Embeddable
public class Price {

    private BigDecimal value;
    private PriceType type;


    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public PriceType getType() {
        return type;
    }

    public void setType(PriceType type) {
        this.type = type;
    }
}
