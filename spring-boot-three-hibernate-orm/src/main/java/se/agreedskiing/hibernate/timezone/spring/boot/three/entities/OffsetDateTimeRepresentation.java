package se.agreedskiing.hibernate.timezone.spring.boot.three.entities;

import jakarta.persistence.*;
import se.agreedskiing.hibernate.timezone.spring.boot.three.entities.common.Base;

@Entity
@Table(name = "time")
/**
 * This class represents all time even with timezone as OffsetDateTimes
 */
public class OffsetDateTimeRepresentation extends Base {

  @Column(name = Base.NO_TIME_ZONE, nullable = false)
  public java.time.OffsetDateTime noTimeZone;

  @Column(name = Base.WITH_TIME_ZONE, nullable = false)
  public java.time.OffsetDateTime withTimeZone;

  @Column(name = Base.WITH_TIME_ZONE_GMT_2, nullable = false)
  public java.time.OffsetDateTime withTimeZoneGmt2;
}
