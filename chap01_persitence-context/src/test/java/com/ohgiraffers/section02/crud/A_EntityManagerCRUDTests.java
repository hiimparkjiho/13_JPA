package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class A_EntityManagerCRUDTests {

    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory(){
        entityManagerFactory = Persistence.createEntityManagerFactory(("jpatest"));
    }

    @BeforeEach
    public void initManager(){
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    static void closeFactory(){
        entityManagerFactory.close();
    }

    @AfterEach
    void closeManager(){
        entityManager.close();
    }

    @Test
    public void 메뉴코드로_메뉴_조회_테스트(){
        // given
        int menuCode = 2;

        // when
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        //then
        Assertions.assertNotNull(foundMenu);

        Menu newMenu = entityManager.find(Menu.class, menuCode);

        Assertions.assertEquals(menuCode, newMenu.getMenuCode());
        System.out.println("found Menu: " + foundMenu);
    }

    @Test
    public void 새로운_메뉴_추가_테스트(){
        // given
        Menu menu = new Menu();
        menu.setMenuName("jpa 테스트 메뉴");
        menu.setMenuPrice(50000);
        menu.setCategoryCode(4);
        menu.setOrderableStatus("y");

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try{
            entityManager.persist(menu);
            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }

        Assertions.assertTrue(entityManager.contains(menu));
    }

    @Test
    public void 메뉴_이름_수정_테스트(){
        Menu menu = entityManager.find(Menu.class, 2);
        System.out.println("menu = " + menu);

        String menuNameToChange = "갈치스무디3";

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try{
            menu.setMenuName(menuNameToChange);
            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }

        Assertions.assertEquals(menuNameToChange, entityManager.find(Menu.class, 3).getMenuName());
    }

    @Test
    public void 메뉴_삭제하기_테스트(){
        //given
        Menu menuToRemove = entityManager.find(Menu.class, 1);

        //when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try{
            entityManager.remove(menuToRemove);
            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }
        Menu removeMenu = entityManager.find(Menu.class, 1);
        Assertions.assertNull(removeMenu);
    }
}
