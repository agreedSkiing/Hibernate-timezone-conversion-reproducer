# Quarkus 2.X.Y Hibernate Reactive (Hibernate ORM 5) timezone conversion test project

This project uses Quarkus with their Hibernate Reactive (Hibernate ORM 5) implementation.

Test without `quarkus.hibernate-orm.jdbc.timezone` can be found in [GMTConversionWithoutJdbcTimezoneTest.java] and [UTCConversionWithoutJdbcTimezoneTest.java].

Test with `quarkus.hibernate-orm.jdbc.timezone=UTC` can be found in [GMTConversionWithJdbcTimezoneTest.java] and [UTCConversionWithJdbcTimezoneTest.java] which uses [JdbcTimezone.java].

[jdbctimezone.java]: src/test/java/se/agreedskiing/hibernate/timezone/quarkus/two/reactive/profiles/JdbcTimezone.java
[gmtconversionwithjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/quarkus/two/reactive/repositories/GMTConversionWithJdbcTimezoneTest.java
[utcconversionwithjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/quarkus/two/reactive/repositories/UTCConversionWithJdbcTimezoneTest.java
[gmtconversionwithoutjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/quarkus/two/reactive/repositories/GMTConversionWithoutJdbcTimezoneTest.java
[utcconversionwithoutjdbctimezonetest.java]: src/test/java/se/agreedskiing/hibernate/timezone/quarkus/two/reactive/repositories/UTCConversionWithoutJdbcTimezoneTest.java
