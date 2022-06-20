package com.example.study_admin.controller.api;

import com.example.study_admin.controller.CrudController;
import com.example.study_admin.model.entity.Item;
import com.example.study_admin.model.network.request.ItemApiRequest;
import com.example.study_admin.model.network.response.ItemApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiResponse, ItemApiRequest, Item> {

}
