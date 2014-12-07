package com.challengeme.config;

import org.hibernate.Transaction;

public class TransaktionContainer {

	public static Transaction getTransaktion() {
		return HibernateConfigurator.getInstance().getSession()
				.beginTransaction();
	}
}
