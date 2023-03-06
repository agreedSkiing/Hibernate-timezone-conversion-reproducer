package se.agreedskiing.hibernate.timezone.hibernate.reactive;

import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import java.util.TimeZone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UTCConversionWithJdbcTimezoneTest extends PostgresContainer {

  Application repository;

  static final String PERSISTANCE_UNIT = "with.time.zone";
  static final int PORT = PostgresContainer.DATABASE.getFirstMappedPort();

  @BeforeAll
  static void boot() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }

  @BeforeEach
  void setUp() {
    this.repository = new Application();
  }

  @Test
  void getting_as_instants() {
    this.repository.getAsInstants(
        UTCConversionWithJdbcTimezoneTest.PERSISTANCE_UNIT,
        UTCConversionWithJdbcTimezoneTest.PORT
      )
      .invoke(entity ->
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
        )
      )
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertCompleted();
  }

  @Test
  void getting_as_local_date_time() {
    this.repository.getAsLocalDateTimes(
        UTCConversionWithJdbcTimezoneTest.PERSISTANCE_UNIT,
        UTCConversionWithJdbcTimezoneTest.PORT
      )
      .invoke(entity ->
        Assertions.assertAll(
          () ->
            Assertions.assertEquals(
              "2022-12-18T19:39:20",
              entity.noTimeZone.toString(),
              ErrorTexts.NO_TIMEZONE_FIELD_FAILED.explenation
            ),
          () ->
            Assertions.assertEquals(
              "2022-12-18T18:39:20",
              entity.withTimeZone.toString(),
              ErrorTexts.TIMEZONE_FIELD_FAILED.explenation
            ),
          () ->
            Assertions.assertEquals(
              "2022-12-18T17:39:20",
              entity.withTimeZoneGmt2.toString(),
              ErrorTexts.TIMEZONE_WITH_GMT_2_FIELD_FAILED.explenation
            )
        )
      )
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertCompleted();
  }

  @Test
  void getting_as_offset_date_time() {
    this.repository.getAsOffsetDateTimes(
        UTCConversionWithJdbcTimezoneTest.PERSISTANCE_UNIT,
        UTCConversionWithJdbcTimezoneTest.PORT
      )
      .invoke(entity ->
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
        )
      )
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertCompleted();
  }

  @Test
  void getting_as_zoned_date_time() {
    this.repository.getAsZonedDateTimes(
        UTCConversionWithJdbcTimezoneTest.PERSISTANCE_UNIT,
        UTCConversionWithJdbcTimezoneTest.PORT
      )
      .invoke(entity ->
        Assertions.assertAll(
          () ->
            Assertions.assertEquals(
              "2022-12-18T19:39:20Z[UTC]",
              entity.noTimeZone.toString(),
              ErrorTexts.NO_TIMEZONE_FIELD_FAILED.explenation
            ),
          () ->
            Assertions.assertEquals(
              "2022-12-18T18:39:20Z[UTC]",
              entity.withTimeZone.toString(),
              ErrorTexts.TIMEZONE_FIELD_FAILED.explenation
            ),
          () ->
            Assertions.assertEquals(
              "2022-12-18T17:39:20Z[UTC]",
              entity.withTimeZoneGmt2.toString(),
              ErrorTexts.TIMEZONE_WITH_GMT_2_FIELD_FAILED.explenation
            )
        )
      )
      .subscribe()
      .withSubscriber(UniAssertSubscriber.create())
      .awaitItem()
      .assertCompleted();
  }
}
