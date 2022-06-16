package com.example.study_admin.service;

import com.example.study_admin.model.entity.User;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.request.UserApiRequest;
import com.example.study_admin.model.network.response.UserApiResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService extends BaseService<UserApiResponse, UserApiRequest, User> {

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        UserApiRequest userApiRequest = request.getData();

        User user = User.builder()
                        .account(userApiRequest.getAccount())
                        .password(userApiRequest.getPassword())
                        .status(userApiRequest.getStatus())
                        .email(userApiRequest.getEmail())
                        .phoneNumber(userApiRequest.getPhoneNumber())
                        .registeredAt(LocalDateTime.now())
                        .build();
        User newUser = baseRepository.save(user);

        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        Optional<User> optionalUser = baseRepository.findById(id);

        return optionalUser
                .map(user -> response(user))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {

        UserApiRequest userApiRequest = request.getData();

        Optional<User> findUser = baseRepository.findById(userApiRequest.getId());

        return findUser
                .map(user -> {
                    user.setAccount(userApiRequest.getAccount())
                            .setPassword(userApiRequest.getPassword())
                            .setEmail(userApiRequest.getEmail())
                            .setStatus(userApiRequest.getStatus())
                            .setPhoneNumber(userApiRequest.getPhoneNumber())
                            .setRegisteredAt(userApiRequest.getRegisteredAt())
                            .setUnregisteredAt(userApiRequest.getUnregisteredAt());
                    return user;
                })
                .map(user -> baseRepository.save(user))
                .map(updateUser -> response(updateUser))
                .orElseGet( () -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {

        Optional<User> optionalUser = baseRepository.findById(id);

        return optionalUser
                .map( user -> {
                    baseRepository.delete(user);
                    return Header.OK();
                })
                .orElseGet( () -> Header.ERROR("데이터 없음"));
    }

    // user -> userApiResponse
    private Header<UserApiResponse> response(User user){

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .status(user.getStatus())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        return Header.OK(userApiResponse);
    }

}
