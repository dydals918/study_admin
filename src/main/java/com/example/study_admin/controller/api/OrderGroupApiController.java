package com.example.study_admin.controller.api;

import com.example.study_admin.controller.CrudController;
import com.example.study_admin.ifs.CrudInterface;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.request.OrderGroupApiRequest;
import com.example.study_admin.model.network.response.OrderGroupApiResponse;
import com.example.study_admin.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiResponse, OrderGroupApiRequest> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = orderGroupApiLogicService;
    }

}
