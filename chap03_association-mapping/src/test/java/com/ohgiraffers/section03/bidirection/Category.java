package com.ohgiraffers.section03.bidirection;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/*
 * 양방향 메핑에서 어느 한 쪽이 연관관계의 주인이 되면, 주인이 아닌 쪽에서는 속성을 지정해주어야 한다.
 * 이때, 연관 관계의 주인이 아닌 객체 MappedBy를 써서 연관 관계 주인 객체의 필드명을 매핑시켜놓으면 양방향 관계를 적용할 수 있다.
 * */


@Entity(name = "category_section03")
@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name = "category_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

    // 부모 테이블을 참조하는 자식 테이블
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST) // 주인이 아닌 쪽에다가 달아주어야 한다
    private List<Menu> menuList = new ArrayList<>();

    public Category() {
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode, List<Menu> menuList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        List<Menu> list = new ArrayList<>();
        for(Menu m : menuList){
            m.setCategory(this);
            list.add(m);
        }
        this.menuList = list;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +

                '}';
    }
}
