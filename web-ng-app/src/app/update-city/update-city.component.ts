import { Component, OnInit } from '@angular/core';
import { City } from '../city';
import { CityService } from '../city.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-city',
  templateUrl: './update-city.component.html',
  styleUrls: ['./update-city.component.css']
})
export class UpdateCityComponent implements OnInit {

  id: number;
  city: City;

  constructor(private route: ActivatedRoute, private router: Router,
              private cityService: CityService) { }

  ngOnInit() {
    this.city = new City();

    // tslint:disable-next-line: no-string-literal
    this.id = this.route.snapshot.params['id'];

    this.cityService.getCity(this.id)
      .subscribe(data => {
        console.log(data);
        this.city = data;
      }, error => console.log(error));
  }

  updateCity() {
    this.cityService.updateCity(this.id, this.city)
      .subscribe(data => console.log(data), error => console.log(error));
    this.city = new City();
    this.gotoList();
  }

  onSubmit() {
    this.updateCity();
  }

  gotoList() {
    this.router.navigate(['/cities']);
  }
}
