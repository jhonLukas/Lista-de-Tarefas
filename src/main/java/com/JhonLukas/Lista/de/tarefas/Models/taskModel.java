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

	

}
