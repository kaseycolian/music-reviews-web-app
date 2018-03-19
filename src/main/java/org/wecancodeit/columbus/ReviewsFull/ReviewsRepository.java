package org.wecancodeit.columbus.ReviewsFull;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ReviewsRepository extends CrudRepository<Review, Long> {

	Collection<Review> findByCategoryId(long categoryId);

	Collection<Review> findByCategory(Category category);

	Collection<Review> findByTagsContains(Tag tag);

	Collection<Review> findByTagsId(Long id);

	// Collection<Review> findByComment(Comment comment);

	// Collection<Review> findById(Long id);

	// Collection<Review> findByComment(Long id);

}
