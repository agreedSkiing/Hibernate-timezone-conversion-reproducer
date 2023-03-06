# Spring boot 3.X.Y Hibernate ORM 6 timezone conversion test project

This project uses Spring boot 3.X.Y with their Hibernate ORM 6 implementation (if they have one, i don't know).

Test without `spring.jpa.properties.hibernate.jdbc.time_zone` can be found in [GMTConversionWithoutJdbcTimezoneTest.java] and [UTCConversionWithoutJdbcTimezoneTest.java] which uses [application-postgres.properties].

Test with `spring.jpa.properties.hibernate.jdbc.time_zone=UTC` can be found in [GMTConversionWithJdbcTimezoneTest.java] and [UTCConversionWithJdbcTimezoneTest.java] which uses [application-postgres_with_timezone.properties].

[application-postgres.properties]: src/test/resources/application-postgres.properties
[gmtconversionwithjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/spring/boot/three/repositories/GMTConversionWithJdbcTimezoneTest.java
[utcconversionwithjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/spring/boot/three/repositories/UTCConversionWithJdbcTimezoneTest.java
[gmtconversionwithoutjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/spring/boot/three/repositories/GMTConversionWithoutJdbcTimezoneTest.java
[utcconversionwithoutjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/spring/boot/three/repositories/UTCConversionWithoutJdbcTimezoneTest.java
[application-postgres_with_timezone.properties]: src/test/resources/application-postgres_with_timezone.properties
