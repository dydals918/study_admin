package com.example.study_admin.model.network.response.userApi;

import com.example.study_admin.model.network.response.ItemApiResponse;
import com.example.study_admin.model.network.response.OrderGroupApiResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOrderInfoApiResponse {

    private UserApiResponse userApiRes;

}
