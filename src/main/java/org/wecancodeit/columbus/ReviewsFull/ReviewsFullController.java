package org.wecancodeit.columbus.ReviewsFull;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewsFullController {

	@Resource
	private ReviewsRepository reviewRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private TagRepository tagRepo;

	@Resource
	private CommentRepository commentRepo;

	@RequestMapping("review")
	public String getAReview(@RequestParam Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		model.addAttribute("category", categoryRepo.findOne(id));
		model.addAttribute("comment", commentRepo.findOne(id));
		
		return "review";
	}
	
	@RequestMapping("/add-comment")
	public String addComment (Long reviewId, String commentDetails, String userHandle) {
		
		Review newReview = reviewRepo.findOne(reviewId);
		
		
		if (commentDetails != null && userHandle != null) {
			Comment newComment = new Comment(commentDetails, newReview, userHandle);
			commentRepo.save(newComment);
		}
		return "redirect:/review?id=" + reviewId;
				
	}
	
	@RequestMapping("/add-tag")
	public String addTag (Long reviewId, String tagDescription, Review review) {
		Review newReview = reviewRepo.findOne(reviewId);
//		Tag newTag = tagRepo.findOne(reviewId);
		
		if(tagDescription != null) {
			Tag newTag= new Tag(tagDescription, newReview);
			tagRepo.save(newTag);
		}
			
		return "redirect:/review?id=" + reviewId;
	}
	

	@RequestMapping(value = "genres")
	public String getAllCategories(Model model) {
		model.addAttribute("genres", categoryRepo.findAll());
		return "genres";
	}

	@RequestMapping("category")
	public String getACategory(@RequestParam Long id, Model model) {
		Category category = categoryRepo.findOne(id);
		model.addAttribute("category", category);
		model.addAttribute("review", reviewRepo.findOne(id));
		model.addAttribute("reviews", reviewRepo.findByCategory(category));
		return "category";

	}

	@RequestMapping("tags")
	public String getAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@RequestMapping("tag")
	public String getATag(@RequestParam Long id, Model model) {
		Tag tag = tagRepo.findOne(id);
//		model.addAttribute("tag", tagRepo.findOne(id));
		model.addAttribute("tag", tag);
		model.addAttribute("review", reviewRepo.findOne(id));
		model.addAttribute("reviews", reviewRepo.findByTagsContains(tag));
		return "tag";
	}
	
//	@RequestMapping("/find-by-comment")
//	public String findOneComment(Long id, Model model) {
//		Comment comment = commentRepo.findOne(id);
//		model.addAttribute("comment", comment);
//		model.addAttribute("comment", commentRepo.findOne(id));
//		return "comment";
//		
//	}
}
