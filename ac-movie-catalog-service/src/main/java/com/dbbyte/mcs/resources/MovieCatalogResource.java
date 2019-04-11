package com.dbbyte.mcs.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.dbbyte.mcs.models.CatalogItem;
import com.dbbyte.mcs.models.Movie;
import com.dbbyte.mcs.models.Rating;
import com.dbbyte.mcs.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	// programatic access to service discovery
//	@Autowired
//	private DiscoveryClient discoveryClient;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
//		RestTemplate restTemplate = new RestTemplate(); // do a bean from this so that it will be done only once
//		Movie movie = restTemplate.getForObject("http://localhost:8081/movies/foo", Movie.class);
		

		
		// get all rated movie IDs
			// hardcoded the movies he watched
//		List<Rating> ratings = Arrays.asList(
//					new Rating("1234",4),
//					new Rating("5678",2)
//		);
		
		// call to the REST api instead of hardcodding
//		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId, UserRating.class); // you might need ParameterizeType and create a inner class instance
		
		UserRating ratings = restTemplate.getForObject("http://MOVIE-RATINGS-DATA-SERVICE/ratingsdata/users/"+userId, UserRating.class); // you might need ParameterizeType and create a inner class instance

		
		// for each movie ID, call movie info service and get details
//		return ratings.stream().map(rating -> 
//			new CatalogItem("Transformers","Test description.", 4 ) // should make the call to API not hardcoding the list
//		).collect(Collectors.toList());
	
		
		return ratings.getUserRating().stream().map(rating -> {
				Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/"+rating.getMovieId(), Movie.class);
				
//				/* using WebClient from reactive web instead of RestTemplate */
//				/* this is still blocking, to unblock you must return Mono from function */
//				Movie movie = webClientBuilder.build()
//						.get()
//						.uri("http://localhost:8081/movies/"+rating.getMovieId())
//						.retrieve()
//						.bodyToMono(Movie.class)
//						.block();
				
				// put then all together
				return new CatalogItem(movie.getName(),"Test description.", rating.getRating()); // should make the call to API not hardcodeing the list
		}).collect(Collectors.toList());
		

//		1 thread = 1 request - concurrency - RestTemplate is thread safe
		

//		//singletonList - Returns an immutable list containing only the specified object. The returned list is serializable.
//		/*As a convenience ... to save you having to write a sequence of statements to:
//		    create an empty list object
//		    add an element to it, and
//		    wrap it with an immutable wrapper.*/
//
//		return Collections.singletonList(
//				new CatalogItem("Transformers","Test description.", 4 )
//		); 
		
	}
}
