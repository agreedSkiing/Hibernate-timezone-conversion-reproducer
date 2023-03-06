# Hibernate ORM 5 timezone conversion test project

This subproject uses only Hibernate ORM 5.

Test without `hibernate.jdbc.time_zone` can be found in [GMTConversionWithoutJdbcTimezoneTest.java] and [UTCConversionWithoutJdbcTimezoneTest.java] which uses [persistence.xml] with the persistence unit `no.time.zone`.

Test with `hibernate.jdbc.time_zone=UTC` can be found in [GMTConversionWithJdbcTimezoneTest.java] and [UTCConversionWithJdbcTimezoneTest.java] which uses [persistence.xml] with the persistence unit `with.time.zone`.

[persistence.xml]: src/main/resources/META-INF/persistence.xml
[gmtconversionwithjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/hibernate/five/GMTConversionWithJdbcTimezoneTest.java
[utcconversionwithjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/hibernate/five/UTCConversionWithJdbcTimezoneTest.java
[gmtconversionwithoutjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/hibernate/five/GMTConversionWithoutJdbcTimezoneTest.java
[utcconversionwithoutjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/hibernate/five/UTCConversionWithoutJdbcTimezoneTest.java
