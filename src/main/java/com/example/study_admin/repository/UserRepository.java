package com.example.study_admin.repository;

import com.example.study_admin.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByPhoneNumberOrderByIdDesc(String phoneNumber);

}
