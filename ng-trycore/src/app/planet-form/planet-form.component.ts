import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { Planet } from '../model/planet';
import { PlanetServiceService } from '../services/planet-service.service';

@Component({
  selector: 'app-planet-form',
  templateUrl: './planet-form.component.html',
  styleUrls: ['./planet-form.component.less']
})
export class PlanetFormComponent implements OnInit {

  planet: Planet;
  constructor(
  private route: ActivatedRoute,
  private router: Router,
  private planetsService: PlanetServiceService) { }

  ngOnInit(): void {

  this.route.params
    .switchMap((params: Params) => this.planetsService.findAll().filter(p -> p.firstName = params['name']))
    .subscribe((planet) => this.planet = planet);
  this.planetsService.save(this.planet.contador++);
  }

}
