package com.example.study_admin.controller.api;

import com.example.study_admin.controller.CrudController;
import com.example.study_admin.ifs.CrudInterface;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.request.AdminUserApiRequest;
import com.example.study_admin.model.network.response.AdminUserApiResponse;
import com.example.study_admin.service.AdminUserApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController extends CrudController<AdminUserApiResponse, AdminUserApiRequest> {

    @Autowired
    private AdminUserApiLogicService adminUserApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = adminUserApiLogicService;
    }

}
