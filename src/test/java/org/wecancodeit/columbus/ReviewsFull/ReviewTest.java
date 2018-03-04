package org.wecancodeit.columbus.ReviewsFull;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
 
import org.junit.Test;

public class ReviewTest {
	Tag tag1 = new Tag("quiet");
	Tag tag2 = new Tag("loud");
	Category category = new Category("rock");
	Review underTest = new Review ("bert", "words", category , "image url", "1500", "3000", "video", "footer", "pics", tag1, tag2);
	Review underTest2 = new Review ("cat", "stuff", category, "images", "999", "111", "film", "footnote", "pic");
	@Test
	public void shouldReturnImageUrl() {
		String imageUrl = underTest.getImageUrl();
		assertThat(imageUrl, is("words"));
							
	}
	
	@Test
	public void shouldReturnFirstRelease() {
		String firstRelease = underTest.getFirstRelease();
		assertThat(firstRelease, is ("3000"));
		
	}
	
	@Test 
	public void shouldReturnLastRelease() {
		String lastRelease = underTest.getLastRelease();
		assertThat(lastRelease, is("video"));
	}

	@Test
	public void shouldReturnYouTubeUrl() {
		String youTubeUrl = underTest.getYouTubeUrl();
		assertThat (youTubeUrl, is ("footer"));
	}
	
	@Test
	public void shouldReturnFooterUrl() {
		String footerUrl = underTest.getFooterUrl();
		assertThat(footerUrl, is("1500"));
	}

	@Test
	public void shouldReturnName() {
		String name = underTest.getName();
		assertThat(name, is("bert"));
	}
	
	@Test
	public void shouldReturnContent() {
		String content = underTest.getContent();
		assertThat(content, is("image url"));
	}
	
	@Test //fix with casting or something = returning location
	public void shoudlReturnCategory() {
		Category category = underTest.getCategory();
		assertThat(category, is("rock"));
		
	}
	@Test
	public void shouldReturnTags() {
		Review underTest = underTest.getTags();
		assertThat(tag1, is("loud"));
	}
	
	@Test
	public void shouldReturnMembersPic() {
		String membersPic = underTest.getMembersPic();
		assertThat(membersPic, is("pics"));
	}
	
	
}