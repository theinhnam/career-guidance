package com.theinhnam.schooldata.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "majors")
@Data
public class Major {
    @Id
    private String code;
    private String name;
    private String description;
}

