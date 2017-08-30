package com.gms.web.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data 
public class MemberBean {
    @Getter @Setter
    private String id, pw, name,phone,ssn,email,profile,birthday,gender,major,regdate;

	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", ssn=" + ssn
				+ ", email=" + email + ", profile=" + profile + ", birthday=" + birthday + ", gender=" + gender
				+ ", major=" + major + ", regdate=" + regdate + "]";
	}  

}