package com.promineotech.imdb.models;

/**
 * Represents a title or movie in the system.
 * 
 */
public class TitleModel extends Model {
  private String id;
  private String name;
  private int released;
  private int runtime;
  
  public TitleModel(String id, String name) {
    setId(id);
    setName(name);
  }
  
  public String getId() {
    return id;
  }
  public TitleModel setId(String id) {
    this.id = id;
    return this;
  }
  public String getName() {
    return name;
  }
  public TitleModel setName(String name) {
    this.name = name;
    return this;
  }
  public int getReleased() {
    return released;
  }
  public TitleModel setReleased(int released) {
    this.released = released;
    return this;
  }
  public int getRuntime() {
    return runtime;
  }
  public TitleModel setRuntime(int runtime) {
    this.runtime = runtime;
    return this;
  }
}
