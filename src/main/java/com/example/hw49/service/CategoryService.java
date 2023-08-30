package com.example.hw49.service;

import com.example.hw49.dao.CategoryDao;
import com.example.hw49.dto.CategoryDto;
import com.example.hw49.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryDao categoryDao;

    public String getTitleById(Long id) {
        return categoryDao.getTitleById(id);
    }

    public List<CategoryDto> getAllCategories(){
        List<Category> categories = categoryDao.getAllCategories();
        return categories.stream().map(e -> CategoryDto.builder()
                .id(e.getId())
                .title(e.getTitle())
                .build()).toList();
    }

    public Optional<Category> getIdByTitle(String title) {
        return categoryDao.getIdByTitle(title.toUpperCase());
    }

}
