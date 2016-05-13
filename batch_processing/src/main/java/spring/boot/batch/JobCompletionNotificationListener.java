package spring.boot.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mhan on 5/13/16.
 */
public class JobCompletionNotificationListener extends JobExecutionListenerSupport{

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution){
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.info(">>> JOB FINISHED DUDE !! Verifying results...");
            List<Human> results = jdbcTemplate.query("SELECT first_name, last_name FROM humans", new RowMapper<Human>() {
                @Override
                public Human mapRow(ResultSet resultSet, int raw) throws SQLException {
                    return new Human(resultSet.getString(1), resultSet.getString(2));
                }
            });
            for(Human human: results){
                log.info("Human <"+human+"> found in the database.");
            }
        }
    }

}
