package kr.co.jhta.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import kr.co.jhta.dto.PostDto;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.co.jhta.entity.Member;
import kr.co.jhta.entity.Post;
import kr.co.jhta.repository.PostRepository;
import kr.co.jhta.web.form.AddPostForm;
import lombok.RequiredArgsConstructor;

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

	public Page<Post> getPosts(Pageable pageable) {
		return postRepository.findAll(pageable);
		
	}

    public void increaseReadCount(int no) {
        Optional<Post> optional = postRepository.findById(no);
        Post post = optional.orElseThrow(() -> new RuntimeException("게시글 없음"));
        post.setReadCount(post.getReadCount() + 1);

        postRepository.save(post);

    }

    public PostDto getPost(int no) {
        Optional<Post> optional = postRepository.findById(no);
        Post post = optional.orElseThrow(() -> new RuntimeException("게시글 없음"));

        // PostDto객체를 생성해서 Post객체의 값을 저장한다.
        PostDto dto = new PostDto();
        BeanUtils.copyProperties(post, dto);
        dto.setMemberId(post.getMember().getId());
        dto.setMemberName(post.getMember().getName());

        return dto;
    }

}
