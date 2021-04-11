package com.tr.ozaytunctan.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tr.ozaytunctan.entity.User;
import com.tr.ozaytunctan.service.UserService;

@RestController
@RequestMapping(path = "/rest/api/v1/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(path = "/saveAll", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUsers(@RequestParam(value = "files") @Valid @NotEmpty MultipartFile[] files) {
		Stream.of(files)//
				.forEach(userService::createUsers);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@GetMapping(path = "/all")
	public CompletableFuture<ResponseEntity<List<User>>> getAllUsers() {
		return this.userService.findAllUsers().thenApply(ResponseEntity::ok);
	}

	@GetMapping(path = "/getUsersByThread")
	public ResponseEntity<?> getUsersByThread() {
		CompletableFuture<List<User>> u1 = this.userService.findAllUsers();
		CompletableFuture<List<User>> u2 = this.userService.findAllUsers();
		CompletableFuture<List<User>> u3 = this.userService.findAllUsers();
		CompletableFuture<List<User>> u4 = this.userService.findAllUsers();
		CompletableFuture<List<User>> u5 = this.userService.findAllUsers();
		CompletableFuture.allOf(u1, u2, u3, u4,u5).join();
		return ResponseEntity.ok().build();
	}
}
