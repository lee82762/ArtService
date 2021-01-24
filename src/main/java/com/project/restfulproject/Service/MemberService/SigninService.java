package com.project.restfulproject.Service.MemberService;

import com.project.restfulproject.Domain.Dto.MemebrDto.LoginDto;
import com.project.restfulproject.Domain.Dto.MemebrDto.SigninDto;
import com.project.restfulproject.Domain.Entity.MemberEntity;
import com.project.restfulproject.Domain.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;

@Service
public class SigninService {
    private final MemberRepository memberRepository;

    public SigninService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public LoginDto loginUser(SigninDto signinDto) throws Exception {
        //MemberEntity memberEntity=memberRepository.findByCheckid(signinDto.getCheckid());
        //MemberEntity memberEntity=memberRepository.findByAddress(signinDto.getAddress());
        MemberEntity memberEntity = null;
        try{
            memberEntity=memberRepository.findByAddress(signinDto.getAddress());

        }
        catch (Exception e){
            System.out.println("로그인 실패");
            return new LoginDto("로그인 실패");

        }
        Cookie cookie=new Cookie("user",null);

        if(!memberEntity.getPassword().equals(signinDto.getPassword())){
            return new LoginDto("비밀번호 오류");
        }
        else{
            return new LoginDto("로그인 성공");
        }

    }

    public MemberEntity loginUser1(SigninDto signinDto) throws Exception {

        MemberEntity memberEntity = null;

        try{
            memberEntity=memberRepository.findByAddress(signinDto.getAddress());

        }
        catch (Exception e){
            System.out.println("로그인 실패");
            return null;

        }
        Cookie cookie=new Cookie("user",null);

        if(!memberEntity.getPassword().equals(signinDto.getPassword())){
            return null;
        }
        else{
            return memberEntity;
        }

    }
}
