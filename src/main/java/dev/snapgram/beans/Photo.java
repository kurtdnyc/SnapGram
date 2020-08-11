package dev.snapgram.beans;

import java.util.Set;

public class Photo {
	
	private int photoId;
	private String photoUrl;
	private String photoName;
	private String photoDescription;
	private int userId;
	private Set<Tag> tags;
	
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Photo(int photoId, String photoUrl, String photoName, String photoDescription, int userId, Set<Tag> tags) {
		super();
		this.photoId = photoId;
		this.photoUrl = photoUrl;
		this.photoName = photoName;
		this.photoDescription = photoDescription;
		this.userId = userId;
		this.tags = tags;
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
