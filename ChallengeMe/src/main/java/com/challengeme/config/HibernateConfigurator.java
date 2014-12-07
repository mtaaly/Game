package com.challengeme.config;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateConfigurator {

private static HibernateConfigurator instance;
private final SessionFactory sf;
private final Session session;
	
		public static HibernateConfigurator getInstance(){
			if(instance == null){
				instance = new HibernateConfigurator();
			}
			return instance;
		}
		
		private HibernateConfigurator(){
			
			Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sf = configuration.buildSessionFactory(ssrb.build());
            session=sf.openSession();
            
		}
		
		public SessionFactory getSessionFactory(){
			return sf;
		}
		
		public Session getSession(){
			return session;
		}
		
	
}
