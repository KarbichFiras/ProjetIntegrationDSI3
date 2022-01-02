import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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

  constructor(private router: ActivatedRoute, private userService:UserService) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers():any{
    return this.userService.getAllUsers().subscribe((data: any)=>{
      console.log(data);
    });
  }

}
