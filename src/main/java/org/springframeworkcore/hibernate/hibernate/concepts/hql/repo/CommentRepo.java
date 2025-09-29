package org.springframeworkcore.hibernate.hibernate.concepts.hql.repo;

import java.util.List;
import java.util.Optional;

import org.springframeworkcore.hibernate.hibernate.concepts.hql.entity.Comment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CommentRepo {
	private final EntityManager em;
    public CommentRepo(EntityManager em) { this.em = em; }

    public Comment save(Comment comment) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        if (comment.getId() == null) {
            em.persist(comment);
        } else {
            comment = em.merge(comment);
        }
        tx.commit();
        return comment;
    }

    public Optional<Comment> findById(Long id) {
        return Optional.ofNullable(em.find(Comment.class, id));
    }

    /** Find all comments for a given post */
    public List<Comment> findByPostId(Long postId) {
        return em.createQuery(
            "SELECT c FROM Comment c WHERE c.post.id = :postId ORDER BY c.createdAt ASC",
            Comment.class
        )
        .setParameter("postId", postId)
        .getResultList();
    }

    /** Delete comment by id */
    public void deleteById(Long id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Comment c = em.find(Comment.class, id);
        if (c != null) {
            em.remove(c);
        }
        tx.commit();
    }

    /** Count comments for a post */
    public long countByPost(Long postId) {
        return em.createQuery(
            "SELECT COUNT(c) FROM Comment c WHERE c.post.id = :postId", Long.class
        )
        .setParameter("postId", postId)
        .getSingleResult();
    }
}
