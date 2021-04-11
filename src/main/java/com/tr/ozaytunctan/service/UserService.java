package com.tr.ozaytunctan.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.multipart.MultipartFile;

import com.tr.ozaytunctan.entity.User;

public interface UserService {

	public CompletableFuture<List<User>> createUsers(MultipartFile file);

	public CompletableFuture<List<User>> findAllUsers();
}
