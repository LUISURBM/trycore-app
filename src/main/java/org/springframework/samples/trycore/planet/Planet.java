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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Simple JavaBean domain object representing an planet.
 *
 * @author Luis Urbina
 */
@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "dfekm")
    @NotEmpty
    private String dfekm;

    @Column(name = "ntkap")
    @NotEmpty
    private String ntkap;

    @Column(name = "contador")
    private Integer contador;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDfekm() {
        return this.dfekm;
    }

    public void setDfekm(String dfekm) {
        this.dfekm = dfekm;
    }

        public String getNtkap() {
        return this.ntkap;
    }

    public void setNtkap(String ntkap) {
        this.ntkap = ntkap;
    }

    public Integer getContador(){
        return this.contador;
    }

    public void setContador(Integer contador){
        this.contador = contador;
    }
}
