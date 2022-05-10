package com.ghz.diagnosis.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class Hospital {
    Integer hospital_id;

    String name;

    String address;

}
