package com.tr.ozaytunctan.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tr.ozaytunctan.common.helper.FileUploadHelper;
import com.tr.ozaytunctan.entity.User;
import com.tr.ozaytunctan.repository.UserRepository;
import com.tr.ozaytunctan.service.UserService;
import com.tr.ozaytunctan.utils.FactoryUtils;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Async
	@Override
	public CompletableFuture<List<User>> createUsers(MultipartFile file) {
		final Long startTime = FactoryUtils.tic();

		List<User> users = FileUploadHelper.importCsv(file);

		LOGGER.info("Saving list of users size{} " + users.size() + " " + Thread.currentThread().getName());

		users = this.userRepository.saveAll(users);

		LOGGER.info("Elapsed Time {}:" + FactoryUtils.toc(startTime) + " ms");

		return CompletableFuture.completedFuture(users);
	}

	@Async
	@Override
	public CompletableFuture<List<User>> findAllUsers() {
		LOGGER.info("Get list of user by " + Thread.currentThread().getName());
		 List<User> users = this.userRepository.findAll();
		return CompletableFuture.completedFuture(users);
	}

}
