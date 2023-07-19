package kr.co.jhta.repository;

import kr.co.jhta.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <T>  테이블과 연관되는 클래스
 * <Id> Member 클래스의 타입
 */
public interface MemberRepository extends JpaRepository<Member, String> {

}
