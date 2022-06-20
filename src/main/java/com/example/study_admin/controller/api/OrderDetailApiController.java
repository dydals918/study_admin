package com.example.study_admin.controller.api;

import com.example.study_admin.controller.CrudController;
import com.example.study_admin.model.entity.OrderDetail;
import com.example.study_admin.model.network.request.OrderDetailApiRequest;
import com.example.study_admin.model.network.response.OrderDetailApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailApiController extends CrudController<OrderDetailApiResponse, OrderDetailApiRequest, OrderDetail> {

}
