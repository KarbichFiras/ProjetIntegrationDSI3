import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of, Subject } from 'rxjs'; 
import { map } from 'rxjs/operators';

import { Menu } from './menu.model';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  SelectedMenu : Menu;
  menus:Menu[];

  readonly baseURL = 'http://localhost:3000/menu';
  constructor(private http: HttpClient) { }
  postMenu(menuu : Menu){
   return this.http.post(this.baseURL, menuu);
  }

  getMenuList(){
    return this.http.get(this.baseURL);
  }
  putMenu(men: Menu) {
    return this.http.put(this.baseURL + `/${men._id}`, men);
  }
  deleteMenu(_id: string) {
    return this.http.delete(this.baseURL + `/${_id}`);
  }
}