package kr.co.jhta.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "sample_board_members")
@Getter
@Setter
@DynamicInsert // 입력안한 null 값 컬럼들은 default 값으로 설정된다.
@NoArgsConstructor
public class Member extends BaseDateTimeEntity implements UserDetails {

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

	// 로그인 하면 모든 사용자의 권한은 "ROLE_USER"로 지정
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
