import { Component, OnInit } from '@angular/core';
import { Person } from '../model/person';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { PersonServiceService } from '../services/person-service.service';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.less']
})
export class PersonFormComponent implements OnInit {


  person: Person|undefined;
  constructor(
  private route: ActivatedRoute,
  private router: Router,
  private personsService: PersonServiceService) { }

  ngOnInit(): void {

   this.route.params
    .switchMap((params: Params) => this.personsService.findAll().filter(p -> p.firstName == params['name']))
    .subscribe((person:any) => this.person = person);
   this.personsService.save(this.person.contador++);
  }

}
