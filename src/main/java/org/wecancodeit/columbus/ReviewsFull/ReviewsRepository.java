package org.wecancodeit.columbus.ReviewsFull;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ReviewsRepository extends CrudRepository<Review, Long> {

	public Collection<Review> findByCategoryId(long categoryId);

	public Collection<Review> findByCategory(Category category);

}
