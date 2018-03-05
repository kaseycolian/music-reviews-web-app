package org.wecancodeit.columbus.ReviewsFull;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id;
	private String category;
	
	
	@OneToMany (mappedBy="category")
	private Collection<Review> reviews;
	
	public Collection<Review> getReviews() {
		return reviews;
	}
	public long getId() {
		return id;
	}
	@Override 
	public String toString(){
		return category;
	}

	public Category(String category) {
		this.category = category;
	}
	public String getCategory() {
		return category;
	}

	@SuppressWarnings ("unused")
	private Category() {
		
	}
	
	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		return id == ((Category) obj).id;
	}
	
	
	
}
