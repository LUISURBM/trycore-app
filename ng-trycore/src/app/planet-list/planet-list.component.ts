import { Component, OnInit } from '@angular/core';
import { Planet } from '../model/planet';
import { PlanetServiceService } from '../services/planet-service.service';

@Component({
  selector: 'app-planet-list',
  templateUrl: './planet-list.component.html',
  styleUrls: ['./planet-list.component.less']
})
export class PlanetListComponent implements OnInit {

  planets:Planet[] = [];

  constructor(private planetsService: PlanetServiceService) { }

  ngOnInit(): void {
    this.planetsService.findAll().subscribe(data => {
      this.planets = data;
    });
  }

}
