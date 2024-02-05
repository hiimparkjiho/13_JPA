package com.ohgiraffers.section01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

/*
* @Entity 어노테이션은 jpa에서 사용되는 클래스임을 표시한다.
* 이 어노테이션을 사용하면 해당 클래스가 데이터베이스의 테이블과 메핑된다.
*
* @Entity 어노테이션은 클래스 선언 위에 위치해야 한다.
* 또한, name 속성을 사용ㅎ여 엔티티 클래스와 메핑될 테이블의 이름을 지정할 수 있다.
* 생략하면 자동으로 클래스 이름을 엔티티명으로 사용한다.
*
* - 프로젝트 내에 다른 패키지에도 동일한 엔티티가 존재하는 경우 해당 엔티티를 식별하기 위한 중복되지 않은 name을 지정해주어야 한다.
* - 기본 생성자는 필수도 작성해야 한다.
* - final 클래스, enum, interface, inner class에서는 사용할 수 없다.
* - 저장할 필드에 final을 사용하면 안 된다.
* */

@Entity(name = "member_section01")
@Table(name = "tbl_member_section01")
public class Member {
    @Id
    @Column(name = "member_no")
    private int memberNo;

    @Column(name = "member_id")
    private String memeberId;

    @Column(name = "member_pwd")
    private String memberPwd;

    @Column(name = "nickName")
    private String nickname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "enroll_date")
    private Date enrollDate;

    @Column(name = "address")
    private String address;

    @Column(name = "member_role")
    private String memberRole;

    @Column(name = "status")
    private String status;

    public Member() {
    }

    public Member(int memberNo, String memeberId, String memberPwd, String nickname, String phone, String email, Date enrollDate, String address, String memberRole, String status) {
        this.memberNo = memberNo;
        this.memeberId = memeberId;
        this.memberPwd = memberPwd;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.enrollDate = enrollDate;
        this.address = address;
        this.memberRole = memberRole;
        this.status = status;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemeberId() {
        return memeberId;
    }

    public void setMemeberId(String memeberId) {
        this.memeberId = memeberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memeberId='" + memeberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", enrollDate=" + enrollDate +
                ", address='" + address + '\'' +
                ", memberRole='" + memberRole + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
