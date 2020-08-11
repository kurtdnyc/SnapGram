package dev.snapgram.beans;

import java.util.Set;

public class Tag {
	
	private int tagId;
	private String tagName;
	private Set<Photo> photos;
	
	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tag(int tagId, String tagName) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	public Set<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagName=" + tagName + ", photos=" + photos + "]";
	}
	
	
	
	

}
