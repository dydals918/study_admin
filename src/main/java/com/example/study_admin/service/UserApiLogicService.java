package com.example.study_admin.service;

import com.example.study_admin.model.entity.Item;
import com.example.study_admin.model.entity.OrderGroup;
import com.example.study_admin.model.entity.User;
import com.example.study_admin.model.network.Header;
import com.example.study_admin.model.network.Pagination;
import com.example.study_admin.model.network.request.UserApiRequest;
import com.example.study_admin.model.network.response.ItemApiResponse;
import com.example.study_admin.model.network.response.OrderGroupApiResponse;
import com.example.study_admin.model.network.response.userApi.UserApiResponse;
import com.example.study_admin.model.network.response.userApi.UserOrderInfoApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserApiLogicService extends BaseService<UserApiResponse, UserApiRequest, User> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Autowired
    private ItemApiLogicService itemApiLogicService;

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

        return Header.OK(response(newUser));
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        Optional<User> optionalUser = baseRepository.findById(id);

        return optionalUser
                .map(user -> Header.OK(response(user)))
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
                .map(updateUser -> Header.OK(response(updateUser)))
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

    @Override
    public Header<List<UserApiResponse>> search(Pageable pageable){

        Page<User> users = baseRepository.findAll(pageable);

        List<UserApiResponse> userApiResponseList = users.stream()
                .map(user -> response(user))
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPage(users.getTotalPages())
                .totalElements(users.getTotalElements())
                .currentPage(users.getNumber())
                .currentElements(users.getNumberOfElements())
                .build();

        return Header.OK(userApiResponseList, pagination);
    }

    public Header<UserOrderInfoApiResponse> orderInfo(Long id) {

        User user = baseRepository.getOne(id);
        UserApiResponse userApiRes = response(user);

        List<OrderGroup> orderGroupList = user.getOrderGroupList();

        List<OrderGroupApiResponse> orderGroupApiResList = orderGroupList.stream()
                .map(orderGroup -> {
                    OrderGroupApiResponse orderGroupApiRes = orderGroupApiLogicService.response(orderGroup);

                    List<ItemApiResponse> itemList = orderGroup.getOrderDetailList().stream()
                            .map(detail -> detail.getItem())
                            .map(item -> itemApiLogicService.response(item))
                            .collect(Collectors.toList());

                    orderGroupApiRes.setItemApiResList(itemList);
                    return orderGroupApiRes;
                })
                .collect(Collectors.toList());

        userApiRes.setOrderGroupApiResList(orderGroupApiResList);
        UserOrderInfoApiResponse userOrderInfoApiRes = UserOrderInfoApiResponse.builder()
                .userApiRes(userApiRes)
                .build();

        return Header.OK(userOrderInfoApiRes);
    }

    // user -> userApiResponse
    private UserApiResponse response(User user){

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

        return userApiResponse;
    }

}
