import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule , Routes } from '@angular/router';
import { AddMenuComponent } from './add-menu/add-menu.component';
import { HomepageComponent } from './homepage/homepage.component';
import { RestoprofileComponent } from './restoprofile/restoprofile.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { FoodsComponent } from './foods/foods.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeuserComponent } from './homeuser/homeuser.component';
const routes : Routes =[

  { path: '',   redirectTo: 'homepage', pathMatch: 'full' },
  {path :"addmenu" , component : AddMenuComponent },
  {path :"addFood" , component : FoodsComponent },
  {path :"homepage" , component : HomepageComponent },
  {path :"restoprofile" , component : RestoprofileComponent },
  {path :"editprofile" , component : EditprofileComponent },
  {path :"login" , component : LoginComponent },
  {path :"register" , component : RegisterComponent },
  {path :"userhome" , component : HomeuserComponent },
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forRoot(routes) ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
