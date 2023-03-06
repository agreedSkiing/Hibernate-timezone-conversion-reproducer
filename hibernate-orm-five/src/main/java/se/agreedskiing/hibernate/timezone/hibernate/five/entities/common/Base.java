package se.agreedskiing.hibernate.timezone.hibernate.five.entities.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Base {

  public static final String NO_TIME_ZONE = "no_time_zone";
  public static final String WITH_TIME_ZONE = "with_time_zone";
  public static final String WITH_TIME_ZONE_GMT_2 = "with_time_zone_gmt_2";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long identity;
}
