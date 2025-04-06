package com.JhonLukas.Lista.de.tarefas.Controllers;

import java.net.URI;
import java.util.List;

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

import com.JhonLukas.Lista.de.tarefas.Models.TaskModel;
import com.JhonLukas.Lista.de.tarefas.Services.TaskService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/task")
@Validated
public class TaskController {

	@Autowired
	TaskService taskService;

	@GetMapping("/user/{userid}")
	public ResponseEntity<List <TaskModel>> findAllUserId (@PathVariable Long userid ){
		List<TaskModel> objs = this.taskService.findAllUserById(userid);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TaskModel> findById(@PathVariable Long id) {
		TaskModel obj = this.taskService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	@Validated
	public ResponseEntity<Void> create(@Valid @RequestBody TaskModel obj) {
		obj = this.taskService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	@Validated
	public ResponseEntity<Void> update(@Valid @RequestBody TaskModel obj, @PathVariable Long id) {
		obj.setId(id);
		this.taskService.update(obj);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.taskService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
