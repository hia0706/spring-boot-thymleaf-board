package kr.co.jhta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sample_board_members")
@Getter
@Setter
@DynamicInsert
@NoArgsConstructor
public class Member {

	@Id
	@Column(name = "member_id")
	private String id;
	
	@Column(name = "member_password")
	private String password;
	
	@Column(name = "member_name")
	private String name;
	
	@Column(name = "member_email")
	private String email;
	
	@Column(name = "member_tel")
	private String tel;
	
	@Column(name = "member_deleted")
	private String deleted;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "member_updated_date" )
	private Date updatedDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "member_created_date")
	private Date createdDate;
}
