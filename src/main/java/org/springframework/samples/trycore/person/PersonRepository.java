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
package org.springframework.samples.trycore.person;

import java.util.Collection;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository class for <code>Person</code> domain objects All method names are compliant with Spring Data naming
 * conventions so this interface can easily be extended for Spring Data.
 * See: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 *
 * @author Luis Urbina
 */
public interface PersonRepository extends Repository<Person, Integer> {

    /**
     * Retrieve all <code>Person</code>s from the data store.
     *
     * @return a <code>Collection</code> of <code>Person</code>s
     */
    @Transactional(readOnly = true)
    @Cacheable("persons")
    Collection<Person> findAll() throws DataAccessException;


    /**
     * Retrieve {@link Planet}s from the data store by first name, returning all planets
     * whose planet <i>starts</i> with the given Planet name.
     * @param planet Value to search for
     * @return a Collection of matching {@link planet}s (or an empty Collection if none
     * found)
     */
    @Query("SELECT DISTINCT person FROM Person person WHERE person.planet LIKE :planet%")
    @Transactional(readOnly = true)
    Collection<Person> findByPlanet(@Param("planet") String planet);


    /**
     * Save an {@link Person} to the data store, either inserting or updating it.
     * @param person the {@link person} to save
     */
    void save(Person person);


}
