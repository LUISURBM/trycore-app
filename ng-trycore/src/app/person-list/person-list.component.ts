import { Component, OnInit } from '@angular/core';
import { PersonServiceService } from '../services/person-service.service';
import { Person } from '../model/person';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.less']
})
export class PersonListComponent implements OnInit {

  persons:Person[] = [];

  constructor(private personsService: PersonServiceService) { }

  ngOnInit(): void {
    this.personsService.findAll().subscribe(data => {
      this.persons = data;
    });
  }

}
