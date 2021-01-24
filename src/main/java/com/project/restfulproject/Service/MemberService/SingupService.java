package com.project.restfulproject.Service.MemberService;

import com.project.restfulproject.Domain.Dto.MemebrDto.SignupDto;
import com.project.restfulproject.Domain.Entity.MemberEntity;
import com.project.restfulproject.Domain.Repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class SingupService {


    private final MemberRepository memberRepository;

    public SingupService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberEntity creatUser(SignupDto signupDto){

        MemberEntity memberEntity= signupDto.toEntity();
        return memberRepository.save(memberEntity);

    }
}
