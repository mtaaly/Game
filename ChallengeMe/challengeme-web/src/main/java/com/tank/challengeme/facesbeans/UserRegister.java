package com.tank.challengeme.facesbeans;

import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.challengeme.entities.User;
import com.tank.challengeme.dto.UserDTO;
import com.tank.challengeme.service.UserService;

@ManagedBean
@RequestScoped
public class UserRegister {
	@ManagedProperty("#{userService}")
	private UserService userService;

	private List<UserDTO> userliste;
	public List<UserDTO> getUserliste() {
		this.userliste=new LinkedList<UserDTO>();
		List<User> users=userService.getUserListe();
		for (User user : users) {
			this.userliste.add(UserDTO.toUserDTO(user));
		}
		return userliste;
	}

	public void setUserliste(List<UserDTO> userliste) {
		this.userliste = userliste;
	}

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
		// FacesContext.getCurrentInstance().addMessage(
		// null,
		// new FacesMessage("The Employee " + this.user.getName()
		//				+ " Is Registered Successfully"));
		return "/showUser.xhtml?faces-redirect=true";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
