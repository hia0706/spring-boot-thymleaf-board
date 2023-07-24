package kr.co.jhta.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="sample_board_posts")
@DynamicInsert
@SequenceGenerator(
        name = "sample_posts_seq.generator",
        sequenceName = "sample_posts_seq",
        initialValue = 1,
        allocationSize = 1
)
public class Post extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, // 자동할당 방식
                    generator = "sample_posts_seq.generator")
    @Column(name = "post_no")
    private Integer no;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_content")
    private String content;

    @Column(name = "post_read_count")
    private int readCount;

    @Column(name = "post_comment_count")
    private int commentCount;

    @Column(name = "post_deleted")
    private String deleted;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}
