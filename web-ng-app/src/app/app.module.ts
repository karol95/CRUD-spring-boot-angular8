import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddCityComponent } from './add-city/add-city.component';
import { DetailsCityComponent } from './details-city/details-city.component' ;
import { ListCitiesComponent } from './list-cities/list-cities.component';
import { UpdateCityComponent } from './update-city/update-city.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    AddCityComponent,
    DetailsCityComponent,
    ListCitiesComponent,
    UpdateCityComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
