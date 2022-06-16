package com.example.study_admin.model.network.response;

import com.example.study_admin.model.enumClass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AdminUserApiResponse {

    private Long id;

    private String account;

    private String password;

    private UserStatus status;

    private String role;

    private LocalDateTime lastLoginAt;

    private Integer loginFailCount;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

}
