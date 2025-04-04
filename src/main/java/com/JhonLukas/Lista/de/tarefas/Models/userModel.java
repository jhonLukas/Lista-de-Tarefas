package com.JhonLukas.Lista.de.tarefas.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.NotBlank;

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
	
	public interface UpdateUser{}
	
	public interface CreateUser{}
	
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;

	@Column(name = "username", unique = true, length = 100, nullable = false)
	@NotBlank(groups = {CreateUser.class,UpdateUser.class} )
	private String login;

	@Column(name = "password", length = 20, nullable = false)
	@NotBlank(groups = { CreateUser.class})
	@Size(groups =  {CreateUser.class,UpdateUser.class}, min = 8, max = 60)
	private String password;

	@OneToMany(mappedBy = "user")
	private List<TaskModel> task = new ArrayList <TaskModel>();

	public UserModel(Long id, @NotBlank(groups = { CreateUser.class, UpdateUser.class }) String login,
			@NotBlank(groups = CreateUser.class) @Size(groups = { CreateUser.class,
					UpdateUser.class }, min = 8, max = 60) String password,
			List<TaskModel> task) 
	{
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.task = task;
	}

	public UserModel()
	{
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getLogin() 
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public List<TaskModel> getTask()
	{
		return task;
	}

	public void setTask(List<TaskModel> task) 
	{
		this.task = task;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		return Objects.equals(id, other.id);
	}

}
