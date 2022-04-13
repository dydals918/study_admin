package com.example.study_admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchParam {

    private String id;
    private String password;
    private int page;
}
