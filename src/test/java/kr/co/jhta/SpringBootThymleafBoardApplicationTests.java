package kr.co.jhta;

import kr.co.jhta.entity.Member;
import kr.co.jhta.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootThymleafBoardApplicationTests {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testSaveMember() {
        Member member = new Member();
        member.setId("hong");
        member.setPassword("zxcv1234");
        member.setName("홍길동");
        member.setEmail("hong@naver.com");
        member.setTel("010-1234-1234");

        memberRepository.save(member);
    }
}
