package com.app.entity;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "category")
public class Category {
	private Integer ctId;
	private String name;
	private String description;
	private List<Post> post;
	public Category() {
		System.out.println("inside ctor of "+getClass().getName());
	}

	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ct_id")
	public Integer getCtId() {
		return ctId;
	}

	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	


	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}
	
	public void addPost(Post p) {
		post.add(p);
		p.setCategory(this);
	}

	public void removePost(Post p) {
		post.remove(p);
		p.setCategory(null);
	}

	@Override
	public String toString() {
		return "Category [ctId=" + ctId + ", name=" + name + ", description=" + description + "]";
	}
	
	

}
