package kr.co.jhta.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class PostDto {

    private int no;
    private String title;
    private String content;
    private int readCount;
    private int commentCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String memberId;
    private String memberName;
}
