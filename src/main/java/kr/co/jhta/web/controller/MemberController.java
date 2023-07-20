package kr.co.jhta.web.controller;

import kr.co.jhta.service.MemberSerivce;
import kr.co.jhta.service.exception.DuplicatedEmailEception;
import kr.co.jhta.service.exception.DuplicatedMemberIdException;
import kr.co.jhta.web.form.RegisterMemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberSerivce memberSerivce;

    @GetMapping("/register")
    public String form(Model model) {
        /*
         회원가입 폼 화면으로 이동하기 전에  RegisterMemberForm객체를 생성해서 Model객체에 저장한다.
         화면에서는 Model객체에 "registerMeberForm"이름으로 등록된 객체를 조회해서
         입력폼의 각 필드에 값을 출력한다.
        */
        model.addAttribute("registerMemberForm", new RegisterMemberForm());
        return "member/form";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterMemberForm form, BindingResult errors) {
        log.info("errors -> {}", errors);
        if (errors.hasErrors()) {
            return "member/form"; // 입력폼으로 다시 내부이동 redirect 하면 form 의 정보가 사라지기 때문!
        }

        try {
            memberSerivce.registerUser(form);
        } catch (DuplicatedMemberIdException ex) {
            errors.rejectValue("id", null, "이미 사용중인 아이디입니다.");
            return "member/form";
        } catch (DuplicatedEmailEception ex) {
            errors.rejectValue("email", null, "이미 사용중인 이메일입니다.");
            return "member/form";
        }

        return "redirect:registered";
    }

    @GetMapping("/registered")
    public String registerd() {
        return "member/registered";
    }
}
