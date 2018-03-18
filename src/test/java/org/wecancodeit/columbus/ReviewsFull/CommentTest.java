package org.wecancodeit.columbus.ReviewsFull;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CommentTest {
	Tag testTag = new Tag("");
	Category testCategory = new Category("");
	Review testReview = new Review("", "", testCategory, "", "", "", "", "", "", testTag);
	Comment testComment = new Comment("great", testReview, "Tank");

	@Test
	public void shouldReturnCommentDetails() {
		String commentDetails = testComment.getCommentDetails();
		assertThat(commentDetails, is("great"));
	}

	@Test
	public void shoudlReturnReviewForComment() {
		Review testReviews = testComment.getReview();
		assertThat(testReviews, is(testReview));

	}

	@Test
	public void shouldReturnUserHandle() {
		String userHandle = testComment.getUserHandle();
		assertThat(userHandle, is("Tank"));
	}

	@Test
	public void shoudlReturnId() {
		Long id = testComment.getId();
		assertThat(id, is(0L));
	}
}