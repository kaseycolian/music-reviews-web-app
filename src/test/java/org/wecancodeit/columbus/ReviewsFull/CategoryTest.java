package org.wecancodeit.columbus.ReviewsFull;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

//import java.util.Collection;

import org.junit.Test;

public class CategoryTest {

	Category underTest = new Category("punk");

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