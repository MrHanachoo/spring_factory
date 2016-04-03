package com.medhan.spring.rest.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mhan on 3/20/16.
 */
@SpringBootApplicatio
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        log.info("Creating tables");
        jdbcTemplate.execute("DROP TABLE users IF EXISTS ");
        jdbcTemplate.execute("CREATE TABLE users(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
        List<Object[]> splitUpNames = Arrays.asList("Med Han", "Mr Hanachoo", "Han Med", "Hannouchou Hannouchou")
                .stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s",
                                        name[0], name[1])));
        jdbcTemplate.batchUpdate("INSERT into users(first_name, last_name) VALUES (?,?)", splitUpNames);

        log.info("Querying for customer records where first='Mr':");

        jdbcTemplate.query("Select id, first_name, last_name FROM users where first_name=?", new Object[] {"Mr"},
                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
                ).forEach(user -> log.info(user.toString()));
    }
}
