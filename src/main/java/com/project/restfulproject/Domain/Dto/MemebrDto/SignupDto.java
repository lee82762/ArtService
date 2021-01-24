package com.project.restfulproject.Domain.Dto.MemebrDto;

import com.project.restfulproject.Domain.Entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupDto {
    private Long id;

    private String name;
    private String checkid;
    private String password;
    private String address;
    private Date createdDate;

    public MemberEntity toEntity(){
        return  MemberEntity.builder()
                .id(id)
                .name(name)
                .checkid(checkid)
                .password(password)
                .address(address)
                .createdDate(new Date())
                .build();
    }

}
