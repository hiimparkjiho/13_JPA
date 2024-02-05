package com.ohgiraffers.section02.column;

import jakarta.persistence.*;

import java.util.Date;

/*
* 컬럼 매핑 시 @Column 어노테이션에 사용 가능한 속성들
* 1. name : 매핑할 테이블의 컬럼 이름
* 2. insertable : 엔티티 저장 시 필드 저장 여부 (default: true)
* 3. updatable : 엔티티 수정 시 필드 수정 여부(default: true)
* 4. table: 엔티티와 매핑될 테이블 이름, 하나의 엔티티를 두 개 이상의 테이블에 메핑할 때 사용(@SecondaryTable 사용)
* 5. nullable : null값 허용 여부 설정, not null 제약 조건에 해당함(true 기본값)
* 6. unique : 컬럼에 유일성 제약조건
* (두 개 이상 컬럼에 unique 제약조건을 설정하기 위해서 클래스 레벨에서 @Table의 uniqueonstraints 속성에 설정)
* 7. columnDefinition : 직접 컬럼의 ddl을 지정
* 8. length: 문자열 길이, String type에서만 사용(default: 255)
* */

@Entity(name = "member_section02")
@Table(name = "tbl_member_section02")
public class Member {

        @Id
        @Column(name = "member_no")
        private int memberNo;

        @Column(name = "member_id")
        private String memeberId;

        @Column(name = "member_pwd")
        private String memberPwd;

        @Column(name = "nickName")
        @Transient  // 테이블 생성 시 무시된다 자바에선 필요한데 DB에 필요없는 값
        private String nickname;

        @Column(name = "phone", columnDefinition = "varchar(200) default '010-0000-0000'")
        private String phone;

        @Column(name = "email", unique = true)
        private String email;

        @Column(name = "address", nullable = false)
        private String address;

        @Column(name = "enroll_date")
        @Temporal(TemporalType.TIMESTAMP)
        private Date enrollDate;

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
