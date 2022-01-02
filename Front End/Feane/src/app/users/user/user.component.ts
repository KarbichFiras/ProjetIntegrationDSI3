import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/shared/user.model';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  selectedUser: User;
  users: User[] = [];

  constructor(private router:ActivatedRoute, private userService: UserService) { }

  ngOnInit(): void {
    this.getUserId();
  }

  getUserId():string{
    console.log(this.router.snapshot.params['id'])
    return this.router.snapshot.params['id'];

  }

}
