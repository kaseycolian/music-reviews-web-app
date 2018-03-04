package org.wecancodeit.columbus.ReviewsFull;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator implements CommandLineRunner {

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private ReviewsRepository reviewsRepo;
	
	@Resource
	private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Tag tag1 = tagRepo.save(new Tag("Relaxing"));
		Tag tag2 = tagRepo.save(new Tag("Adventerous"));

		
		Category idm = categoryRepo.save(new Category("IDM"));
		Category drone = categoryRepo.save(new Category("Drone"));
		
		Review review1 = new Review ("Aphex Twin", "./images/aphexTwin.jpg", idm, "The sound of Aphex Twin is more intense, with a beat that can drive concentration.  According to Wikipedia: 'Richard David James (born 18 August 1971), best known by his recording alias Aphex Twin, is a Cornish (English) electronic musician, known for his influential and idiosyncratic work in styles such as ambient techno and IDM in the 1990s, for which he received widespread critical acclaim. He is also the co-founder of Rephlex Records with Grant Wilson-Claridge.'[1]", "https://en.wikipedia.org/wiki/Aphex_Twin", "1991", "2014", "https://www.youtube.com/embed/S5UBYOv1G9A", tag2);
		review1 = reviewsRepo.save(review1);
		Review review2 = new Review ("Boards of Canada", "./images/boardsOfCanada.jpg", idm, "Boards of Canada produce a laid back sound with an overall calming effect, providing a soothing introspective melody to maintain focus.  According to Wikipedia: \"The music of Boards of Canada incorporates elements such as vintage analogue synthesisers, hip hop-inspired breakbeats, and samples from 1970s public broadcasting programmes and other outdated media; it has been described as exploring themes of nostalgia, childhood memory, and nature. In 2012, FACT called them 'one of the best-known and best-loved electronic acts of the last two decades.'\"[1]", "https://en.wikipedia.org/wiki/Boards_of_Canada", "1995", "2013", "https://www.youtube.com/embed/XaJn3QqiIUc", tag1);
		review2 = reviewsRepo.save(review2);
		Review review3 = new Review ("Godspeed You! Black Emperor", "./images/godspeedYou!BlackEmporer.jpg", drone, "Godspeed You! Black Emperor is a relaxing sound that allows your mind to stay focused on the work athand while allowing your thoughts to expand as the musical journey progresses.  It \"is a Canadian experimental music collective which originated in Montreal, Quebec in 1994. The group releases recordings through Constellation, an independent record label also located in Montreal. After the release of their debut album in 1997, the group toured regularly from 1998 to 2002. In 2003, the band announced an indefinite hiatus in order for members to pursue other musical interests. In the intervening period, the group was occasionally rumored to have broken up, but finally reconvened for a tour which began in late 2010. Since reforming, they have released three more albums, the most recent being Luciferian Towers in September 2017.\"[1]", "https://en.wikipedia.org/wiki/Godspeed_You!_Black_Emperor", "1997", "2017", "https://www.youtube.com/embed/PZwQeZh6rP0", tag1);
		review3 = reviewsRepo.save(review3);
	}
}
