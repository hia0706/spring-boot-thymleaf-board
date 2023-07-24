package kr.co.jhta.service;

import kr.co.jhta.entity.Member;
import kr.co.jhta.entity.Post;
import kr.co.jhta.repository.PostRepository;
import kr.co.jhta.web.form.AddPostForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    public final PostRepository postRepository;

    public void addPost(AddPostForm form, Member member) {
        Post post = new Post();
        BeanUtils.copyProperties(form, post);

        post.setMember(member);

        postRepository.save(post);
    }

    public List<Post> getPost() {

        return postRepository.findAll();
    }
}
