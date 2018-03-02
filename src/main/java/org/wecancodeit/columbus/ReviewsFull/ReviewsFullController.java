package org.wecancodeit.columbus.ReviewsFull;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewsFullController {

	@Resource
	ReviewsRepository reviewRepo;

	@Resource
	CategoryRepository categoryRepo;

	@RequestMapping(value = "reviews")
	public void getAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
	}

	@RequestMapping("review")
	public String getAReview(@RequestParam Long id, Model model) {
		model.addAttribute("reviews", reviewRepo.findOne(id));
		return "review";
	}

}
