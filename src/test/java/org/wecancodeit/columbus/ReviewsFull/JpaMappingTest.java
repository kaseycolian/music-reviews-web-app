package org.wecancodeit.columbus.ReviewsFull;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JpaMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ReviewsRepository reviewsRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private TagRepository tagRepo;

	@Resource
	private CommentRepository commentRepo;

	Category oneGenre = new Category("ska");
	Tag tag1 = new Tag("nice");
	Review review = new Review("aa", "bb", oneGenre, "cc", "dd", "ee", "ff", "gg", "hh", tag1);

	// Test for relationship between review & comments - one review to many comments

	// FIX THIS TEST LOGIC - IT AIN'T RIGHT!
	@Test
	public void shouldSaveAndLoadNewComment() {
		Category newCategory = new Category("");
		Tag newTag = new Tag("");
		Review newReview = new Review("", "", newCategory, "", "", "", "", "", "", newTag);
		Comment newComment = new Comment("this is great!", newReview, "catsMcGee");
		newReview = reviewsRepo.save(newReview);
		newComment = commentRepo.save(newComment);

		long commentId = newComment.getId();

		entityManager.flush();
		entityManager.clear();

		newComment = commentRepo.findOne(commentId);

		assertThat(newComment.getId(), is(commentId));

	}

	@Test
	public void shouldSaveAndLoadNewReview() {
		oneGenre = categoryRepo.save(oneGenre);
		tag1 = tagRepo.save(tag1);
		review = reviewsRepo.save(review);

		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		review = reviewsRepo.findOne(reviewId);

		assertThat(review.getName(), is("aa"));
	}

	@Test
	public void shouldSaveCategoryToReviewRelationshipOneCategoryToMany() {
		Category oneGenre = new Category("ska");
		categoryRepo.save(oneGenre);
		Tag tag1 = new Tag("yay");
		tagRepo.save(tag1);

		long genreId = oneGenre.getId();

		Review review1 = new Review("aa", "bb", oneGenre, "cc", "dd", "ee", "ff", "gg", "hh", tag1);
		review1 = reviewsRepo.save(review1);
		Review review2 = new Review("zz", "yy", oneGenre, "xx", "ww", "vv", "uu", "tt", "ss", tag1);
		review2 = reviewsRepo.save(review2);

		entityManager.flush();
		entityManager.clear();

		oneGenre = categoryRepo.findOne(genreId);
		assertThat(oneGenre.getReviews(), containsInAnyOrder(review1, review2));

	}

	@Test // testing for saving & loading tag as well
	public void shouldSaveManyTagsToManyReviewsAndManyReviewsToManyTags() {
		Category oneGenre = new Category("jazz");
		categoryRepo.save(oneGenre);

		Tag oneTag = new Tag("loud");
		tagRepo.save(oneTag);
		Tag twoTag = new Tag("quiet");
		tagRepo.save(twoTag);

		Review review1 = new Review("11", "22", oneGenre, "33", "44", "55", "66", "77", "88", oneTag, twoTag);
		reviewsRepo.save(review1);
		Review review2 = new Review("ab", "bc", oneGenre, "de", "fg", "hi,", "jk", "lm", "no", oneTag);
		reviewsRepo.save(review2);

		entityManager.flush();
		entityManager.clear();

		assertThat(review1.getTags(), containsInAnyOrder(oneTag, twoTag));
		assertThat(review2.getTags(), contains(oneTag));
	}

	@Test
	public void shouldGetIdFromTag() {
		Tag tag1 = tagRepo.save(new Tag("amazing"));
		Tag tag2 = tagRepo.save(new Tag("sweet"));

		long tagId = tag1.getId();
		long tagId2 = tag2.getId();

		entityManager.flush();

		assertThat(tagId2, is(greaterThan(0L)));
		assertThat(tagId, is(greaterThan(0L)));
	}

	@Test
	public void shouldGetReviewFromTagId() {
		Category oneGenre = categoryRepo.save(new Category("hip"));

		Tag tag1 = tagRepo.save(new Tag("amazing"));
		long tag1Id = tag1.getId();

		Review review1 = new Review("11", "22", oneGenre, "33", "44", "55", "66", "77", "88", tag1);
		reviewsRepo.save(review1);
		Review review2 = new Review("ab", "bc", oneGenre, "de", "fg", "hi,", "jk", "lm", "no", tag1);
		review2 = reviewsRepo.save(review2);

		entityManager.flush();
		entityManager.clear();

		tag1 = tagRepo.findOne(tag1Id);
		assertThat(tag1.getReview(), containsInAnyOrder(review1, review2));

	}

	@Test
	public void shouldGetReviewFromTagName() {
		Category oneGenre = categoryRepo.save(new Category("hip"));

		Tag tag1 = tagRepo.save(new Tag("amazing"));
		long tag1Id = tag1.getId();

		Review review1 = new Review("11", "22", oneGenre, "33", "44", "55", "66", "77", "88", tag1);
		reviewsRepo.save(review1);
		Review review2 = new Review("ab", "bc", oneGenre, "de", "fg", "hi,", "jk", "lm", "no", tag1);
		review2 = reviewsRepo.save(review2);

		entityManager.flush();
		entityManager.clear();

		tag1 = tagRepo.findOne(tag1Id);

		Collection<Review> reviewsForTag = reviewsRepo.findByTagsContains(tag1);
		assertThat(reviewsForTag, containsInAnyOrder(review1, review2));

	}
}
