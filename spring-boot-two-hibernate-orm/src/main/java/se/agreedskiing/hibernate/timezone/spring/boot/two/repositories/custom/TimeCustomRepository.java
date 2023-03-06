package se.agreedskiing.hibernate.timezone.spring.boot.two.repositories.custom;

import se.agreedskiing.hibernate.timezone.spring.boot.two.entities.InstantRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.two.entities.LocalDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.two.entities.OffsetDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.two.entities.ZonedDateTimeRepresentation;

public interface TimeCustomRepository {
  public InstantRepresentation getAsInstants();

  public LocalDateTimeRepresentation getAsLocalDateTimes();

  public OffsetDateTimeRepresentation getAsOffsetDateTimes();

  public ZonedDateTimeRepresentation getAsZonedDateTimes();
}
