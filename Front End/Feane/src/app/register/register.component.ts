import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { data } from 'jquery';
import { UserService } from '../shared/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm:FormGroup = new FormGroup({
    email:new FormControl(null,[Validators.email,Validators.required]),
    username:new FormControl(null,Validators.required),
    password:new FormControl(null,Validators.required),
    
  })
  constructor(private _router:Router,private _userService:UserService) { }

  ngOnInit(): void {
  }
  moveToLogin(){
    this._router.navigate(['/login']);
    }


    register(){
      if(!this.registerForm.valid){
        console.log('Invalid Form'); return;
      }
  
      this._userService.register(JSON.stringify(this.registerForm.value))
    .subscribe(
      data=> {console.log(data); this._router.navigate(['/login']);},
      error=>console.error(error)
    )
     // console.log(JSON.stringify(this.registerForm.value));
    }
}
