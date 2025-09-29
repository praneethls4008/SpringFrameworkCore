package org.springframeworkcore.hibernate.hibernate.concepts.hql.repo.spring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframeworkcore.hibernate.hibernate.concepts.hql.entity.Comment;


@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findByPostIdOrderByCreatedAtAsc(Long postId);
}
