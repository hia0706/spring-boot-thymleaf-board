package kr.co.jhta.web.controller;

import kr.co.jhta.entity.Member;
import kr.co.jhta.entity.Post;
import kr.co.jhta.service.PostService;
import kr.co.jhta.web.form.AddPostForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("addPostForm", new AddPostForm());

        return "post/form";
    }

    @PreAuthorize("isAuthenticated()") // 인증된 사용자만 접속 가능
    @PostMapping("/add")
    public String add(@AuthenticationPrincipal Member member, @Valid AddPostForm form, BindingResult errors) {
        if (errors.hasErrors()) {
            return "post/list";
        }
        postService.addPost(form, member);

        return "redirect:list";
    }

    @GetMapping("/list")
    public String list(Model model) {

        List<Post> posts = postService.getPost();
        model.addAttribute("posts", posts);

        return "post/list";
    }
}
