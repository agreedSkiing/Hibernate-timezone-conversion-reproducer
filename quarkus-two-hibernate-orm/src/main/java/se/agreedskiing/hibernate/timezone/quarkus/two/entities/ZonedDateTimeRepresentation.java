package se.agreedskiing.hibernate.timezone.quarkus.two.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import se.agreedskiing.hibernate.timezone.quarkus.two.entities.common.Base;

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
