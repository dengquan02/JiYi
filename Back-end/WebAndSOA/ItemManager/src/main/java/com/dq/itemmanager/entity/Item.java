package com.dq.itemmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Item)实体类
 *
 * @author makejava
 * @since 2022-05-14 20:46:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {

    private Integer itemId;

    private Double price;

    private Integer num;

    private String name;

    private Integer hospitalId;

    private Integer otc;

    private String img;
}
