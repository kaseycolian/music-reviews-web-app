package org.wecancodeit.columbus.ReviewsFull;

import javax.annotation.Resource;

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

//	@RequestMapping(value = "reviews")
//	public String getAllReviews(Model model) {
//		model.addAttribute("reviews", reviewRepo.findAll());
//		return "reviews";
//	}

	@RequestMapping("review")
	public String getAReview(@RequestParam Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		model.addAttribute("tag", tagRepo.findOne(id));
		return "review";
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
	
//	@RequestMapping("tag")
//	public String getATag(@RequestParam Long id, Model model) {
//		model.addAttribute("tags", tagRepo.findOne(id));
//		return "tags";
//	}


}
