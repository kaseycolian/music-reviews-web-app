package org.wecancodeit.columbus.ReviewsFull;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
 
import org.junit.Test;

public class ReviewTest {

	Category category = new Category("rock");
	Review underTest = new Review ("bert", "words", category , "image url", "1500", "3000", "video", "footer");
	Review underTest2 = new Review ("cat", "stuff", category, "images", "999", "111", "film", "footnote");
	@Test
	public void shouldReturnImageUrl() {
		String imageUrl = underTest.getImageUrl();
		assertThat(imageUrl, is("image url"));
							
	}
	
	@Test
	public void shouldReturnFirstRelease() {
		String firstRelease = underTest.getFirstRelease();
		assertThat(firstRelease, is ("1500"));
		
	}
	
	@Test 
	public void shouldReturnLastRelease() {
		String lastRelease = underTest.getLastRelease();
		assertThat(lastRelease, is("3000"));
	}

	@Test
	public void shouldReturnYouTubeUrl() {
		String youTubeUrl = underTest.getYouTubeUrl();
		assertThat (youTubeUrl, is ("video"));
	}
	
	@Test
	public void shouldReturnFooterUrl() {
		String footerUrl = underTest.getFooterUrl();
		assertThat(footerUrl, is("footer"));
	}

	@Test
	public void shouldReturnName() {
		String name = underTest.getName();
		assertThat(name, is("bert"));
	}
	
	@Test
	public void shouldReturnContent() {
		String content = underTest.getContent();
		assertThat(content, is("words"));
	}
	
	@Test //fix with casting or something = returning location
	public void shoudlReturnCategory() {
		Category category = underTest.getCategory();
		assertThat(category, is("rock"));
		
	}
}