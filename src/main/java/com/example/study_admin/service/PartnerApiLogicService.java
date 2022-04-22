package com.example.study_admin.service;

import com.example.study_admin.ifs.CrudInterface;
import com.example.study_admin.model.entity.Partner;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.request.PartnerApiRequest;
import com.example.study_admin.model.network.response.PartnerApiResponse;
import com.example.study_admin.repository.CategoryRepository;
import com.example.study_admin.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerApiLogicService implements CrudInterface<PartnerApiResponse, PartnerApiRequest> {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {

        PartnerApiRequest body = request.getData();

        Partner partner = Partner.builder()
                .name(body.getName())
                .status(body.getStatus())
                .address(body.getAddress())
                .callCenter(body.getCallCenter())
                .partnerNumber(body.getPartnerNumber())
                .businessNumber(body.getBusinessNumber())
                .ceoName(body.getCeoName())
                .registeredAt(body.getRegisteredAt())
                .category(categoryRepository.getOne(body.getCategoryId()))
                .build();

        Partner createPartner = partnerRepository.save(partner);

        return response(createPartner);
    }

    @Override
    public Header<PartnerApiResponse> read(Long id) {

        return partnerRepository.findById(id)
                .map(findPartner -> response(findPartner))
                .orElseGet(() -> Header.ERROR("데이터 없음"))
                ;

    }

    @Override
    public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {

        PartnerApiRequest body = request.getData();

        return partnerRepository.findById(body.getId())
                .map(findPartner -> {
                    findPartner
                            .setName(body.getName())
                            .setStatus(body.getStatus())
                            .setAddress(body.getAddress())
                            .setCallCenter(body.getCallCenter())
                            .setPartnerNumber(body.getPartnerNumber())
                            .setBusinessNumber(body.getBusinessNumber())
                            .setCeoName(body.getCeoName())
                            .setUnregisteredAt(body.getUnregisteredAt())
                            .setCategory(categoryRepository.getOne(body.getCategoryId()));

                    return findPartner;
                })
                .map(findPartner -> partnerRepository.save(findPartner))
                .map(updatePartner -> response(updatePartner))
                .orElseGet(() -> Header.ERROR("데이터 없음"))
                ;
    }

    @Override
    public Header delete(Long id) {
        return partnerRepository.findById(id)
                .map(findPartner -> {
                    partnerRepository.delete(findPartner);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    private Header<PartnerApiResponse> response(Partner partner){

        PartnerApiResponse body = PartnerApiResponse.builder()
                .id(partner.getId())
                .name(partner.getName())
                .status(partner.getStatus())
                .address(partner.getAddress())
                .callCenter(partner.getCallCenter())
                .partnerNumber(partner.getPartnerNumber())
                .businessNumber(partner.getBusinessNumber())
                .ceoName(partner.getCeoName())
                .registeredAt(partner.getRegisteredAt())
                .unregisteredAt(partner.getUnregisteredAt())
                .categoryId(partner.getCategory().getId())
                .build();

        return Header.OK(body);
    }
}
