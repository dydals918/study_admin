package com.example.study_admin.repository;

import com.example.study_admin.StudyAdminApplicationTests;
import com.example.study_admin.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyAdminApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){

        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "000-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(LocalDateTime.now());
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("AdminServer");

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);
        Assert.assertEquals(newUser.getAccount(), account);
    }

    @Test
    @Transactional
    public void read() {

        User user = userRepository.findByPhoneNumberOrderByIdDesc("000-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {

            System.out.println(orderGroup.getTotalPrice());
            System.out.println(orderGroup.getTotalQuantity());
            System.out.println(orderGroup.getRevAddress());
            System.out.println(orderGroup.getRevName());
            System.out.println("-------------------------");

            orderGroup.getOrderDetailList().stream().forEach(orderDetail -> {
                System.out.println(orderDetail.getStatus());
                System.out.println(orderDetail.getItem().getName());
                System.out.println(orderDetail.getItem().getPartner().getCallCenter());
            });

        });

        Assert.assertNotNull(user);

    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("TestUpdate02");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("UpdateAdmin01");

            userRepository.save(selectUser);
        });
    }

    @Test
    public void delete() {
        Optional<User> user = userRepository.findById(1L);

        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);

        Assert.assertFalse(deleteUser.isPresent());

        System.out.println("데이터 삭제");
    }
}
