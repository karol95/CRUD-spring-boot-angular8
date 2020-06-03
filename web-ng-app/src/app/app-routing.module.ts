import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddCityComponent } from './add-city/add-city.component';
import { UpdateCityComponent } from './update-city/update-city.component';
import { DetailsCityComponent } from './details-city/details-city.component';
import { ListCitiesComponent } from './list-cities/list-cities.component';



const routes: Routes = [
  { path: '', redirectTo: 'city', pathMatch: 'full' },
  { path: 'cities', component: ListCitiesComponent },
  { path: 'add', component: AddCityComponent },
  { path: 'update/:id', component: UpdateCityComponent },
  { path: 'details/:id', component: DetailsCityComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
