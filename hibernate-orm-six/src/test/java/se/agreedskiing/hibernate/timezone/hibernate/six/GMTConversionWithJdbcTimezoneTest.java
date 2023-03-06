package se.agreedskiing.hibernate.timezone.hibernate.six;

import java.util.TimeZone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GMTConversionWithJdbcTimezoneTest extends PostgresContainer {

  private static Application repository;

  @BeforeAll
  static void boot() {
    TimeZone.setDefault(TimeZone.getTimeZone("Etc/GMT-1"));
    GMTConversionWithJdbcTimezoneTest.repository =
      new Application(
        "with.time.zone",
        PostgresContainer.DATABASE.getFirstMappedPort()
      );
  }

  @Test
  void getting_as_instants() {
    final var entity = GMTConversionWithJdbcTimezoneTest.repository.getAsInstants();
    Assertions.assertAll(
      () ->
        Assertions.assertEquals(
          "2022-12-18T19:39:20Z",
          entity.noTimeZone.toString(),
          ErrorTexts.NO_TIMEZONE_FIELD_FAILED.explenation
        ),
      () ->
        Assertions.assertEquals(
          "2022-12-18T18:39:20Z",
          entity.withTimeZone.toString(),
          ErrorTexts.TIMEZONE_FIELD_FAILED.explenation
        ),
      () ->
        Assertions.assertEquals(
          "2022-12-18T17:39:20Z",
          entity.withTimeZoneGmt2.toString(),
          ErrorTexts.TIMEZONE_WITH_GMT_2_FIELD_FAILED.explenation
        )
    );
  }

  @Test
  void getting_as_local_date_time() {
    final var entity = GMTConversionWithJdbcTimezoneTest.repository.getAsLocalDateTimes();
    Assertions.assertAll(
      () ->
        Assertions.assertEquals(
          "2022-12-18T20:39:20",
          entity.noTimeZone.toString(),
          ErrorTexts.NO_TIMEZONE_FIELD_FAILED.explenation
        ),
      () ->
        Assertions.assertEquals(
          "2022-12-18T19:39:20",
          entity.withTimeZone.toString(),
          ErrorTexts.TIMEZONE_FIELD_FAILED.explenation
        ),
      () ->
        Assertions.assertEquals(
          "2022-12-18T18:39:20",
          entity.withTimeZoneGmt2.toString(),
          ErrorTexts.TIMEZONE_WITH_GMT_2_FIELD_FAILED.explenation
        )
    );
  }

  @Test
  void getting_as_offset_date_time() {
    final var entity = GMTConversionWithJdbcTimezoneTest.repository.getAsOffsetDateTimes();
    Assertions.assertAll(
      () ->
        Assertions.assertEquals(
          "2022-12-18T20:39:20+01:00",
          entity.noTimeZone.toString(),
          ErrorTexts.NO_TIMEZONE_FIELD_FAILED.explenation
        ),
      () ->
        Assertions.assertEquals(
          "2022-12-18T19:39:20+01:00",
          entity.withTimeZone.toString(),
          ErrorTexts.TIMEZONE_FIELD_FAILED.explenation
        ),
      () ->
        Assertions.assertEquals(
          "2022-12-18T18:39:20+01:00",
          entity.withTimeZoneGmt2.toString(),
          ErrorTexts.TIMEZONE_WITH_GMT_2_FIELD_FAILED.explenation
        )
    );
  }

  @Test
  void getting_as_zoned_date_time() {
    final var entity = GMTConversionWithJdbcTimezoneTest.repository.getAsZonedDateTimes();
    Assertions.assertAll(
      () ->
        Assertions.assertEquals(
          "2022-12-18T20:39:20+01:00[Etc/GMT-1]",
          entity.noTimeZone.toString(),
          ErrorTexts.NO_TIMEZONE_FIELD_FAILED.explenation
        ),
      () ->
        Assertions.assertEquals(
          "2022-12-18T19:39:20+01:00[Etc/GMT-1]",
          entity.withTimeZone.toString(),
          ErrorTexts.TIMEZONE_FIELD_FAILED.explenation
        ),
      () ->
        Assertions.assertEquals(
          "2022-12-18T18:39:20+01:00[Etc/GMT-1]",
          entity.withTimeZoneGmt2.toString(),
          ErrorTexts.TIMEZONE_WITH_GMT_2_FIELD_FAILED.explenation
        )
    );
  }
}
