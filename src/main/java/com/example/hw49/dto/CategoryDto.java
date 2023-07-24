package com.example.hw49.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {
    @JsonIgnore
    private Long id;
    private String title;

}
