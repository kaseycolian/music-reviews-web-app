package org.wecancodeit.columbus.ReviewsFull;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
	
	@Test
	public void shouldSaveAndLoadNewReview() {
		Category oneGenre = new Category("ska");
		oneGenre = categoryRepo.save(oneGenre);
		Review review = new Review ("aa", "bb", oneGenre, "cc", "dd", "ee", "ff", "gg");
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
		long genreId = oneGenre.getId();
		
		Review review1 = new Review ("aa", "bb", oneGenre, "cc", "dd", "ee", "ff", "gg");
		review1 = reviewsRepo.save(review1);
		Review review2 = new Review ("zz", "yy", oneGenre, "xx", "ww", "vv", "uu", "tt");		
		review2 = reviewsRepo.save(review2);
		
		entityManager.flush();
		entityManager.clear();
		
		oneGenre = categoryRepo.findOne(genreId);
		assertThat(oneGenre.getReviews(), containsInAnyOrder(review1, review2));
		
	}
	
	@Test //Many Reviews to One Category
	public void shouldSaveManyReviewToOnlyOneCategory() {
		
		
		
		
	}
}
