package com.project.restfulproject.Service.MemberService;

import com.project.restfulproject.Domain.Dto.MemebrDto.UpdateDto;
import com.project.restfulproject.Domain.Entity.MemberEntity;
import com.project.restfulproject.Domain.Repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {
    private final MemberRepository memberRepository;

    public UpdateService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void updateMember(UpdateDto updateDto, String address){


        MemberEntity checkid=memberRepository.findByAddress(address);
        System.out.println(checkid);

        if(checkid==null){
            System.out.println("수정할 수 없음11");
        }

        checkid.userUpdate(updateDto);
        memberRepository.save(checkid);


    }
}
