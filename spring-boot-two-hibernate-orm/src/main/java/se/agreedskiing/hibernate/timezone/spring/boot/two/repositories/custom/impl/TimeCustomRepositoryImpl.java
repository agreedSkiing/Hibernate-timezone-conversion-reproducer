package se.agreedskiing.hibernate.timezone.spring.boot.two.repositories.custom.impl;

import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.agreedskiing.hibernate.timezone.spring.boot.two.entities.InstantRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.two.entities.LocalDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.two.entities.OffsetDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.two.entities.ZonedDateTimeRepresentation;
import se.agreedskiing.hibernate.timezone.spring.boot.two.repositories.custom.TimeCustomRepository;

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
