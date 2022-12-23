package com.doggy.mapper;

import com.doggy.domain.Address;
import com.doggy.domain.Person;
import com.doggy.store.PersonRepository;
import net.datafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);
    private final PersonRepository personRepository;
    private final Faker faker;

    public SampleDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading Sample Data...");

        // create 100 rows of people in the database
        List<Person> people = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),
                        new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode()
                        )
                ))
                .collect(Collectors.toList());

        personRepository.saveAll(people);
    }
}
