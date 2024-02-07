package com.ohgiraffers.springjpa.category.service;

import com.ohgiraffers.springjpa.category.entity.Category;
import com.ohgiraffers.springjpa.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Integer findByCategory(int categoryCode){

        Category category = categoryRepository.findByCategoryCode(categoryCode);

        if(Objects.isNull(category.getCategoryCode())){
            return null;
        }

        return category.getCategoryCode();
    }

    public Category insertCategory(String categoryName) {

        // 이름이 중복되는지 확인
        Category foundCategory = categoryRepository.findByCategoryName(categoryName);

        if(!Objects.isNull(foundCategory)){// 중복되는 경우 null 반환
            return null;
        }

        Category insertCategory = new Category();
        insertCategory.setCategoryName(categoryName);

        Category result = categoryRepository.save(insertCategory);

        return result;

    }
}
