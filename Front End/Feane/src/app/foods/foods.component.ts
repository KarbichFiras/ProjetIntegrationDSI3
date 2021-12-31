import { Component, OnInit } from '@angular/core';

import { FoodService } from '../shared/food.service';
@Component({
  selector: 'app-foods',
  templateUrl: './foods.component.html',
  styleUrls: ['./foods.component.css'],
  providers:[FoodService]
})
export class FoodsComponent implements OnInit {

  constructor(private foodService:FoodService) { }

  ngOnInit(): void {
  }

}
