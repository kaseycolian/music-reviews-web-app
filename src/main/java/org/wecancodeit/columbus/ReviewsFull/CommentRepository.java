package org.wecancodeit.columbus.ReviewsFull;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {

//	Comment findByName(String commentDescription);

//	Comment findOne(String commentDescription);
//	Comment findByName(String commentDetails);
}
