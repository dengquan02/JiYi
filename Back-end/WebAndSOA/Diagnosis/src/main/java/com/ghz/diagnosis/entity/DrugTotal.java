package com.ghz.diagnosis.entity;

import java.io.Serializable;

/**
 * (DrugTotal)实体类
 *
 * @author makejava
 * @since 2022-05-14 19:51:51
 */
public class DrugTotal implements Serializable {
    private static final long serialVersionUID = -22204012651224757L;
    
    private String drugName;


    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

}