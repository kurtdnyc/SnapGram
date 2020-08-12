package dev.snapgram.entities;

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
	private int userId;
	
	@ManyToMany
	@JoinTable(name = "photo_tags",
    joinColumns = { @JoinColumn(name = "t_id") },
    inverseJoinColumns = { @JoinColumn(name = "p_id") })
	private Set<Tag> tags;
	
	public Photo() {
		super();
	}
	
	public Photo(int photoId, String photoUrl, String photoName, String photoDescription, int userId) {
		super();
		this.photoId = photoId;
		this.photoUrl = photoUrl;
		this.photoName = photoName;
		this.photoDescription = photoDescription;
		this.userId = userId;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "Photo [photoId=" + photoId + ", photoUrl=" + photoUrl + ", photoName=" + photoName
				+ ", photoDescription=" + photoDescription + ", userId=" + userId + ", tags=" + tags + "]";
	}
	
	

}
