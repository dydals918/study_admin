package com.example.study_admin.controller.api;

import com.example.study_admin.controller.CrudController;
import com.example.study_admin.ifs.CrudInterface;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.request.ItemApiRequest;
import com.example.study_admin.model.network.response.ItemApiResponse;
import com.example.study_admin.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiResponse, ItemApiRequest> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = itemApiLogicService;
    }

}
