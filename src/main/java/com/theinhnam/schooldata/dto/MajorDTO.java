package com.theinhnam.schooldata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MajorDTO {
    private String code;
    private String name;
    private String description;
    private Integer score;
}
