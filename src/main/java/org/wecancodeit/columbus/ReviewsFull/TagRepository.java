package org.wecancodeit.columbus.ReviewsFull;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag findByTagDescription(String tagDescription);
}
