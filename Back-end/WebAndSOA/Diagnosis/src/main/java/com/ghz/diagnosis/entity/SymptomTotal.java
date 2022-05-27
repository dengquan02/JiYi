package com.ghz.diagnosis.entity;

import java.io.Serializable;

/**
 * (SymptomTotal)实体类
 *
 * @author makejava
 * @since 2022-05-14 19:52:14
 */
public class SymptomTotal implements Serializable {
    private static final long serialVersionUID = 841583039074661847L;
    
    private String symptomName;


    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

}