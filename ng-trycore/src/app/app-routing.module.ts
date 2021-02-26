import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PersonListComponent } from './person-list/person-list.component';
import { PersonFormComponent } from './person-form/person-form.component';
import { PlanetListComponent } from './planet-list/planet-list.component';
import { PlanetFormComponent } from './planet-form/planet-form.component';

const routes: Routes = [
  { path: 'persons', component: PersonListComponent },
  { path: 'viewperson/:name', component: PersonFormComponent },
  { path: 'planets', component: PlanetListComponent },
  { path: 'viewplanet/:name', component: PlanetFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
