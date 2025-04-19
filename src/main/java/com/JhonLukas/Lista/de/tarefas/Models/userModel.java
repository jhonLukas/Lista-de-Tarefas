package com.JhonLukas.Lista.de.tarefas.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Tb_user")
public class UserModel {

	public interface UpdateUser {
	}

	public interface CreateUser {
	}

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;
     
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "username", unique = true, length = 100, nullable = false)
	@NotBlank(groups = { CreateUser.class, UpdateUser.class })
	private String login;

	@Column(name = "password", length = 20, nullable = false)
	@NotBlank(groups = { CreateUser.class })
	@Size(groups = { CreateUser.class, UpdateUser.class }, min = 8, max = 60)
	private String password;

	@OneToMany(mappedBy = "user")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<TaskModel> task = new ArrayList<TaskModel>();

	
}
