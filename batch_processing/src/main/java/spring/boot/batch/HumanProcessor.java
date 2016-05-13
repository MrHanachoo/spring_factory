package spring.boot.batch;

import org.springframework.batch.item.ItemProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mhan on 5/12/16.
 */
public class HumanProcessor implements ItemProcessor<Human, Human>{

    private static final Logger log = LoggerFactory.getLogger(HumanProcessor.class);

    @Override
    public Human process(Human human) throws Exception {

        final String firstName = human.getFirstName().toUpperCase();
        final String lastName = human.getLastName().toUpperCase();

        final Human tranformedHuman = new Human(firstName, lastName);

        log.info("Converting ("+human+") into -> ("+tranformedHuman+")");
        return tranformedHuman;
    }
}
