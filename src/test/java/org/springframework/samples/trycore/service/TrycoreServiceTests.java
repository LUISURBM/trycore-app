/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.trycore.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.trycore.planet.Planet;
import org.springframework.samples.trycore.planet.PlanetRepository;
import org.springframework.samples.trycore.person.Person;
import org.springframework.samples.trycore.person.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration test of the Service and the Repository layer.
 * <p>
 * ClinicServiceSpringDataJpaTests subclasses benefit from the following
 * services provided by the Spring TestContext Framework:
 * </p>
 * <ul>
 * <li><strong>Spring IoC container caching</strong> which spares us unnecessary
 * set up time between test execution.</li>
 * <li><strong>Dependency Injection</strong> of test fixture instances, meaning
 * that we don't need to perform application context lookups. See the use of
 * {@link Autowired @Autowired} on the <code>{@link
 * ClinicServiceTests#clinicService clinicService}</code> instance variable,
 * which uses autowiring <em>by type</em>.
 * <li><strong>Transaction management</strong>, meaning each test method is
 * executed in its own transaction, which is automatically rolled back by
 * default. Thus, even if tests insert or otherwise change database state, there
 * is no need for a teardown or cleanup script.
 * <li>An {@link org.springframework.context.ApplicationContext
 * ApplicationContext} is also inherited and can be used for explicit bean
 * lookup if necessary.</li>
 * </ul>
 *
 * @author Luis Urbina
 */

@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class TrycoreServiceTests {

    @Autowired
    protected PersonRepository persons;

    @Autowired
    protected PlanetRepository planets;

    @Test
    public void shouldFindPersonByFirstName() {
        Collection<Person> personas = this.persons.findByPlanet("Venuss");
        assertThat(personas).isEmpty();
    }

    @Test
    public void shouldFindSinglePlanetWithPet() {
        Planet planet = this.planets.findByFirstName("Mercury");
        assertThat(planet.getFirstName()).startsWith("Mercury");
        assertThat(planet.getDfekm()).isEqualTo("40218249");
    }

    @Test
    @Transactional
    public void shouldInsertPerons() {
        Collection<Person> personas = this.persons.findByPlanet("Earth");
        int found = personas.size();

        Person person = new Person();
        person.setFirstName("Sam");
        person.setPlanet("Earth");
        person.setContador(4);
        this.persons.save(person);
        assertThat(person.getContador()).isNotEqualTo(0);

        personas = this.persons.findByPlanet("Earth");
        assertThat(personas.size()).isEqualTo(found + 1);
    }

    @Test
    @Transactional
    public void shouldUpdateOwner() {
        Person person = (Person) this.persons.findAll().toArray()[1];
        String name = person.getFirstName();
        String newName = name + "X";

        person.setFirstName(newName);
        this.persons.save(person);

        // retrieving new name from database
        Collection<Person> personas = this.persons.findAll();
        assertThat(personas.contains(person)).isEqualTo(true);
    }


}
