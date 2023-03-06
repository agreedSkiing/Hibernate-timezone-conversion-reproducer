package se.agreedskiing.hibernate.timezone.hibernate.reactive;

import io.smallrye.mutiny.Uni;
import java.util.Map;
import javax.persistence.Persistence;
import org.hibernate.reactive.mutiny.Mutiny;
import se.agreedskiing.hibernate.timezone.hibernate.reactive.entities.InstantRepresentation;
import se.agreedskiing.hibernate.timezone.hibernate.reactive.entities.LocalDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.hibernate.reactive.entities.OffsetDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.hibernate.reactive.entities.ZonedDateTimeRepresentation;

public class Application {

  private static final String HIBERNATE_REACTIVE = "/hibernate_reactive";
  private static final String JDBC_POSTGRESQL_LOCALHOST =
    "jdbc:postgresql://localhost:";
  private static final String JAVAX_PERSISTENCE_JDBC_URL =
    "javax.persistence.jdbc.url";

  public static void main(final String[] args) {
    //NO use currently
  }

  public Uni<InstantRepresentation> getAsInstants(
    final String persistenceUnit,
    final int port
  ) {
    return Persistence
      .createEntityManagerFactory(
        persistenceUnit,
        Map.of(
          Application.JAVAX_PERSISTENCE_JDBC_URL,
          Application.JDBC_POSTGRESQL_LOCALHOST +
          port +
          Application.HIBERNATE_REACTIVE
        )
      )
      .unwrap(Mutiny.SessionFactory.class)
      .withSession(s -> s.find(InstantRepresentation.class, 1));
  }

  public Uni<LocalDateTimeRepresentation> getAsLocalDateTimes(
    final String persistenceUnit,
    final int port
  ) {
    return Persistence
      .createEntityManagerFactory(
        persistenceUnit,
        Map.of(
          Application.JAVAX_PERSISTENCE_JDBC_URL,
          Application.JDBC_POSTGRESQL_LOCALHOST +
          port +
          Application.HIBERNATE_REACTIVE
        )
      )
      .unwrap(Mutiny.SessionFactory.class)
      .withSession(s -> s.find(LocalDateTimeRepresentation.class, 1));
  }

  public Uni<OffsetDateTimeRepresentation> getAsOffsetDateTimes(
    final String persistenceUnit,
    final int port
  ) {
    return Persistence
      .createEntityManagerFactory(
        persistenceUnit,
        Map.of(
          Application.JAVAX_PERSISTENCE_JDBC_URL,
          Application.JDBC_POSTGRESQL_LOCALHOST +
          port +
          Application.HIBERNATE_REACTIVE
        )
      )
      .unwrap(Mutiny.SessionFactory.class)
      .withSession(s -> s.find(OffsetDateTimeRepresentation.class, 1));
  }

  public Uni<ZonedDateTimeRepresentation> getAsZonedDateTimes(
    final String persistenceUnit,
    final int port
  ) {
    return Persistence
      .createEntityManagerFactory(
        persistenceUnit,
        Map.of(
          Application.JAVAX_PERSISTENCE_JDBC_URL,
          Application.JDBC_POSTGRESQL_LOCALHOST +
          port +
          Application.HIBERNATE_REACTIVE
        )
      )
      .unwrap(Mutiny.SessionFactory.class)
      .withSession(s -> s.find(ZonedDateTimeRepresentation.class, 1));
  }
}
