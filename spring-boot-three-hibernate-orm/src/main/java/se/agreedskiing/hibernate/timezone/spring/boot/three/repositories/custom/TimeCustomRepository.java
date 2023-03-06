package se.agreedskiing.hibernate.timezone.spring.boot.three.repositories.custom;

import se.agreedskiing.hibernate.timezone.spring.boot.three.entities.InstantRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.three.entities.LocalDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.three.entities.OffsetDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.three.entities.ZonedDateTimeRepresentation;

public interface TimeCustomRepository {
  public InstantRepresentation getAsInstants();

  public LocalDateTimeRepresentation getAsLocalDateTimes();

  public OffsetDateTimeRepresentation getAsOffsetDateTimes();

  public ZonedDateTimeRepresentation getAsZonedDateTimes();
}
