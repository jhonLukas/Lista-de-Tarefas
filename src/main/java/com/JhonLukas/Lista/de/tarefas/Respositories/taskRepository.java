package com.JhonLukas.Lista.de.tarefas.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JhonLukas.Lista.de.tarefas.Models.TaskModel;
import com.JhonLukas.Lista.de.tarefas.Models.UserModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long>{

}
