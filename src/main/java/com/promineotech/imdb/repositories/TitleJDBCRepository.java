package com.promineotech.imdb.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.imdb.models.TitleModel;

@Repository
public class TitleJDBCRepository implements TitleRepository {
  private NamedParameterJdbcTemplate provider;  
  
  public TitleJDBCRepository(NamedParameterJdbcTemplate provider) {
    this.provider = provider;
  }
  
  @Override
  public Optional<TitleModel> get(String id) {
    String sql = "SELECT title_id,primary_title,start_year,runtime_minutes "
               + "FROM title "
               + "WHERE title_id = :title_id;";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("title_id", id);
    
    List<TitleModel> titles = provider.query(sql, parameters, (rs, rowNum) -> {
      return new TitleModel(rs.getString("title_id"), rs.getString("primary_title"))
          .setReleased(rs.getInt("start_year"))
          .setRuntime(rs.getInt("runtime_minutes"));
    });
    if (titles.isEmpty()) {
      return Optional.empty();
    }
    
    return Optional.of(titles.get(0));
  }
}
