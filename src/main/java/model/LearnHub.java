package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "LearnHub" database table.
 * 
 */
@Entity
@Table(name="\"LearnHub\"")
@NamedQuery(name="LearnHub.findAll", query="SELECT l FROM LearnHub l")
public class LearnHub implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer pnum;

	private String category;

	private String description;

	private String image;

	private String price;

	private String rating;

	private String title;

	private String type;

	private String url;

	public LearnHub() {
	}

	public Integer getPnum() {
		return this.pnum;
	}

	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}