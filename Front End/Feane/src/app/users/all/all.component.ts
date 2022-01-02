import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/shared/user.model';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {
  
  selectedUser: User;
  users: User[];

  constructor(private router: Router, private userService:UserService) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers():any{
    return this.userService.getAllUsers().subscribe((data: any)=>{
      this.users = data;
    });
  }
  deleteUser(usreId: string){
    alert("Are you sure?");
    this.userService.deleteUser(usreId).subscribe(data=>{
      this.refreshUsersList();
      console.log(data)
    });
  }

  refreshUsersList(){
    this.userService.getAllUsers().subscribe((res)=>{
      this.userService.users = res as User[];
    });
  }

}
