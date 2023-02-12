package com.softuni.BattleShips.services;

import com.softuni.BattleShips.domain.entities.CategoryEntity;
import com.softuni.BattleShips.domain.enums.CategoryType;
import com.softuni.BattleShips.model.CategoryModel;
import com.softuni.BattleShips.repositories.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void postConstruct() {
        if(this.categoryRepository.count() == 0 ) {
            List<CategoryEntity> categories = Arrays.stream(CategoryType.values()).map(ct -> CategoryModel.
                    builder()
                    .name(ct)
                    .description("fight me")
                    .build())
                    .map(ctm -> this.modelMapper.map(ctm, CategoryEntity.class)).toList();
            this.categoryRepository.saveAllAndFlush(categories);
        }
    }

    public CategoryModel findByName(CategoryType name) {
        CategoryEntity category = this.categoryRepository.findByName(name).orElseThrow();
        return modelMapper.map(category, CategoryModel.class);
    }
}
