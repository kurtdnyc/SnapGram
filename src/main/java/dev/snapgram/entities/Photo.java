package dev.snapgram.entities;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name ="photo")
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private int photoId;
	
	
	@Column(name = "photo_url")
	private String photoUrl;
	
	@Column(name = "photo_name")
	private String photoName;
	
	@Column(name = "photo_description")
	private String photoDescription;
	

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "u_id")
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "photo_tags",joinColumns = { @JoinColumn(name = "t_id") }, inverseJoinColumns = { @JoinColumn(name = "p_id") })
	private Set<Tag> tags = new HashSet<Tag>();
	
	public Photo(int photoId, String photoUrl, String photoName, String photoDescription, User user, Set<Tag> tags) {
		super();
		this.photoId = photoId;
		this.photoUrl = photoUrl;
		this.photoName = photoName;
		this.photoDescription = photoDescription;
		this.user = user;
		this.tags = tags;
	}

	public Photo() {
		super();
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getPhotoDescription() {
		return photoDescription;
	}

	public void setPhotoDescription(String photoDescription) {
		this.photoDescription = photoDescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}



	

	

}
