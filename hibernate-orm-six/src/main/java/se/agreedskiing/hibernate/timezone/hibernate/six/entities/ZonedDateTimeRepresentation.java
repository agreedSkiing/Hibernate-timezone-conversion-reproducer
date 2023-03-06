package se.agreedskiing.hibernate.timezone.hibernate.six.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import se.agreedskiing.hibernate.timezone.hibernate.six.entities.common.Base;

@Entity
@Table(name = "time")
/**
 * This class represents all time even with timezone as ZonedDateTimes
 */
public class ZonedDateTimeRepresentation extends Base {

  @Column(name = Base.NO_TIME_ZONE, nullable = false)
  public java.time.ZonedDateTime noTimeZone;

  @Column(name = Base.WITH_TIME_ZONE, nullable = false)
  public java.time.ZonedDateTime withTimeZone;

  @Column(name = Base.WITH_TIME_ZONE_GMT_2, nullable = false)
  public java.time.ZonedDateTime withTimeZoneGmt2;
}
