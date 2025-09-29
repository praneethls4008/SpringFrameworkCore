package org.springframeworkcore.hibernate.hibernate.concepts.hql.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframeworkcore.hibernate.hibernate.concepts.hql.entity.Post;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class PostRepo {

	private final EntityManager em;
	
    public PostRepo(EntityManager em) { 
    	this.em = em; 
    }
    
    public Post save(Post post) {
    	EntityTransaction tx = em.getTransaction();
    	tx.begin();
    	if(post.getId()==null) {
    		em.persist(post);
    	}else {
    		em.merge(post);
    	}
    	tx.commit();
    	return post;
    }
    
    public Optional<Post> findByid(Long id){
    	return Optional.ofNullable(em.find(Post.class, id));
    }
    
    public Post findByIdWithComments(Long id) {
        EntityGraph<?> graph = em.getEntityGraph("Post.withComments");
        Map<String, Object> hints = new HashMap<>();
        hints.put("jakarta.persistence.fetchgraph", graph);
        return em.find(Post.class, id, hints);
    }
    
    public List<Post> findAll() {
        return em.createQuery("SELECT p FROM Post p", Post.class).getResultList();
    }

    /** Find posts with comments for a given user */
    public List<Post> findPostsByUserWithComments(String username) {
        EntityGraph<?> graph = em.getEntityGraph("Post.withComments");
        TypedQuery<Post> q = em.createQuery(
            "SELECT p FROM Post p JOIN p.author u WHERE u.username = :username", Post.class
        );
        q.setParameter("username", username);
        q.setHint("jakarta.persistence.fetchgraph", graph);
        return q.getResultList();
    }

    /** Search posts by keyword */
    public List<Post> searchPosts(String keyword) {
        return em.createQuery(
            "SELECT p FROM Post p WHERE lower(p.title) LIKE :kw OR lower(p.content) LIKE :kw",
            Post.class
        )
        .setParameter("kw", "%" + keyword.toLowerCase() + "%")
        .getResultList();
    }
    
}
