package kr.co.jhta.repository;

import kr.co.jhta.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, String>{

    /*
        아래와 대응되는 쿼리문
        select *
        from members
        where email = ?
     */
    Optional<Member> findByEmail(String email);
}
