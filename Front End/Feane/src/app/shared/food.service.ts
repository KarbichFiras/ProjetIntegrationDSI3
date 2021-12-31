import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of, Subject } from 'rxjs'; 
import { map } from 'rxjs/operators';
import { Food } from './food.model';
@Injectable({
  providedIn: 'root'
})
export class FoodService {
  SelectedFood : Food;
  foods:Food[];
  constructor() { }
}
