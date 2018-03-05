package org.wecancodeit.columbus.ReviewsFull;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

//import java.util.Collection;

import org.junit.Test;

public class CategoryTest {

	Category underTest = new Category("punk");
	Tag tag1 = new Tag("blah");

	Review review1 = new Review("bert", "words", underTest, "image url", "1500", "3000", "video", "footer", "pics",
			tag1);
	Review review2 = new Review("cat", "stuff", underTest, "images", "999", "111", "film", "footnote", "pic", tag1);

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
}