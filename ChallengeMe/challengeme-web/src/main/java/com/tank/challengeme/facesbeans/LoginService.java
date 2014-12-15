package com.tank.challengeme.facesbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import com.challengeme.entities.User;
import com.tank.challengeme.dto.UserDTO;
import com.tank.challengeme.service.UserService;

@ManagedBean
@RequestScoped
public class LoginService {
	@ManagedProperty("#{userService}")
	private UserService userService;

	private String login;
	private String password;

	private UserDTO user = new UserDTO();

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String register(ActionEvent event) {
		
		return "/index.xhtml?faces-redirect=true";
	}

	public String processLogin() {
		// Calling Business Service
		User user=userService.login(login,password);
		if(user==null){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "Login failed"));
			return "";
		}
		HttpSession session =(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("username", user.getName());
		// Add message
		// FacesContext.getCurrentInstance().addMessage(
		// null,
		// new FacesMessage("The Employee " + this.user.getName()
		// + " Is Registered Successfully"));
		return "/showUser.xhtml?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
