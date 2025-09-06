package org.springframeworkcore.hibernate;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframeworkcore.hibernate.model.Customer;

public class runApp {
	public static void main(String[] args) {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
//		dataSource.setUsername("root");
//        dataSource.setPassword("password");

        
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("hibernateCustomer");
		customer.setEmail("hibernate@email.com");
		
		String dbPassword = System.getenv("MYSQL_DB_PASSWORD");
        if (dbPassword == null) {
            throw new IllegalStateException("Environment variable MYSQL_DB_PASSWORD not set!");
        }
        
        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.put("hibernate.connection.url", 
            "jdbc:mysql://localhost:3306/spring_framework_core?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", dbPassword);

        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");

        
        Configuration cfg = new Configuration();
        cfg.setProperties(properties);
        cfg.addAnnotatedClass(org.springframeworkcore.hibernate.model.Customer.class);
        cfg.addAnnotatedClass(org.springframeworkcore.hibernate.model.Order.class);
        cfg.addAnnotatedClass(org.springframeworkcore.hibernate.model.OrderItem.class);
        cfg.addAnnotatedClass(org.springframeworkcore.hibernate.model.Product.class);
        
		SessionFactory sessionFactory = cfg.buildSessionFactory();
	

        
        Session session = sessionFactory.openSession();
        
        Transaction tx =session.beginTransaction();
        
        //session.persist(customer);
        Customer c = session.get(Customer.class, 1);
        List<Customer> cList = session.createQuery("from Customer", Customer.class).list();
        System.out.println(c);
        System.out.println(cList);
        
        tx.commit();
		
	}
}
