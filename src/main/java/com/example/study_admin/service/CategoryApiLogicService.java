package com.example.study_admin.service;

import com.example.study_admin.model.entity.Category;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.request.CategoryApiRequest;
import com.example.study_admin.model.network.response.CategoryApiResponse;
import org.springframework.stereotype.Service;

@Service
public class CategoryApiLogicService extends BaseService<CategoryApiResponse, CategoryApiRequest, Category> {

    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {

        CategoryApiRequest body = request.getData();

        Category category = Category.builder()
                .type(body.getType())
                .title(body.getTitle())
                .build();

        Category createCategory = baseRepository.save(category);

        return response(createCategory);
    }

    @Override
    public Header<CategoryApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(findCategory -> response(findCategory))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {

        CategoryApiRequest body = request.getData();

        return baseRepository.findById(body.getId())
                .map(findCategory -> {
                    findCategory
                            .setId(body.getId())
                            .setType(body.getType())
                            .setTitle(body.getTitle());
                    return findCategory;
                })
                .map(findCategory -> baseRepository.save(findCategory))
                .map(updateCategory -> response(updateCategory))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(findCategory -> {
                    baseRepository.delete(findCategory);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    private Header<CategoryApiResponse> response(Category category){

        CategoryApiResponse body = CategoryApiResponse.builder()
                .id(category.getId())
                .type(category.getType())
                .title(category.getTitle())
                .build();

        return Header.OK(body);
    }
}
