package org.wecancodeit.columbus.reviews.data;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String tagDescription;

	@ManyToMany(mappedBy = "tags")
	private Collection<Review> reviews;

	public Collection<Review> getReview() {
		return reviews;
	}

	public long getId() {
		return id;
	}

	public String getTag() {
		return tagDescription;
	}

	// test for Review...reviews
	public Tag(String tagDescription, Review... reviews) {
		this.tagDescription = tagDescription;
		this.reviews = new HashSet<>(asList(reviews));
	}

	@SuppressWarnings("unused")
	private Tag() {
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
		return id == ((Tag) obj).id;
	}

}
