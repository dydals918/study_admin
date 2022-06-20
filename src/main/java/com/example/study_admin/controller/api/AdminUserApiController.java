package com.example.study_admin.controller.api;

import com.example.study_admin.controller.CrudController;
import com.example.study_admin.model.entity.AdminUser;
import com.example.study_admin.model.network.request.AdminUserApiRequest;
import com.example.study_admin.model.network.response.AdminUserApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController extends CrudController<AdminUserApiResponse, AdminUserApiRequest, AdminUser> {

}
