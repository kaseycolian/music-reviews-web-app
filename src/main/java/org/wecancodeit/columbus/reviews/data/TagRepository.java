package org.wecancodeit.columbus.reviews.data;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag findByTagDescription(String tagDescription);
}
