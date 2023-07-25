package com.example.hw49.service;

import com.example.hw49.dao.CategoryDao;
import com.example.hw49.dto.CategoryDto;
import com.example.hw49.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryDao categoryDao;

    public String getTitleById(Long id) {
        return categoryDao.getTitleById(id);
    }

    public Optional<Category> getIdByTitle(String title) {
        return categoryDao.getIdByTitle(title);
    }

    public Long save(String title) {
        return categoryDao.save(Category.builder()
                .title(title)
                .build());
    }

    public void change(CategoryDto categoryDto) {
        categoryDao.change(Category.builder()
                .title(categoryDto.getTitle())
                .build());
    }
}
