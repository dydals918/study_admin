package com.example.study_admin.controller.api;

import com.example.study_admin.controller.CrudController;
import com.example.study_admin.ifs.CrudInterface;
import com.example.study_admin.model.entity.Category;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.request.CategoryApiRequest;
import com.example.study_admin.model.network.response.CategoryApiResponse;
import com.example.study_admin.service.CategoryApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController extends CrudController<CategoryApiResponse, CategoryApiRequest, Category> {

}
