package com.example.productshop.services.impl;

import com.example.productshop.repositories.UserRepository;
import com.example.productshop.services.UserService;
import com.example.productshop.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final BufferedReader reader;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, BufferedReader reader) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.reader = reader;
    }

    @Override
    public void seedUsers() {

    }
}
