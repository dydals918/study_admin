package com.example.study_admin.service;

import com.example.study_admin.ifs.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseService<res, req, Entity> implements CrudInterface<res, req> {

    @Autowired(required = false)
    protected JpaRepository<Entity, Long> baseRepository;

}
