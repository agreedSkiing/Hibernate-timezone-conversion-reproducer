package se.agreedskiing.hibernate.timezone.quarkus.two.reactive.repositories;

import io.smallrye.mutiny.Uni;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.hibernate.reactive.mutiny.Mutiny;
import se.agreedskiing.hibernate.timezone.quarkus.two.reactive.entities.InstantRepresentation;
import se.agreedskiing.hibernate.timezone.quarkus.two.reactive.entities.LocalDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.quarkus.two.reactive.entities.OffsetDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.quarkus.two.reactive.entities.ZonedDateTimeRepresentation;

@ApplicationScoped
public class TimeRepo {

  @Inject
  Mutiny.SessionFactory sf;

  public Uni<InstantRepresentation> getAsInstants() {
    return this.sf.withTransaction(s -> s.find(InstantRepresentation.class, 1));
  }

  public Uni<LocalDateTimeRepresentation> getAsLocalDateTimes() {
    return this.sf.withTransaction(s ->
        s.find(LocalDateTimeRepresentation.class, 1)
      );
  }

  public Uni<OffsetDateTimeRepresentation> getAsOffsetDateTimes() {
    return this.sf.withTransaction(s ->
        s.find(OffsetDateTimeRepresentation.class, 1)
      );
  }

  public Uni<ZonedDateTimeRepresentation> getAsZonedDateTimes() {
    return this.sf.withTransaction(s ->
        s.find(ZonedDateTimeRepresentation.class, 1)
      );
  }
}
