package com.project.restfulproject.Service.MemberService;

import com.project.restfulproject.Domain.Entity.MemberEntity;
import com.project.restfulproject.Domain.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeleteService {
    private List<MemberEntity> member=new ArrayList<>();

    private final MemberRepository memberRepository;

    public DeleteService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void memberDelete(Long id){
        memberRepository.deleteById(id);
    }
}
