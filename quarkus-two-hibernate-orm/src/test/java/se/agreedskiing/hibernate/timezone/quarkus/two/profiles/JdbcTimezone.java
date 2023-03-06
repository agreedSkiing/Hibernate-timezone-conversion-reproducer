package se.agreedskiing.hibernate.timezone.quarkus.two.profiles;

import io.quarkus.test.junit.QuarkusTestProfile;
import java.util.Map;

public class JdbcTimezone implements QuarkusTestProfile {

  @Override
  public Map<String, String> getConfigOverrides() {
    return Map.of("quarkus.hibernate-orm.jdbc.timezone", "UTC");
  }
}
