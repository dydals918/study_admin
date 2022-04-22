package com.example.study_admin.service;

import com.example.study_admin.ifs.CrudInterface;
import com.example.study_admin.model.entity.Category;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.request.CategoryApiRequest;
import com.example.study_admin.model.network.response.CategoryApiResponse;
import com.example.study_admin.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryApiLogicService implements CrudInterface<CategoryApiResponse, CategoryApiRequest> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {

        CategoryApiRequest body = request.getData();

        Category category = Category.builder()
                .type(body.getType())
                .title(body.getTitle())
                .build();

        Category createCategory = categoryRepository.save(category);

        return response(createCategory);
    }

    @Override
    public Header<CategoryApiResponse> read(Long id) {
        return categoryRepository.findById(id)
                .map(findCategory -> response(findCategory))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {

        CategoryApiRequest body = request.getData();

        return categoryRepository.findById(body.getId())
                .map(findCategory -> {
                    findCategory
                            .setId(body.getId())
                            .setType(body.getType())
                            .setTitle(body.getTitle());
                    return findCategory;
                })
                .map(findCategory -> categoryRepository.save(findCategory))
                .map(updateCategory -> response(updateCategory))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return categoryRepository.findById(id)
                .map(findCategory -> {
                    categoryRepository.delete(findCategory);
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
