package se.agreedskiing.hibernate.timezone.quarkus.two.reactive.entities;

import javax.persistence.*;
import se.agreedskiing.hibernate.timezone.quarkus.two.reactive.entities.common.Base;

@Entity
@Table(name = "time")
/**
 * This class represents all time even with timezone as Instants
 */
public class InstantRepresentation extends Base {

  @Column(name = Base.NO_TIME_ZONE, nullable = false)
  public java.time.Instant noTimeZone;

  @Column(name = Base.WITH_TIME_ZONE, nullable = false)
  public java.time.Instant withTimeZone;

  @Column(name = Base.WITH_TIME_ZONE_GMT_2, nullable = false)
  public java.time.Instant withTimeZoneGmt2;
}
