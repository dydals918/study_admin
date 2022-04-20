package com.example.study_admin.controller.api;

import com.example.study_admin.ifs.CrudInterface;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.request.ItemApiRequest;
import com.example.study_admin.model.network.response.ItemApiResponse;
import com.example.study_admin.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiResponse, ItemApiRequest> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @PostMapping("")
    @Override
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        return itemApiLogicService.create(request);
    }

    @GetMapping("{id}")
    @Override
    public Header<ItemApiResponse> read(@PathVariable Long id) {
        return itemApiLogicService.read(id);
    }

    @PutMapping("")
    @Override
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
        return itemApiLogicService.update(request);
    }

    @DeleteMapping("{id}")
    @Override
    public Header delete(@PathVariable Long id) {
        return itemApiLogicService.delete(id);
    }

}
