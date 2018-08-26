package com.yc.house.po;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class Users {
    private Integer id;
    
    @NotEmpty(message="用户名不能为空")
    @Length(min=2,max=16,message="用户名长度应该在2-16个字符之间")
    private String name;
    @NotEmpty(message="密码不能为空")
    @Length(min = 6, max = 18, message = "密码长度在6到18个字符之间")
    private String password;
//    @Pattern(regexp="^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\\\d{8}$",message="请输入正确的手机号码")
    private String telephone;
    @NotEmpty(message="姓名不能为空")
    private String username;

    private String isadmin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin == null ? null : isadmin.trim();
    }

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", password=" + password + ", telephone=" + telephone
				+ ", username=" + username + ", isadmin=" + isadmin + "]";
	}
}