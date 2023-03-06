package se.agreedskiing.hibernate.timezone.spring.boot.two.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import se.agreedskiing.hibernate.timezone.spring.boot.two.entities.common.Base;

@Entity
@Table(name = "time")
/**
 * This class represents all time even with timezone as LocalDateTimes
 */
public class LocalDateTimeRepresentation extends Base {

  @Column(name = Base.NO_TIME_ZONE, nullable = false)
  public java.time.LocalDateTime noTimeZone;

  @Column(name = Base.WITH_TIME_ZONE, nullable = false)
  public java.time.LocalDateTime withTimeZone;

  @Column(name = Base.WITH_TIME_ZONE_GMT_2, nullable = false)
  public java.time.LocalDateTime withTimeZoneGmt2;
}
