package com.JhonLukas.Lista.de.tarefas.Models;

import java.util.Objects;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Tb_task")
public class TaskModel
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	@JoinColumn(name = "user_id", nullable = false, updatable = false)
	private Long id;
	@ManyToOne
	private UserModel user;
	@NotBlank
	@Column(name = "description", length = 256)
	@Size(min = 1, max = 256)
	private String description;
	
	
	public TaskModel(Long id, UserModel user, @NotBlank @Size(min = 1, max = 256) String description) {
		super();
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
