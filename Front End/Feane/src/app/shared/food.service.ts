import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Food } from './food.model';
@Injectable({
  providedIn: 'root'
})
export class FoodService {
  SelectedFood : Food;
  foods:Food[];
  readonly baseURL = 'http://localhost:3000/food';
  constructor(private http: HttpClient) { }

  addFood(food : Food){
    return this.http.post(this.baseURL, food);
   }

   getaddFoodList(){
    return this.http.get(this.baseURL);
  }
  updateFood(foodd : Food) {
    return this.http.put(this.baseURL + `/${foodd._id}`, foodd);
  }
  deleteFood(_id: string) {
    return this.http.delete(this.baseURL + `/${_id}`);
  }
}
