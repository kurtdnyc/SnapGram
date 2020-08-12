package dev.snapgram.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="tag")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="t_id")
	private int tagId;
	
	@Column(name = "tag_name")
	private String tagName;
	
	@ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Photo> photos;
	
	public Tag() {
		super();
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
