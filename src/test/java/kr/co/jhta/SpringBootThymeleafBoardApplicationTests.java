package kr.co.jhta;

import kr.co.jhta.entity.Member;
import kr.co.jhta.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootThymeleafBoardApplicationTests {

    @Autowired
    MemberRepository memberRepository;

    /*
        @BeforeEach
            테스트에 대한 사전작업이 정의된 메소드에 지정한다.
            이 어노테이션이 지정된 메소드에 구현된 내용은
     */
    @BeforeEach
    public void setup() {
        memberRepository.deleteAll();
    }

    @DisplayName("saveMember: 멤버추가에 성공한다.") // 메소드명 별칭
    @Test
    public void testSaveMember() {

        // 테스트 준비
        Member member = new Member();
        member.setId("hong");
        member.setPassword("zxcv1234");
        member.setName("홍길동");
        member.setEmail("hong@naver.com");
        member.setTel("010-1234-1234");

        // 실행하기
        memberRepository.save(member);

        // 검증하기
        Member savedMember = memberRepository.findById("hong").orElseThrow(() -> new RuntimeException());

        Assertions.assertThat(savedMember).isNotNull();
        Assertions.assertThat(savedMember.getId()).isEqualTo("hong");
        Assertions.assertThat(savedMember.getName()).isEqualTo("홍길동");

    }
}
