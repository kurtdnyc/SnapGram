package dev.snapgram.beans;

public class Tag {
	
	private int tagId;
	private String tagName;
	private int photoId;
	
	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tag(int tagId, String tagName, int photoId) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.photoId = photoId;
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
	public int getPhotoId() {
		return photoId;
	}
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagName=" + tagName + ", photoId=" + photoId + "]";
	}
	
	

}
