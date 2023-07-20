package kr.co.jhta.repository;

import kr.co.jhta.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, String>{
	
}
