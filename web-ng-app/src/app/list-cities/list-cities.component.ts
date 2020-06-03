import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { City } from '../city';
import { CityService } from '../city.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-cities',
  templateUrl: './list-cities.component.html',
  styleUrls: ['./list-cities.component.css']
})

export class ListCitiesComponent implements OnInit {

  cities: Observable<City[]>;

  constructor(private cityService: CityService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.cities = this.cityService.getCitiesList();
    console.log(this.cities);
  }

  deleteCity(id: number) {
    this.cityService.deleteCity(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  cityDetails(id: number) {
    this.router.navigate(['details', id]);
  }

}
