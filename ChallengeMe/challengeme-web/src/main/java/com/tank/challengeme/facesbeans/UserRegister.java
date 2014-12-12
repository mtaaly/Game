package com.tank.challengeme.facesbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.tank.challengeme.dto.UserDTO;
import com.tank.challengeme.service.UserService;

@ManagedBean
@SessionScoped
public class UserRegister {
	@ManagedProperty("#{userService}")
	private UserService userService;

	private UserDTO user = new UserDTO();



	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	/**
	 * @return
	 */
	public String register() {
		// Calling Business Service
		userService.insert(user.getEmail(),user.getName(), user.getPassword());
		// Add message
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage("The Employee " + this.user.getName()
						+ " Is Registered Successfully"));
		return "";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
