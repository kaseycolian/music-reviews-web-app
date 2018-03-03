package org.wecancodeit.columbus.ReviewsFull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest

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
	
	@Mock
	private Category oneGenre;
	
	@Mock
	private Category twoGenre;
	
	@Mock
	Iterable<Category> allGenres;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldGetASingleReviewModel() {
		when(reviewRepo.findOne(id)).thenReturn(oneReview);
		underTest.getAReview(id, model);
		verify(model).addAttribute("review", oneReview);
	}
	
	@Test
	public void shouldGetAllReviewsModel() {
		Collection<Review>allReviews = Arrays.asList(oneReview, twoReview);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		underTest.getAllReviews(model);
		verify(model).addAttribute("reviews", oneReview);
		verify(model).addAttribute("reviews", twoReview);
		}
	
//	@Test
//	public void shouldGetASingleCategoryModel() {
//		when(categoryRepo.findOne(id)).thenReturn(oneReview);
//		underTest.getACategory(id, model);
//		
//	}
	
	@Test
	public void shouldShowAllCategories() {
//		Collection<Category>allGenres = Arrays.asList(oneGenre, twoGenre);
		Category oneGenre = new Category("ska");
		categoryRepo.save(oneGenre);
//		long oneGenreId = oneGenre.getId();
		
		Category twoGenre = new Category("punk");
		categoryRepo.save(twoGenre);
//		long twoGenreId = twoGenre.getId();
		
		Iterable<Category> allGenres =  categoryRepo.findAll();
		
//		when (categoryRepo.findAll()).thenReturn(oneGenre, twoGenre);
		assertThat(allGenres, containsInAnyOrder("ska", "punk"));
//		when(categoryRepo.findAll()).thenReturn(allGenres);
//		underTest.getAllCategories(model);
		
	}
	
}
