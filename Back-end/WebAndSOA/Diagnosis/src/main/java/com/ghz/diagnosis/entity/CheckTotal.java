package com.ghz.diagnosis.entity;

import java.io.Serializable;

/**
 * (CheckTotal)实体类
 *
 * @author makejava
 * @since 2022-05-14 19:49:21
 */
public class CheckTotal implements Serializable {
    private static final long serialVersionUID = 617277097036183732L;
    
    private String checkName;


    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

}