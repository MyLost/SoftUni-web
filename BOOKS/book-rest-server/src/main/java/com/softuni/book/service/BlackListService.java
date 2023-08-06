package com.softuni.book.service;

import org.springframework.stereotype.Service;

@Service
public class BlackListService {
    public boolean isBlackListed(String ip) {
        return false;
    }
}
