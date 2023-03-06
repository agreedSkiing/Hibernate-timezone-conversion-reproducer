package se.agreedskiing.hibernate.timezone.spring.boot.three.repositories.custom.impl;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Objects;
import se.agreedskiing.hibernate.timezone.spring.boot.three.entities.InstantRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.three.entities.LocalDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.three.entities.OffsetDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.three.entities.ZonedDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.three.repositories.custom.TimeCustomRepository;

public class TimeCustomRepositoryImpl implements TimeCustomRepository {

  @PersistenceContext
  EntityManager em;

  @Override
  public InstantRepresentation getAsInstants() {
    return this.em.find(InstantRepresentation.class, 1);
  }

  @Override
  public LocalDateTimeRepresentation getAsLocalDateTimes() {
    return this.em.find(LocalDateTimeRepresentation.class, 1);
  }

  @Override
  public OffsetDateTimeRepresentation getAsOffsetDateTimes() {
    return this.em.find(OffsetDateTimeRepresentation.class, 1);
  }

  @Override
  public ZonedDateTimeRepresentation getAsZonedDateTimes() {
    return this.em.find(ZonedDateTimeRepresentation.class, 1);
  }

  @PostConstruct
  public void postConstruct() {
    Objects.requireNonNull(this.em);
  }
}
