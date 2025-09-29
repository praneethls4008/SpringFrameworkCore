package org.springframeworkcore.hibernate.hibernate.concepts.hql.demo;

import org.springframeworkcore.hibernate.hibernate.concepts.hql.entity.Comment;
import org.springframeworkcore.hibernate.hibernate.concepts.hql.entity.Post;
import org.springframeworkcore.hibernate.hibernate.concepts.hql.entity.User;
import org.springframeworkcore.hibernate.hibernate.concepts.hql.repo.CommentRepo;
import org.springframeworkcore.hibernate.hibernate.concepts.hql.repo.PostRepo;
import org.springframeworkcore.hibernate.hibernate.concepts.hql.repo.UserRepo;
import org.springframeworkcore.hibernate.hibernate.concepts.helper.SessionFactoryUtil;

import jakarta.persistence.EntityManager;

public class RepositoryDemo {
    public static void main(String[] args) {
    	EntityManager em = SessionFactoryUtil.getEntityManager();
    	UserRepo userRepo = new UserRepo(em);
        PostRepo postRepo = new PostRepo(em);
        CommentRepo commentRepo = new CommentRepo(em);

        // Create a user, post, and comment
        User u = new User();
        u.setName("alice");
        u.setEmail("alice@example.com");
        userRepo.save(u);

        Post p = new Post();
        p.setTitle("Hello World");
        p.setContent("My first post!");
        p.setAuthor(u);
        postRepo.save(p);

        Comment c = new Comment();
        c.setText("Great post!");
        c.setPost(p);
        commentRepo.save(c);

        // Fetch user with posts
        User userWithPosts = userRepo.findByIdWithPosts(u.getId());
        System.out.println(userWithPosts.getName() + "   " + userWithPosts.getPosts().size());

        // Fetch post with comments
        Post postWithComments = postRepo.findByIdWithComments(p.getId());
        System.out.println("Post '" + postWithComments.getTitle() + "' has comments: " + postWithComments.getComments().size());

        // Count comments
        long commentCount = commentRepo.countByPost(p.getId());
        System.out.println("Comment count: " + commentCount);
    }
    
    
}