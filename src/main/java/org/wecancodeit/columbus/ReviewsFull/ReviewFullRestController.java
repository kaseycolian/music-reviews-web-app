package org.wecancodeit.columbus.ReviewsFull;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//clicking on tag from single review will take you to this end-point
//displays the tag clicked on with each review associated for that tag
//can click on review to take you to review's page
//can add & delete tag 
@RestController
@RequestMapping ("/tags-static")
public class ReviewFullRestController {

	@Resource
	private TagRepository tagRepo;

	@Resource
	private ReviewsRepository reviewRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private CommentRepository commentRepo;
	
	@RequestMapping ("/{id}")
	public Tag findOneTag(@PathVariable long id) {
		return tagRepo.findOne(id);
	}

//	@RequestMapping("/review") //was ("/add-tag")
//	public String addTag(Long reviewId, String tagDescription) {
//		Review newReview = reviewRepo.findOne(reviewId);
//		// Tag newTag = tagRepo.findOne(reviewId);
//
//		if (tagDescription != null) {
//			Tag newTag = new Tag(tagDescription, newReview);
//			tagRepo.save(newTag);
//		}
//
//		return "redirect:/review?id=" + reviewId;
//	}
//
//	@RequestMapping("/{id}")
//	public Tag findOneTag(@PathVariable long id) {
//		return tagRepo.findOne(id);
//	}
	

	
}
