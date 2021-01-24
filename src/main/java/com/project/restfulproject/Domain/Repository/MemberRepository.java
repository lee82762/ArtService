package com.project.restfulproject.Domain.Repository;

import com.project.restfulproject.Domain.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
        MemberEntity findByCheckid(String checkid);
        MemberEntity findByAddress(String address);
}
