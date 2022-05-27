package com.ghz.diagnosis.entity;

import java.io.Serializable;

/**
 * (DiseaseTotal)实体类
 *
 * @author makejava
 * @since 2022-05-14 19:51:28
 */
public class DiseaseTotal implements Serializable {
    private static final long serialVersionUID = 879022658496024541L;
    
    private String diseaseName;


    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

}