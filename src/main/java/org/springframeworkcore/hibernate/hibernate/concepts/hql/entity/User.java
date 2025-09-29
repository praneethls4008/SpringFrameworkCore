package org.springframeworkcore.hibernate.hibernate.concepts.hql.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="hibernate_hql_users")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@NamedEntityGraph(
		name="User.withPosts",
		attributeNodes = {
				@NamedAttributeNode("posts")
		}
	)

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private Long id;
	
	private String name;
	private String email;
	
	
	@OneToMany(mappedBy="author", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<Post> posts = new ArrayList<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Post> getPosts() {
		return posts;
	}


	public void setPost(List<Post> posts) {
		this.posts = posts;
	}
	
	
	
	
	
	
}
