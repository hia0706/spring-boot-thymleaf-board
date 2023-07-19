package kr.co.jhta.repository;

import kr.co.jhta.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;


    public  void testSaveMember() {
        Member member = new Member();
        member.setId("hong");
        member.setPassword("zxcv1234");
        member.setName("홍길동");
        member.setEmail("hong@naver.com");
        member.setTel("010-1234-1234");

        memberRepository.save(member);
    }

}