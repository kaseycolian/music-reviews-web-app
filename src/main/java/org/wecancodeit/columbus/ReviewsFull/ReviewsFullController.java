package org.wecancodeit.columbus.ReviewsFull;

import java.util.Collection;
import java.util.Iterator;

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
	public String addComment(Model model, Long reviewId, String commentDetails, String userHandle) {

		Review newReview = reviewRepo.findOne(reviewId);

		if (commentDetails != null && userHandle != null) {
			Comment newComment = new Comment(commentDetails, newReview, userHandle);
			commentRepo.save(newComment);
		}
		
		return "redirect:/review?id=" + reviewId;

	}

	@RequestMapping("/add-tag")
	public String addTag(Model model, Long reviewId, String tagDescription) {
		
		Review newReview = reviewRepo.findOne(reviewId);
		//if review isn't null & tag description isn't null
		if (newReview != null && tagDescription != null) {
			Tag existingTag = tagRepo.findByTagDescription(tagDescription);
			//if existingTag isn't in tag repo, save as newtag and add to review.
			if (existingTag == null) {
				Tag newTag = new Tag(tagDescription, newReview);
				tagRepo.save(newTag);
				newReview.addTag(newTag);
				reviewRepo.save(newReview);
				
				// if existingTag isn't already attached to review, then add & save new tag to review.
			} else {
				if (newReview.tagExists(existingTag.getId()) == false) {
					newReview.addTag(existingTag);
					reviewRepo.save(newReview);
				}
			}
			model.addAttribute("review", newReview);
		}
		
		// will parse string for return value from singleTag.html
		return "singleTag";
	}
	
	@RequestMapping("/remove-tag")
	public String removeTag(Model model, Long reviewId, String tagDescription) {
		Review newReview = reviewRepo.findOne(reviewId);
		if (newReview != null && tagDescription != null) {
			Tag tagToDelete = tagRepo.findByTagDescription(tagDescription);
			if (tagToDelete != null) {
				// going through each tag in the review's collection of tags. matching the tag
				// description and removing it
				// from that review's collection of tags if it matches an existing tag.
				Iterator<Tag> tags = newReview.getTags().iterator();
				while (tags.hasNext()) {
					Tag currentTag = tags.next();
					if (currentTag.getId() == tagToDelete.getId()) {
						tags.remove();
					}

				}
				reviewRepo.save(newReview);
			}
			model.addAttribute("review", newReview);
		}
		// will parse string in singleTag.html
		return "singleTag";
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
	//
	// @RequestMapping("tags")
	// public String getAllTags(Model model) {
	// model.addAttribute("tags", tagRepo.findAll());
	// return "tags";
	// }

	@RequestMapping("tag")
	public String getATag(@RequestParam Long id, Model model) {
		Tag tag = tagRepo.findOne(id);
		// model.addAttribute("tag", tagRepo.findOne(id));
		model.addAttribute("tag", tag);
		model.addAttribute("review", reviewRepo.findOne(id));
		model.addAttribute("reviews", reviewRepo.findByTagsContains(tag));
		return "tag";
	}

}
