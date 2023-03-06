# Quarkus 2.X.Y Hibernate ORM 5 timezone conversion test project

This project uses Quarkus with their Hibernate ORM 5 implementation.

Test without `quarkus.hibernate-orm.jdbc.timezone` can be found in [GMTConversionWithoutJdbcTimezoneTest.java] and [UTCConversionWithoutJdbcTimezoneTest.java].

Test with `quarkus.hibernate-orm.jdbc.timezone=UTC` can be found in [GMTConversionWithJdbcTimezoneTest.java] and [UTCConversionWithJdbcTimezoneTest.java] which uses [JdbcTimezone.java].

[jdbctimezone.java]: src/test/java/se/agreedskiing/hibernate/timezone/quarkus/two/profiles/JdbcTimezone.java
[gmtconversionwithjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/quarkus/two/repositories/GMTConversionWithJdbcTimezoneTest.java
[utcconversionwithjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/quarkus/two/repositories/UTCConversionWithJdbcTimezoneTest.java
[gmtconversionwithoutjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/quarkus/two/repositories/GMTConversionWithoutJdbcTimezoneTest.java
[utcconversionwithoutjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/quarkus/two/repositories/UTCConversionWithoutJdbcTimezoneTest.java
