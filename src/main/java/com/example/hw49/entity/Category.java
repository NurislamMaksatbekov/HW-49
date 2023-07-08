package com.example.hw49.entity;

import lombok.Data;

@Data
public class Category {
    private Long id;
    private String category;
    private Category categories;
}
