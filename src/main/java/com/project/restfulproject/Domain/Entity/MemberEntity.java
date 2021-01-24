package com.project.restfulproject.Domain.Entity;

import com.project.restfulproject.Domain.Dto.MemebrDto.UpdateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String checkid;
    private String password;
    private String address;
    private Date createdDate;




    public void userUpdate(UpdateDto updateDto){
       this.name=updateDto.getName();
       this.checkid=updateDto.getCheckid();
       this.password=updateDto.getPassword();
       this.address=updateDto.getAddress();
       this.createdDate=updateDto.getCreatedDate();
   }

}
