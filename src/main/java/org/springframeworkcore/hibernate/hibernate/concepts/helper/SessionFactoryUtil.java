package org.springframeworkcore.hibernate.hibernate.concepts.helper;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframeworkcore.hibernate.hibernate.concepts.embedable.ClassA;
import org.springframeworkcore.hibernate.hibernate.concepts.embedable.ClassB;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.Customer;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.TravelPackage;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetomany.Address;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetomany.Passport;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.PassportForPerson;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.Person;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class SessionFactoryUtil {

    private static SessionFactory sessionFactory;
    private static Properties properties;
    private static HikariDataSource dataSource;

    static {
        String dbPassword = System.getenv("MYSQL_DB_PASSWORD");
        if (dbPassword == null) {
            throw new IllegalStateException("Environment variable MYSQL_DB_PASSWORD not set!");
        }

        // Configure HikariCP
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/hibernate_concepts?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC");
        config.setUsername("root");
        config.setPassword(dbPassword);
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);

        dataSource = new HikariDataSource(config);

        // Hibernate properties
        properties = new Properties();
        properties.put(Environment.DATASOURCE, dataSource);
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "create");
//        properties.put(Environment.HBM2DDL_AUTO, "update");
//        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

        // Build SessionFactory
        buildSessionFactory();

        // Shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            shutDownSessionFactory();
            if (dataSource != null && !dataSource.isClosed()) {
                dataSource.close();
            }
        }));
    }

    private static void buildSessionFactory() {
        try {
            Configuration cfg = new Configuration();
            cfg.setProperties(properties);
            cfg.addAnnotatedClass(ClassA.class);
            cfg.addAnnotatedClass(ClassB.class);
            cfg.addAnnotatedClass(Passport.class);
            cfg.addAnnotatedClass(Address.class);
            cfg.addAnnotatedClass(PassportForPerson.class);
            cfg.addAnnotatedClass(Person.class);
            cfg.addAnnotatedClass(TravelPackage.class);
            cfg.addAnnotatedClass(Customer.class);

            System.out.println("Building new SessionFactory...");
            sessionFactory = cfg.buildSessionFactory();
            System.out.println("SessionFactory built successfully.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to build Hibernate SessionFactory", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutDownSessionFactory() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            System.out.println("Closing SessionFactory...");
            sessionFactory.close();
            System.out.println("SessionFactory closed.");
        }
    }
}
