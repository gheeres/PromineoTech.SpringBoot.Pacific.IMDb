package com.promineotech.imdb.controllers;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.imdb.models.TitleModel;
import com.promineotech.imdb.repositories.TitleRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@OpenAPIDefinition(info = @Info(title = "IMDb Clone: Get Your Movies"))
@Tag(name="Movies")
@RequestMapping("/movies")
public class MoviesController {
  private TitleRepository repository;
  
  public MoviesController(TitleRepository repository) {
    this.repository = repository;
  }
  
  /**
   * Returns the movie matching the specified id.
   * @param id The unique id of the movie.
   * @return The movie if found, otherwise null.
   */
  @GetMapping(value = "{id}")
  public TitleModel get(@PathVariable String id) {
    Optional<TitleModel> title = repository.get(id);
    if (title.isPresent()) {
      return title.get();
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
                                      "The requested movie was not found.");
    //return new TitleModel("tt0000000", "George's Fake Movie")
    //    .setRuntime(90)
    //    .setReleased(2022);
  }
}
