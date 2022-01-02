import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { User } from './user.model';

  const BASE_URL = "http://127.0.0.1:3000/users";
@Injectable()
export class UserService {
  
  constructor(private _http:HttpClient) { }
  // Get all users 
  getAllUsers() {
    return this._http.get(BASE_URL+"/");
  }
  
  // Get User By Id
  getUserById(userId: string) {
    let p=new HttpParams().set('id',userId);
    return this._http.get(BASE_URL+"/", {params:p});
  }

  // Update User
  updateUser(user: User){
    let p=new HttpParams().set('id',user._id);
    return this._http.put(BASE_URL + "/update", user, {params: p});;
  }

  //Delete User 
  deleteUser(userId: string ){
    return this._http.delete(BASE_URL + "/delete/"+userId );
  }
  
  // Register User
  register(body:any){
    return this._http.post(BASE_URL+'/register',body,{
      observe:'body',
      headers:new HttpHeaders().append('Content-Type','application/json')
    });
  }

  login(body:any){
    return this._http.post(BASE_URL+'/login',body,{
      observe:'body',
      withCredentials:true,
      headers:new HttpHeaders().append('Content-Type','application/json')
    });
  }

  user(){
    return this._http.get(BASE_URL+'/user',{
      observe:'body',
      withCredentials:true,
      headers:new HttpHeaders().append('Content-Type','application/json')
    })
  }

  logout(){
    return this._http.get(BASE_URL+'/logout',{
      observe:'body',
      withCredentials:true,
      headers:new HttpHeaders().append('Content-Type','application/json')
    })
  }

}
