import { Component, OnInit } from '@angular/core';

import { FoodService } from '../shared/food.service';

import{Food} from '../shared/food.model';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
  providers:[FoodService]
})
export class HomepageComponent implements OnInit {
 foods:any;
  constructor(private foodService:FoodService) { }

  ngOnInit(): void {
    this.getFoods();
  }
  getFoods(){
    this.foodService.getFoodList().subscribe(data=>{
     // console.log(data);
     this.foods=data;
    })
  }
}
