package org.wecancodeit.columbus.ReviewsFull;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

//import java.util.Collection;

import org.junit.Test;

public class CategoryTest {

	Category underTest = new Category("punk");
	
	Review review1 = new Review ("bert", "words", underTest , "image url", "1500", "3000", "video", "footer");
	Review review2 = new Review ("cat", "stuff", underTest, "images", "999", "111", "film", "footnote");
	
	
	@Test
	public void shouldReturnCategory() {
		String category = underTest.getCategory();
		assertThat(category, is("punk"));
	
	}
	
	@Test
	public void shouldReturnId() {
	Long id = underTest.getId();
	assertThat(id, is(0L));
			
	}
	
//	@Test 
//	public void shouldReturnReview() {
//		Collection underTest = new Collection<Review> reviews;
		
//		underTest = new Collection<Review> reviews;
//		Collection<Review> result = underTest.getReviews();
//		assertThat(result, containsInAnyOrder(final));
		
//		  Collection<Review>= new Review("bert", "words", "image url" , underTest, "1500", "3000", "video", "footer");
//	        Collection<Review> b = expectedAnswer;
//
//	        assertThat(a, both(hasItems(b)).and(hasSize(b.size())))
//	}
}
	
	