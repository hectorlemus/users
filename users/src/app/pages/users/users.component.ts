import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: any[] = [];

  paginationList: any[] = [];
  paginationElements = 10;
  paginationIndex = 0;

  constructor(private service: UsersService ) { }

  ngOnInit(): void {
    this.loadUsers()
  }

  previous(): void {
    if (this.paginationIndex > 0) {
      this.paginationIndex = this.paginationIndex - 1;
      this.setPaginationList();
    }
  }

  next(): void {
    if (((this.paginationIndex + 1) * this.paginationElements) < this.users.length) {
      this.paginationIndex = this.paginationIndex + 1;
      this.setPaginationList();
    }
  }

  private setPaginationList(): void {
    const start = 0 + this.paginationIndex * this.paginationElements;
    const end = (this.paginationIndex + 1) * this.paginationElements;
    this.paginationList = this.users.slice(start, end);
  }

  private loadUsers(): void {
    this.service.getUsers().subscribe((response) => {
      this.users = response;
      this.setPaginationList();
    }, (error) => {
      console.error(error);
    });
  }

}
