package com.example.study_admin.controller.api;

import com.example.study_admin.controller.CrudController;
import com.example.study_admin.model.entity.Partner;
import com.example.study_admin.model.network.request.PartnerApiRequest;
import com.example.study_admin.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiResponse, PartnerApiRequest, Partner> {

}
