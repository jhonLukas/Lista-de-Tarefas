package com.JhonLukas.Lista.de.tarefas.Models;

import java.util.Objects;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_task")
public class TaskModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserModel user;

	@NotBlank
	@Size(min = 1, max = 256)
	@Column(name = "description", length = 256, nullable = false)
	private String description;

	public TaskModel() {
	}

	public TaskModel(Long id, UserModel user, String description) {
		this.id = id;
		this.user = user;
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskModel other = (TaskModel) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
