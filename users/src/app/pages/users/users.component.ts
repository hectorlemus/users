import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: any[] = [];

  constructor(private service: UsersService ) { }

  ngOnInit(): void {
    this.loadUsers()
  }

  private loadUsers(): void {
    this.service.getUsers().subscribe((response) => {
      this.users = response;
    }, (error) => {
      console.error(error);
    });
  }

}
