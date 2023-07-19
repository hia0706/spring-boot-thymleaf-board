package kr.co.jhta.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sample_board_members")
@Getter
@Setter
public class Member {

    @Id
    @Column(name = "member_id") // updatable = false primary key
    private String id;

    @Column(name = "member_password") // nullable = false not null
    private String password;

    @Column(name = "member_name") // length = 10 이름 길이
    private String name;

    @Column(name = "member_email")
    private String email;

    @Column(name = "member_tel")
    private String tel;

    @Column(name = "member_deleted")
    private String deleted;

    @Temporal(TemporalType.DATE)
    @Column(name = "member_updated_date")
    private Date updatedDate;

    @Column(name = "member_created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

}
