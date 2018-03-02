package org.wecancodeit.columbus.ReviewsFull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

public class ReviewsFullControllerTest {
	private Long id = 42L;
	
	@InjectMocks
	private ReviewsFullController underTest;
	
	@Mock
	private CategoryRepository categoryRepo;
	
	@Mock
	private ReviewsRepository reviewRepo;
	
	@Mock
	private Model model;
	
	@Mock
	private Review oneReview;
	
	@Mock
	private Review twoReview;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldGetASingleReviewModel() {
		when(reviewRepo.findOne(id)).thenReturn(oneReview);
		underTest.getAReview(id, model);
	}
	
	@Test
	public void shouldGetAllReviewsModel() {
		Collection<Review>allReviews = Arrays.asList(oneReview, twoReview);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		underTest.getAllReviews(model);
		
	}
	
}
