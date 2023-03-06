package se.agreedskiing.hibernate.timezone.hibernate.six;

public enum ErrorTexts {
  TIMEZONE_WITH_GMT_2_FIELD_FAILED(
    "Timezone with gmt +2 field failed to convert to correct time"
  ),
  TIMEZONE_FIELD_FAILED("Timezone field failed to convert to correct time"),
  NO_TIMEZONE_FIELD_FAILED(
    "No timezone field failed to convert to correct time"
  );

  public final String explenation;

  private ErrorTexts(final String exeplnation) {
    this.explenation = exeplnation;
  }
}
