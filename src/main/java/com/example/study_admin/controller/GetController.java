package com.example.study_admin.controller;

import com.example.study_admin.model.SearchParam;
import com.example.study_admin.model.network.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest() {

        return "Hi getMethod";
    }

    @GetMapping(path = "/getMultiParam")
    public SearchParam getMultiParam(SearchParam searchParam) {
        System.out.println(searchParam.getId());
        System.out.println(searchParam.getPassword());
        System.out.println(searchParam.getPage());

        return searchParam;
    }

    @GetMapping(path = "/header")
    public Header getHeader() {
        return Header.builder().resultCode("Ok").description("OK").build();
    }
}
