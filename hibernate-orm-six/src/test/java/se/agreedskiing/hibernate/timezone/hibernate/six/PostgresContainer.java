package se.agreedskiing.hibernate.timezone.hibernate.six;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class PostgresContainer {

  @Container
  protected static final PostgreSQLContainer<?> DATABASE = new PostgreSQLContainer<>(
    "postgres:14.0-alpine"
  )
    .withUsername("user")
    .withPassword("pass")
    .withDatabaseName("hibernate_orm_six");
}
