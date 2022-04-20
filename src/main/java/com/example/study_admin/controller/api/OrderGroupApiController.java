package com.example.study_admin.controller.api;

import com.example.study_admin.ifs.CrudInterface;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.request.OrderGroupApiRequest;
import com.example.study_admin.model.network.response.OrderGroupApiResponse;
import com.example.study_admin.service.OrderGroupLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiResponse, OrderGroupApiRequest> {

    @Autowired
    private OrderGroupLogicService orderGroupLogicService;

    @Override
    @PostMapping("")
    public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {
        return orderGroupLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<OrderGroupApiResponse> read(@PathVariable Long id) {
        return orderGroupLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
        return orderGroupLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return orderGroupLogicService.delete(id);
    }
}
