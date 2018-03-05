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
import static org.hamcrest.Matchers.is;
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
	private TagRepository tagRepo;

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
	private Tag oneTag;

	@Mock
	Iterable<Category> allGenres;

	@Mock
	Iterable<Tag> tags;

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
	public void shouldGetASingleGenreModel() {
		when(categoryRepo.findOne(id)).thenReturn(oneGenre);
		underTest.getACategory(id, model);
		verify(model).addAttribute("category", oneGenre);
			
	}

	@Test
	public void shouldAddAllGenresToModel() {
		when(categoryRepo.findAll()).thenReturn(allGenres);
		underTest.getAllCategories(model);
		verify(model).addAttribute("genres", allGenres);
	}
	
	@Test
	public void shouldAddASingleTagToModel() {
		when(tagRepo.findOne(id)).thenReturn(oneTag);
		underTest.getATag(id, model);
		verify(model).addAttribute("tag", oneTag);
	}

	@Test
	public void shouldReturnSingleReviewTemplate() {
		String result = underTest.getAReview(id, model);
		assertThat(result, is("review"));
	}

	@Test
	public void shouldReturnSingleGenreTemplate() {
		String result = underTest.getACategory(id, model);
		assertThat(result, is("category"));

	}

	@Test
	public void shouldReturnAllGenresTemplate() {
		String result = underTest.getAllCategories(model);
		assertThat(result, is("genres"));

	}

	@Test
	public void ShouldReturnTagsTemplate() {
		String result = underTest.getAllTags(model);
		assertThat(result, is("tags"));
	}
}
