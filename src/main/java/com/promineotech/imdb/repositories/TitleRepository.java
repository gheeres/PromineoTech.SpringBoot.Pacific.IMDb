package com.promineotech.imdb.repositories;

import java.util.Optional;
import com.promineotech.imdb.models.TitleModel;

/**
 * Serializes and deserializes title information.
 */
public interface TitleRepository {
  /**
   * Gets a title by it's unique identifier.
   * @param id The unique identifier of the title.
   * @return The title if found, otherwise and empty optional.
   */
  Optional<TitleModel> get(String id);
}
