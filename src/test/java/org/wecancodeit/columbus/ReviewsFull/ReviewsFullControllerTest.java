package org.wecancodeit.columbus.ReviewsFull;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;

public class ReviewsFullControllerTest {

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
	
}
