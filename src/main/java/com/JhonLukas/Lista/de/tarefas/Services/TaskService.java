package com.JhonLukas.Lista.de.tarefas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.JhonLukas.Lista.de.tarefas.Models.TaskModel;
import com.JhonLukas.Lista.de.tarefas.Models.UserModel;
import com.JhonLukas.Lista.de.tarefas.Respositories.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskService {

	@Autowired
	private TaskRepository tasksRepository;
	@Autowired
	private UserService userService;

	
	public List<TaskModel> findAllUserById(Long userId){
		List<TaskModel> tasks = this.tasksRepository.findByUser_Id(userId);
		return tasks;
	}
	
	
	@Transactional
	public TaskModel findById(Long id) {
		Optional<TaskModel> task = this.tasksRepository.findById(id);
		return task.orElseThrow(() -> new RuntimeException(
				"Não encontramos o seu usuario id:" + id + "tipo" + task.getClass().getName()));
	}

	public TaskModel create(TaskModel task) {
		UserModel user = this.userService.FindById(task.getUser().getId());
		task.setId(null);
		task.setUser(user);
		task = this.tasksRepository.save(task);
		return task;
	}

	@Transactional
	public TaskModel update(TaskModel task) {
		TaskModel newTask = findById(task.getUser().getId());
		newTask.setDescription(task.getDescription());
		return this.tasksRepository.save(newTask);
	}

	public void delete(Long id) {
		findById(id);
		try {
			this.tasksRepository.deleteById(id);
		}

		catch (Exception e) {
			throw new RuntimeException("Não e possivel exlcuir ,pois há entidades relacionadas");
		}

	}

}