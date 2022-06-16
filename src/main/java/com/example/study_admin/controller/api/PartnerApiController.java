package com.example.study_admin.controller.api;

import com.example.study_admin.controller.CrudController;
import com.example.study_admin.ifs.CrudInterface;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.request.PartnerApiRequest;
import com.example.study_admin.model.network.response.PartnerApiResponse;
import com.example.study_admin.service.PartnerApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiResponse, PartnerApiRequest> {

    @Autowired
    private PartnerApiLogicService partnerApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = partnerApiLogicService;
    }

}
