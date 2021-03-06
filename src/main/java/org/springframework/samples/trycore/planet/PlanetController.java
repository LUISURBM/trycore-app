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
package org.springframework.samples.trycore.planet;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Luis Urbina
 */
@Controller
@CrossOrigin(origins = "*")
class PlanetController {

    private final PlanetRepository planets;


    public PlanetController(PlanetRepository clinicService) {
        this.planets = clinicService;
    }
    
    @GetMapping("/planets")
    public List<Planet> getPlanets() {
        return (List<Planet>) planets.findAll();
    }

    @PostMapping("/planets")
    void addPlanet(@RequestBody Planet planet) {
        planets.save(planet);
    }

}
