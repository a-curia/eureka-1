package com.dbbyte.mcs.models;

import java.util.List;

public class UserRating {

	public List<Rating> userRating;

	public UserRating(List<Rating> userRating) {
		super();
		this.userRating = userRating;
	}

	public UserRating() {
		super();
	}

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}

}
