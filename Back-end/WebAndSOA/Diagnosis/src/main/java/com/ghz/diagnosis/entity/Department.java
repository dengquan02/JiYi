package com.ghz.diagnosis.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class Department {
    String department_id;

    String name;

    String hospital_id;
}
