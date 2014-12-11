package com.challengeme.register;

import com.challengeme.dao.UserDao;

public class Registrieren {
	
	UserDao dao=new UserDao();
	
	public static void main(String[] args) {
		Registrieren dienst=new Registrieren();
		dienst.dao.insert("maever10@yahoo.fr", "Mabelle", "mabelle");
		System.exit(0);
	}

}
