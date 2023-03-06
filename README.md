# Hibernate timezone conversion testing

The purpose of this project is to test timezone convertions between an UTC database and different runs of a java application which either has the `user.timezone` set to `Etc/GMT-1` (GMT+1) or `user.timezone` set to `UTC` with and without setting the `hibernate.jdbc.time_zone` or `hibernate-orm.jdbc.time_zone` to `UTC`.

## Running the application

**Prerequisite:** Java, maven and docker (testcontainers)

### Tests

Test are ran either from each subproject or form the parent project with the command below

```bash
mvn clean test --fail-at-end
```

Each test launches a postgres in a testcontainer on a random port and each of them loads the `import.sql` script with the help of Hibernate and each script produces the database below (launch of quarkus service).

```bash output
docker exec -it postgres /bin/bash
c7b596f783c9:/# psql -U user quarkus
psql (14.0)
Type "help" for help.

quarkus=# \x
Expanded display is on.
quarkus=# SELECT * from time;
-[ RECORD 1 ]--------+-----------------------
identity             | 1
no_time_zone         | 2022-12-18 19:39:20
with_time_zone       | 2022-12-18 18:39:20+00
with_time_zone_gmt_2 | 2022-12-18 17:39:20+00

quarkus=# exit
c7b596f783c9:/# datae
bash: datae: command not found
c7b596f783c9:/# date
Mon Dec 19 07:33:42 UTC 2022
c7b596f783c9:/#
```

#### Errors

The project produces the some errors when doing timezone conversions and are listed under each specific heading related to the Hibernate ORM/Reactive implementation and the errors only appear when no database timezone has been specified with the `user.timezone` set to `Etc/GMT-1` with the helpt of `TimeZone.setDefault(TimeZone.getTimeZone("Etc/GMT-1"))`.

Tests that produce these errors are named **GMTConversionWithoutJdbcTimezoneTest.java** in each subproject.

#### Hibernate ORM 5

Following errors occour when Hibernate ORM 5 is used (line numbers might differ between subprojects):

```bash
# [...]
[INFO] Results:
[INFO]
[ERROR] Failures:
[ERROR]   GMTConversionWithoutJdbcTimezoneTest.getting_as_instants:28 Multiple Failures (1 failure)
        org.opentest4j.AssertionFailedError: No timezone field failed to convert to correct time ==> expected: <2022-12-18T19:39:20Z> but was: <2022-12-18T18:39:20Z>
[ERROR]   GMTConversionWithoutJdbcTimezoneTest.getting_as_local_date_time:53 Multiple Failures (1 failure)
        org.opentest4j.AssertionFailedError: No timezone field failed to convert to correct time ==> expected: <2022-12-18T20:39:20> but was: <2022-12-18T19:39:20>
[ERROR]   GMTConversionWithoutJdbcTimezoneTest.getting_as_offset_date_time:78 Multiple Failures (1 failure)
        org.opentest4j.AssertionFailedError: No timezone field failed to convert to correct time ==> expected: <2022-12-18T20:39:20+01:00> but was: <2022-12-18T19:39:20+01:00>
[ERROR]   GMTConversionWithoutJdbcTimezoneTest.getting_as_zoned_date_time:103 Multiple Failures (1 failure)
        org.opentest4j.AssertionFailedError: No timezone field failed to convert to correct time ==> expected: <2022-12-18T20:39:20+01:00[Etc/GMT-1]> but was: <2022-12-18T19:39:20+01:00[Etc/GMT-1]>
[INFO]
[ERROR] Tests run: 16, Failures: 4, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
# [...]
```

#### Hibernate ORM 6

Following errors occour when Hibernate ORM 6 is used (line numbers might differ between subprojects):

```bash
# [...]
[INFO] Results:
[INFO]
[ERROR] Failures:
[ERROR]   GMTConversionWithoutJdbcTimezoneTest.getting_as_local_date_time:52 Multiple Failures (1 failure)
        org.opentest4j.AssertionFailedError: No timezone field failed to convert to correct time ==> expected: <2022-12-18T20:39:20> but was: <2022-12-18T19:39:20>
[ERROR]   GMTConversionWithoutJdbcTimezoneTest.getting_as_offset_date_time:77 Multiple Failures (1 failure)
        org.opentest4j.AssertionFailedError: No timezone field failed to convert to correct time ==> expected: <2022-12-18T20:39:20+01:00> but was: <2022-12-18T19:39:20+01:00>
[ERROR]   GMTConversionWithoutJdbcTimezoneTest.getting_as_zoned_date_time:102 Multiple Failures (1 failure)
        org.opentest4j.AssertionFailedError: No timezone field failed to convert to correct time ==> expected: <2022-12-18T20:39:20+01:00[Etc/GMT-1]> but was: <2022-12-18T19:39:20+01:00[Etc/GMT-1]>
[INFO]
[ERROR] Tests run: 16, Failures: 3, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
# [...]
```

#### Hibernate Reactie

Following errors occour when Hibernate Reactive is used (line numbers might differ between subprojects):

```bash
# [...]
[INFO] Results:
[INFO]
[ERROR] Failures:
[ERROR]   GMTConversionWithoutJdbcTimezoneTest.getting_as_instants:57 Expected an item event but got a failure: org.opentest4j.MultipleFailuresError: Multiple Failures (3 failures)
        org.opentest4j.AssertionFailedError: No timezone field failed to convert to correct time ==> expected: <2022-12-18T19:39:20Z> but was: <2022-12-18T18:39:20Z>
        org.opentest4j.AssertionFailedError: Timezone field failed to convert to correct time ==> expected: <2022-12-18T18:39:20Z> but was: <2022-12-18T17:39:20Z>
        org.opentest4j.AssertionFailedError: Timezone with gmt +2 field failed to convert to correct time ==> expected: <2022-12-18T17:39:20Z> but was: <2022-12-18T16:39:20Z>
[ERROR]   GMTConversionWithoutJdbcTimezoneTest.getting_as_local_date_time:91 Expected an item event but got a failure: org.opentest4j.MultipleFailuresError: Multiple Failures (3 failures)
        org.opentest4j.AssertionFailedError: No timezone field failed to convert to correct time ==> expected: <2022-12-18T20:39:20> but was: <2022-12-18T19:39:20>
        org.opentest4j.AssertionFailedError: Timezone field failed to convert to correct time ==> expected: <2022-12-18T19:39:20> but was: <2022-12-18T18:39:20>
        org.opentest4j.AssertionFailedError: Timezone with gmt +2 field failed to convert to correct time ==> expected: <2022-12-18T18:39:20> but was: <2022-12-18T17:39:20>
[ERROR]   GMTConversionWithoutJdbcTimezoneTest.getting_as_offset_date_time:125 Expected an item event but got a failure: org.opentest4j.MultipleFailuresError: Multiple Failures (3 failures)
        org.opentest4j.AssertionFailedError: No timezone field failed to convert to correct time ==> expected: <2022-12-18T20:39:20+01:00> but was: <2022-12-18T19:39:20+01:00>
        org.opentest4j.AssertionFailedError: Timezone field failed to convert to correct time ==> expected: <2022-12-18T19:39:20+01:00> but was: <2022-12-18T18:39:20+01:00>
        org.opentest4j.AssertionFailedError: Timezone with gmt +2 field failed to convert to correct time ==> expected: <2022-12-18T18:39:20+01:00> but was: <2022-12-18T17:39:20+01:00>
[ERROR]   GMTConversionWithoutJdbcTimezoneTest.getting_as_zoned_date_time:159 Expected an item event but got a failure: org.opentest4j.MultipleFailuresError: Multiple Failures (3 failures)
        org.opentest4j.AssertionFailedError: No timezone field failed to convert to correct time ==> expected: <2022-12-18T20:39:20+01:00[Etc/GMT-1]> but was: <2022-12-18T19:39:20+01:00[Etc/GMT-1]>
        org.opentest4j.AssertionFailedError: Timezone field failed to convert to correct time ==> expected: <2022-12-18T19:39:20+01:00[Etc/GMT-1]> but was: <2022-12-18T18:39:20+01:00[Etc/GMT-1]>
        org.opentest4j.AssertionFailedError: Timezone with gmt +2 field failed to convert to correct time ==> expected: <2022-12-18T18:39:20+01:00[Etc/GMT-1]> but was: <2022-12-18T17:39:20+01:00[Etc/GMT-1]>
[INFO]
[ERROR] Tests run: 16, Failures: 4, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
# [...]
```

## Formatting

**Prerequisite:** Npm

Formatting is done by prettier and its plugins:

```bash script
npm install
npx prettier --write .
```

## Random notes

**Q:** Is it Hibernate 5, 6 and Reactive doing something wrong with the conversion from the database drivers?
**Q:** Are the database drivers not aware that the postgreSQL is always running/storing data in UTC?
**Q:** Might this not be a bug, but an intented feature?
**Q:** Am I being stupid, since similar stuff has been documented in <https://in.relation.to/2016/09/12/jdbc-time-zone-configuration-property/>?
**Q:** Am I running around in circles and should always specifiy both `user.timezone` and `hibernate.jdbc.time_zone/hibernate-orm.jdbc.time_zone` if the user isn't running `UTC`?
