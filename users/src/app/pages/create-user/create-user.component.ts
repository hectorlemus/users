import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  userStatus: any[] = [];
  userForm: FormGroup;

  constructor(
    private service: UsersService,
    private router: Router
  ) {
    this.userForm = new FormGroup({
      name: new FormControl(null, [Validators.required, Validators.minLength(3)]),
      email: new FormControl(null, [Validators.required, Validators.email]),
      gender: new FormControl(null, [Validators.required]),
      status: new FormControl(null, [Validators.required]),
    });
  }

  ngOnInit(): void {
    this.loadUserStatus();
  }

  private loadUserStatus(): void {
    this.service.getUserStatus().subscribe((response) => {
      this.userStatus = response;
    }, (error) => {
      console.log(error);
    })
  }

  isInputInvalid(inputName: string): boolean {
    const control = this.userForm.get(inputName);
    return control != null && control.invalid && this.userForm.touched;
  }

  saveUser(): void {
    if (this.userForm.valid) {
      this.service.saveUser(this.userForm.value).subscribe((response) => {
        this.router.navigate(['/']);
      }, (error) => {
        console.log(error);
      });
    }
  }

}
