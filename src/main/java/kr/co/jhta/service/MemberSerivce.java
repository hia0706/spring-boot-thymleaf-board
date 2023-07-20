package kr.co.jhta.service;

import kr.co.jhta.entity.Member;
import kr.co.jhta.repository.MemberRepository;
import kr.co.jhta.service.exception.DuplicatedEmailEception;
import kr.co.jhta.service.exception.DuplicatedMemberIdException;
import kr.co.jhta.web.form.RegisterMemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberSerivce {

    private final MemberRepository memberRepository;

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

        memberRepository.save(member);
    }
}
