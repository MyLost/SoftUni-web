package com.softuni.book.service.impl;

import com.softuni.book.model.entity.BaseEntity;
import com.softuni.book.service.BaseService;

import java.util.List;

public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T getById(Long id) {
        return null;
    }

    @Override
    public T save(Object dto) {
        return null;
    }
}
