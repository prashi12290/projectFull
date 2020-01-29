package com.app.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "comments")
public class Comments {
	
	
	private Integer cmId;
	private User user;
	private Post post;
	private String comment;
	private Date createdAt;
	
	public Comments() {
		System.out.println("inside ctor of "+getClass().getName());
	}

	public Comments(String comment, Date createdAt) {
		super();
		this.comment = comment;
		this.createdAt = createdAt;
	}
    
	public Comments(User u,Post p,String comment) {
		this.user=u;
		this.post=p;
		this.comment=comment;
		this.createdAt=java.util.Calendar.getInstance().getTime();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cm_id")
	public Integer getCmId() {
		return cmId;
	}

	public void setCmId(Integer cmId) {
		this.cmId = cmId;
	}

	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "post_id")
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Comments [cmId=" + cmId + ", user=" + user + ", post=" + post + ", comment=" + comment
				+ ", createdAt=" + createdAt + "]";
	}
	
	
}
