package net.tmhung.example.domain;

public class Department {
  private final int id;
  private final String name;
  private final String location;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public Department(int id, String name, String location) {
    this.id = id;
    this.name = name;
    this.location = location;
  }
}
