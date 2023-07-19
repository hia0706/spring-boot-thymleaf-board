package kr.co.jhta.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sample_board_members")
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

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", deleted='" + deleted + '\'' +
                ", updateDate=" + updatedDate +
                ", createDate=" + createdDate +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
