package dev.snapgram.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id")
	private int userId;
	
	@Column(name = "username", unique=true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String fName;
	
	@Column(name = "last_name")
	private String lName;
	
	@OneToMany(mappedBy = "user")
	private Set<Photo> photos = new HashSet<Photo>();
	
	public User() {
		super();
	}

	public User(int userId, String username, String password, String fName, String lName) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName =lName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", " + (username != null ? "username=" + username + ", " : "")
				+ (password != null ? "password=" + password + ", " : "")
				+ (fName != null ? "fName=" + fName + ", " : "") + (lName != null ? "lName=" + lName + ", " : "")
				+ (photos != null ? "photos=" + photos : "") + "]";
	}


	

}
