import { Component, OnInit } from '@angular/core';
import { CityService } from '../city.service';
import { Router } from '@angular/router';
import { City } from '../city';



@Component({
  selector: 'app-add-city',
  templateUrl: './add-city.component.html',
  styleUrls: ['./add-city.component.css']
})
export class AddCityComponent implements OnInit {

  city: City = new City();
  submitted = false;

  constructor(private cityService: CityService,
              private router: Router) { }

  ngOnInit() {
  }

  newCity(): void {
    this.submitted = false;
    this.city = new City();
  }

  save() {
    this.cityService.createCity(this.city)
      .subscribe(data => console.log(data), error => console.log(error));
    this.city = new City();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/cities']);
    }
}
