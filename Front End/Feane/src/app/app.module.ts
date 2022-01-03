import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AddMenuComponent } from './add-menu/add-menu.component'; 


import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { HomepageComponent } from './homepage/homepage.component';
import { RestoprofileComponent } from './restoprofile/restoprofile.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { FoodsComponent } from './foods/foods.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserService } from './shared/user.service';
import { HomeuserComponent } from './homeuser/homeuser.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { UserComponent } from './user/user.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    
    AddMenuComponent,
    HomepageComponent,
    RestoprofileComponent,
    EditprofileComponent,
    FoodsComponent,
    LoginComponent,
    RegisterComponent,
    HomeuserComponent,
    NotFoundComponent,
    UserComponent,

    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    
    AppRoutingModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
function InMemoryDataService(InMemoryDataService: any): any[] | import("@angular/core").Type<any> | import("@angular/core").ModuleWithProviders<{}> {
  throw new Error('Function not implemented.');
}

