package com.example.study_admin.repository;

import com.example.study_admin.StudyAdminApplicationTests;
import com.example.study_admin.model.entity.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends StudyAdminApplicationTests {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void create() {

        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category saveCategory = categoryRepository.save(category);
        Assert.assertNotNull(saveCategory);
        Assert.assertEquals(saveCategory.getType(), type);
        Assert.assertEquals(saveCategory.getTitle(), title);

    }

    @Test
    public void read() {

        String type = "COMPUTER";

        Optional<Category> category = categoryRepository.findByType(type);

        category.ifPresent( c -> {
            Assert.assertEquals(c.getType(), type);
            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });

    }

}
