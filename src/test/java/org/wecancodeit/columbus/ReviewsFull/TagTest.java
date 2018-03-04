package org.wecancodeit.columbus.ReviewsFull;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import javax.annotation.Resource;

import org.junit.Test;

public class TagTest {
	
	@Resource
	private ReviewsRepository reviewsRepo;

	Tag underTest = new Tag("obnoxious");
	Tag underTest2 = new Tag("chill");
	
	Category category = new Category("jazz");

	Review review1 = new Review("a", "b", category, "c", "d", "e", "f", "g", "h", underTest, underTest2);
	Review review2 = new Review("z", "y", category, "q", "r", "s", "t", "u", "v", underTest2);
	
	@Test
	public void shouldReturnTagDescription() {
		String tag1 = underTest.getTag();
		String tag2 = underTest2.getTag();
		assertThat(tag1, is("obnoxious"));
		assertThat(tag2, is("chill"));
	}

	@Test
	public void shouldReturnId() {
		Long id = underTest.getId();
		assertThat(id, is(0L));
	}

}
