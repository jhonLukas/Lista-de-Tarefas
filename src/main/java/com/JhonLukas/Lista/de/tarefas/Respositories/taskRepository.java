package com.JhonLukas.Lista.de.tarefas.Respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JhonLukas.Lista.de.tarefas.Models.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long>{
	  List<TaskModel> findByUser_Id(Long userId);
}
