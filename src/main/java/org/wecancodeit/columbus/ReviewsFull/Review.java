package org.wecancodeit.columbus.ReviewsFull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String imageUrl;

	public String getContent() {
		return content;
	}

	@ManyToOne
	private Category category;

	@Lob
	private String content;
	private String firstRelease;
	private String lastRelease;
	private String youTubeUrl;
	private String footerUrl;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getFirstRelease() {
		return firstRelease;
	}

	public String getLastRelease() {
		return lastRelease;
	}

	public String getYouTubeUrl() {
		return youTubeUrl;
	}
	public String getFooterUrl() {
		return footerUrl;
	}

	public Review(String name, String content, String url, Category category, String firstRelease, String lastRelease, String youTubeUrl, String footerUrl) {
		this.name = name;
		this.content = content;
		this.category = category;
		this.imageUrl = url;
		this.firstRelease = firstRelease;
		this.lastRelease = lastRelease;
		this.youTubeUrl = youTubeUrl;
		this.footerUrl = footerUrl;

	}

	@SuppressWarnings("unused")
	private Review() {

	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Review) obj).id;
	}

	public Category getGenre() {
		// TODO Auto-generated method stub
		return category;
	}


}
