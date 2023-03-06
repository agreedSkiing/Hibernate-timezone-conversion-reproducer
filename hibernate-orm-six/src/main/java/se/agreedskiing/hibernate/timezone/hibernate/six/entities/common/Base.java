package se.agreedskiing.hibernate.timezone.hibernate.six.entities.common;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Base {

  public static final String NO_TIME_ZONE = "no_time_zone";
  public static final String WITH_TIME_ZONE = "with_time_zone";
  public static final String WITH_TIME_ZONE_GMT_2 = "with_time_zone_gmt_2";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long identity;
}
