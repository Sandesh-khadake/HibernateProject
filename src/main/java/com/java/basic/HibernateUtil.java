package com.java.basic;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	static SessionFactory sfactory = null;

	public static SessionFactory getSessionFactory() {
		if (sfactory == null) {
			Configuration conf = new Configuration();
			Properties props = new Properties();
			props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			props.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_revision");
			props.put(Environment.USER, "root");
			props.put(Environment.PASS, "root1234");
			props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");

			props.put(Environment.HBM2DDL_AUTO, "update");
			props.put(Environment.SHOW_SQL, true);

			conf.setProperties(props);
			conf.addAnnotatedClass(Student.class);

			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

			sfactory = conf.buildSessionFactory(registry);
		}
		return sfactory;
	}

}
