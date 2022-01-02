import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsersRoutingModule } from './users-routing.module';
import { UsersComponent } from './users.component';
import { UserComponent } from './user/user.component';
import { AllComponent } from './all/all.component';


@NgModule({
  declarations: [
    UsersComponent,
    UserComponent,
    AllComponent
  ],
  imports: [
    CommonModule,
    UsersRoutingModule
  ]
})
export class UsersModule { }
