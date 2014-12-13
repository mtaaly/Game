package com.tank.challengeme.dto;

import com.challengeme.entities.User;

public class UserDTO {
	private  int id;
	private String name;
	private String password;
	private String email;
	
	/*
	 * gibt den Id zur�ck
	 */
	public int getId() {
		return id;
	}
	/*
	 * setzt ein Nummer f�r die Id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * gibt den Name zur�ck
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * setzt einen Name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * gibt den Password zur�ck
	 */
	public String getPassword() {
		return password;
	}
	
	/*
	 * setzt einen Password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * gibt den Email zur�ck
	 */
	public String getEmail() {
		return email;
	}
	
	/*
	 * setzt eine Email adresse.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	public static UserDTO toUserDTO(User user){
		UserDTO dto=new UserDTO();
		dto.setEmail(user.getEmail());
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setPassword(user.getPassword());
		return dto;
	}

}
