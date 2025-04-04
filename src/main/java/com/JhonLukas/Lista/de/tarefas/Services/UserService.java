package com.JhonLukas.Lista.de.tarefas.Services;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JhonLukas.Lista.de.tarefas.Models.UserModel;
import com.JhonLukas.Lista.de.tarefas.Respositories.TaskRepository;
import com.JhonLukas.Lista.de.tarefas.Respositories.UserRepository;

import jakarta.transaction.Transactional;
import lombok.Data;

@Data
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TaskRepository taskrepository;

	public UserModel FindById(Long id) {
		Optional<UserModel> user = this.userRepository.findById(id);
		return user.orElseThrow(() -> new RuntimeException(
				"Não encontramos o seu usuario id:" + id + "tipo" + user.getClass().getName()));
	}

	@Transactional
	public UserModel create(UserModel user) {
		user.setId(null);
		user = this.userRepository.save(user);
		this.taskrepository.saveAll(user.getTask());
		return user;
	}

	@Transactional
	public UserModel upDate(UserModel user) {
		UserModel newuser = FindById(user.getId());
		newuser.setPassword(user.getPassword());
		return this.userRepository.save(newuser);
	}

	public void delete(Long id) 
	{
     FindById(id);
     try
     {
        this.userRepository.deleteById(id);
     }
     
     catch (Exception e) 
     {
        throw new RuntimeException("Não e possivel exlcuir ,pois há entidades relacionadas");
	 }

}
}
