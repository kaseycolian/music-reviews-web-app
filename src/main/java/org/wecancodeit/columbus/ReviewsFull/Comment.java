package org.wecancodeit.columbus.ReviewsFull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private long id;

	@Lob
	private String commentDetails;
	private String userHandle;

	// one review to many comments
	// many comments to one review
	@ManyToOne // (mappedBy = "comment")
	private Review review;

	// test for userHandle
	public Comment(String commentDetails, Review review, String userHandle) {
		this.commentDetails = commentDetails;
		this.review = review;
		this.userHandle = userHandle;
	}

	public String getCommentDetails() {
		return commentDetails;
	}

	public String getUserHandle() {
		return userHandle;
	}

	public long getId() {
		return id;
	}

	public Review getReview() {
		return review;
	}

	public Comment() {

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
		return id == ((Comment) obj).id;
	}

}
