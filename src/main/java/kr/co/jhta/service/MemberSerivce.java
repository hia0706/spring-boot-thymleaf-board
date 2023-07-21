package kr.co.jhta.service;

import kr.co.jhta.entity.Member;
import kr.co.jhta.repository.MemberRepository;
import kr.co.jhta.service.exception.DuplicatedEmailEception;
import kr.co.jhta.service.exception.DuplicatedMemberIdException;
import kr.co.jhta.web.form.RegisterMemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberSerivce implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 식별
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Member> optional = memberRepository.findById(id);
        // 서플라이 인터페이스의 get이라는 추상메소드 재정의
        Member member = optional.orElseThrow(() -> new UsernameNotFoundException(id));

        return member;
    }

    public void registerUser(RegisterMemberForm form) {
        Optional<Member> optionalMember = memberRepository.findById(form.getId());
        if (optionalMember.isPresent()) {
            throw new DuplicatedMemberIdException(form.getId());
        }

        // 이메일로 사용자 정보 조회하기
        optionalMember = memberRepository.findByEmail(form.getEmail());
        if (optionalMember.isPresent()) {
            throw new DuplicatedEmailEception(form.getEmail());
        }

        Member member = new Member();
        BeanUtils.copyProperties(form, member);
        // 비밀번호 암호화
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        memberRepository.save(member);
    }

}
