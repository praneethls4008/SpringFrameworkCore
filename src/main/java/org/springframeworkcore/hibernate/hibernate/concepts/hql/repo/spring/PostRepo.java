package org.springframeworkcore.hibernate.hibernate.concepts.hql.repo.spring;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframeworkcore.hibernate.hibernate.concepts.hql.entity.Post;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    @EntityGraph(value = "Post.comments", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Post> findWithCommentsById(Long id);

    @Query("SELECT p FROM Post p JOIN p.author u WHERE u.username = :username")
    List<Post> findPostsByUsername(String username);
}