package com.example.study_admin.repository;

import com.example.study_admin.StudyAdminApplicationTests;
import com.example.study_admin.model.entity.AdminUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/*
@Slf4j
public class baseRepositoryTest extends StudyAdminApplicationTests {

    @Autowired
    private baseRepository baseRepository;

    @Test
    @Transactional
    public void create() {

        AdminUser adminUser = new AdminUser();
        adminUser.setAccount("AdminUser02");
        adminUser.setPassword("AdminUser02");
        adminUser.setStatus("REGISTERED");
        adminUser.setRole("PARTNER");

        AdminUser newAdminUser = baseRepository.save(adminUser);

        Assert.assertNotNull(newAdminUser);

    }

    @Test
    @Transactional
    public void read(){

        Optional<AdminUser> newAdminUser = baseRepository.findById(2L);

        newAdminUser.ifPresent(findAdmin -> System.out.println(findAdmin.getRole()));

    }

}
*/



