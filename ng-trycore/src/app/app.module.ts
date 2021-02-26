import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonListComponent } from './person-list/person-list.component';
import { PlanetListComponent } from './planet-list/planet-list.component';
import { PersonFormComponent } from './person-form/person-form.component';
import { PlanetFormComponent } from './planet-form/planet-form.component';
import { PlanetServiceService } from './services/planet-service.service';
import { PersonServiceService } from './services/person-service.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PersonListComponent,
    PlanetListComponent,
    PersonFormComponent,
    PlanetFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PersonServiceService,PlanetServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
