package com.project.restfulproject.Domain.Dto.MemebrDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SigninDto {
    private String address;
    private String password;
}
