package com.ohgiraffers.section02.onetomany;

import jakarta.persistence.*;


@Entity(name = "menu")
@Table(name = "tbl_menu")
public class Menu {

    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    @JoinColumn(name = "category_code")
    @ManyToOne
    private CategoryAndMenu CategoryAndMenu;

    @Column(name = "orderable_status")
    private String orderableStatus;

    public Menu() {
    }

    public Menu(int menuCode, String menuName, int menuPrice, com.ohgiraffers.section02.onetomany.CategoryAndMenu categoryAndMenu, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        CategoryAndMenu = categoryAndMenu;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public com.ohgiraffers.section02.onetomany.CategoryAndMenu getCategoryAndMenu() {
        return CategoryAndMenu;
    }

    public void setCategoryAndMenu(com.ohgiraffers.section02.onetomany.CategoryAndMenu categoryAndMenu) {
        CategoryAndMenu = categoryAndMenu;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }
}
