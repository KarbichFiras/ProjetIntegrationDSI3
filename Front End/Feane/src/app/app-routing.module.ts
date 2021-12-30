import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule , Routes } from '@angular/router';
import { AddMenuComponent } from './add-menu/add-menu.component';
const routes : Routes =[

  { path: '',   redirectTo: 'home', pathMatch: 'full' },
  {path :"addmenu" , component : AddMenuComponent },
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forRoot(routes) ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
