package org.springframeworkcore.hibernate.hibernate.concepts.hql.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframeworkcore.hibernate.hibernate.concepts.hql.entity.User;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class UserRepo {
	private final EntityManager em;
    public UserRepo(EntityManager em) { 
    	this.em = em; 
    }
    
    public User save(User user) {
    	EntityTransaction tx = em.getTransaction();
    	tx.begin();
    	if(user.getId() == null) {
    		em.persist(user);
    	}else {
    		user = em.merge(user);
    	}
    	tx.commit();
    	return user;
    }
    
    public Optional<User> findById(Long id){
    	return Optional.ofNullable(em.find(User.class, id));
    }
    
    public User findByIdWithPosts(Long id) {
    	EntityGraph<?> graph = em.getEntityGraph("User.withPosts");
    	Map<String, Object> hints = new HashMap<>();
    	hints.put("jakarta.persistence.fetchgraph", graph);
    	return em.find(User.class, id, hints);
    }
    
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
    
    public List<User> findAllWithPosts() {
        EntityGraph<?> graph = em.getEntityGraph("User.withPosts");
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u", User.class);
        q.setHint("jakarta.persistence.fetchgraph", graph);
        return q.getResultList();
    }
    
    public Optional<User> findByUsername(String username) {
        TypedQuery<User> q = em.createQuery(
            "SELECT u FROM User u WHERE u.username = :username", User.class
        );
        q.setParameter("username", username);
        return q.getResultStream().findFirst();
    }
    
    
    
}
