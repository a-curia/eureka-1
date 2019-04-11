package com.dbbyte.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbbyte.models.Rating;
import com.dbbyte.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}

//	@RequestMapping("/users/{userId}")
//	public List<Rating> getUserRatings(@PathVariable("userId") String userId) {
//		List<Rating> ratings = Arrays.asList(
//				new Rating("1234",4),
//				new Rating("5678",2)
//				);
//		return ratings;
//	}

	@RequestMapping("/users/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("1234",4),
				new Rating("5678",2)
				);
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		
		return userRating;
	}
	
}