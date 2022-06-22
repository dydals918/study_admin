package com.example.study_admin.controller.api;

import com.example.study_admin.controller.CrudController;
import com.example.study_admin.model.entity.User;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.request.UserApiRequest;
import com.example.study_admin.model.network.response.userApi.UserApiResponse;
import com.example.study_admin.model.network.response.userApi.UserOrderInfoApiResponse;
import com.example.study_admin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiResponse, UserApiRequest, User> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping("/{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id) {

        return userApiLogicService.orderInfo(id);

    }
}
