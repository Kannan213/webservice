package com.msk.college.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Courses {
    private String name;
    private int duration;
    private int fees;
}
