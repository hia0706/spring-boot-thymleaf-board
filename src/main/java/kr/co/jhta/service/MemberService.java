package kr.co.jhta.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.jhta.entity.Member;
import kr.co.jhta.exception.DuplicatedEmailException;
import kr.co.jhta.exception.DuplicatedMemberIdException;
import kr.co.jhta.repository.MemberRepository;
import kr.co.jhta.web.form.RegisterMemberForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService{
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	
	@Override
	//유저를 식별하기 위한 메서드 재정의
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Optional<Member> optional = memberRepository.findById(id);
		//orElseThrow optional 안에 멤버가 들어있으면 반환 들어있지 않으면 예외(UsernameNotFoundException)를 던짐
		Member member = optional.orElseThrow(() -> new UsernameNotFoundException(id));
		
		
		return member;
	}
	
	
	
	public void registerUser(RegisterMemberForm form) {
		//아이디로 사용자 정보 조회하기
		Optional<Member> optionalMember = memberRepository.findById(form.getId());
		if(optionalMember.isPresent()) {
			throw new DuplicatedMemberIdException(form.getId());
		}
		
		//이메일로 사용자 정보 조회하기
		optionalMember = memberRepository.findByEmail(form.getEmail());
		if(optionalMember.isPresent()) {
			throw new DuplicatedEmailException(form.getEmail());
		}
		Member member = new Member();
		BeanUtils.copyProperties(form, member);
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		memberRepository.save(member);
	}
	
}
