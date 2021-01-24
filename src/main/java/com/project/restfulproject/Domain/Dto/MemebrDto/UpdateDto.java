package com.project.restfulproject.Domain.Dto.MemebrDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDto {
    private String name;
    private String checkid;
    private String password;
    private String address;
    private Date createdDate = new Date();
}
