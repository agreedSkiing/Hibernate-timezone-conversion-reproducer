package se.agreedskiing.hibernate.timezone.quarkus.two.repositories;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import se.agreedskiing.hibernate.timezone.quarkus.two.entities.InstantRepresentation;
import se.agreedskiing.hibernate.timezone.quarkus.two.entities.LocalDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.quarkus.two.entities.OffsetDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.quarkus.two.entities.ZonedDateTimeRepresentation;

@ApplicationScoped
public class TimeRepo {

  @Inject
  EntityManager em;

  public InstantRepresentation getAsInstants() {
    return this.em.find(InstantRepresentation.class, 1);
  }

  public LocalDateTimeRepresentation getAsLocalDateTimes() {
    return this.em.find(LocalDateTimeRepresentation.class, 1);
  }

  public OffsetDateTimeRepresentation getAsOffsetDateTimes() {
    return this.em.find(OffsetDateTimeRepresentation.class, 1);
  }

  public ZonedDateTimeRepresentation getAsZonedDateTimes() {
    return this.em.find(ZonedDateTimeRepresentation.class, 1);
  }
}
