package com.tank.challengeme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.challengeme.entities.User;

@Controller
public class UserController {
	@Autowired
	private ServiceLocator services;

	@RequestMapping(value = "/showMessage")
	public String showMessage(Model model) {
		List<User> users = services.getUserService().getAllUsers();
		StringBuilder usersName = new StringBuilder();
		if (users != null && !users.isEmpty()) {
			for (User user : users) {
				usersName.append(user.getName()).append(";");
			}
		}
		model.addAttribute("message", usersName.toString());
		return "showMessage";
	}

}
