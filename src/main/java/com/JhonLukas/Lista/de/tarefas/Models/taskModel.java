package com.JhonLukas.Lista.de.tarefas.Models;

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
public class taskModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	@JoinColumn(name = "user_id", nullable = false, updatable = false)
	private Long id;
	@ManyToOne
	private userModel user;
	@NotBlank
	@Column(name = "description", length = 256)
	@Size(min = 1, max = 256)
	private String description;
}
