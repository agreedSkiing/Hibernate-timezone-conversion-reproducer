package se.agreedskiing.hibernate.timezone.hibernate.five;

import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import se.agreedskiing.hibernate.timezone.hibernate.five.entities.InstantRepresentation;
import se.agreedskiing.hibernate.timezone.hibernate.five.entities.LocalDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.hibernate.five.entities.OffsetDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.hibernate.five.entities.ZonedDateTimeRepresentation;

public class Application {

  EntityManagerFactory entityManagerFactory;

  public Application(final String persitanceUnit, final int port) {
    this.entityManagerFactory =
      Persistence.createEntityManagerFactory(
        persitanceUnit,
        Map.of(
          "javax.persistence.jdbc.url",
          "jdbc:postgresql://localhost:" + port + "/hibernate_orm_five"
        )
      );
  }

  public static void main(final String[] args) {
    //Not used
  }

  public InstantRepresentation getAsInstants() {
    return this.entityManagerFactory.createEntityManager()
      .find(InstantRepresentation.class, 1L);
  }

  public LocalDateTimeRepresentation getAsLocalDateTimes() {
    return this.entityManagerFactory.createEntityManager()
      .find(LocalDateTimeRepresentation.class, 1L);
  }

  public OffsetDateTimeRepresentation getAsOffsetDateTimes() {
    return this.entityManagerFactory.createEntityManager()
      .find(OffsetDateTimeRepresentation.class, 1L);
  }

  public ZonedDateTimeRepresentation getAsZonedDateTimes() {
    return this.entityManagerFactory.createEntityManager()
      .find(ZonedDateTimeRepresentation.class, 1L);
  }
}
