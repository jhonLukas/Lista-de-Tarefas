package com.JhonLukas.Lista.de.tarefas.Controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.JhonLukas.Lista.de.tarefas.Models.UserModel;
import com.JhonLukas.Lista.de.tarefas.Models.UserModel.CreateUser;
import com.JhonLukas.Lista.de.tarefas.Models.UserModel.UpdateUser;
import com.JhonLukas.Lista.de.tarefas.Services.UserService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/user")

public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<UserModel> findById(@PathVariable Long id) {
		UserModel obj = this.userService.FindById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	@Validated(CreateUser.class)
	public ResponseEntity<Void> create(@Valid @RequestBody UserModel obj) {
		this.userService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	@Validated(UpdateUser.class)
	public ResponseEntity<Void> update(@Valid @RequestBody UserModel obj, @PathVariable Long id) {
		obj.setId(id);
		this.userService.upDate(obj);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
       this.userService.delete(id);
       return ResponseEntity.noContent().build();
		
		
	}

}
