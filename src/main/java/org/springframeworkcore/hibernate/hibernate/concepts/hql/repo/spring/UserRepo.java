package org.springframeworkcore.hibernate.hibernate.concepts.hql.repo.spring;


import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframeworkcore.hibernate.hibernate.concepts.hql.entity.User;



@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @EntityGraph(value = "User.posts", type = EntityGraph.EntityGraphType.FETCH)
    Optional<User> findWithPostsById(Long id);
}