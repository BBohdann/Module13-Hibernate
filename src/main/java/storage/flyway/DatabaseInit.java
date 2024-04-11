package storage.flyway;

import org.flywaydb.core.Flyway;

public class DatabaseInit {
        public void initDb() {
            Flyway flyway = Flyway
                    .configure()
                    .dataSource("jdbc:postgresql://localhost:32771/spacetraveldb", "postgres", "321")
                    .load();
            flyway.migrate();
    }
}
