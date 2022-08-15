import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  userForm: FormGroup | any;
  userStatus: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private service: UsersService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadUserStatus();
    this.route.params.subscribe((params) => this.loadUser(params['id']));
  }

  isInputInvalid(inputName: string): boolean {
    const control = this.userForm.get(inputName);
    return control != null && control.invalid && this.userForm.touched;
  }

  updateUser(): void {
    if (this.userForm.valid) {
      this.service.updateUser(this.userForm.value).subscribe((response) => {
        this.router.navigate(['/']);
      }, (error) => {
        console.log(error);
      });
    }
  }

  private loadUserStatus(): void {
    this.service.getUserStatus().subscribe((response) => {
      this.userStatus = response;
    }, (error) => {
      console.log(error);
    })
  }

  private loadUser(userId: any): void {
    this.service.getUser(userId).subscribe((response) => {
      this.createUserForm(response);
    }, (error) => {
      console.log(error);
    });
  }

  private createUserForm(user: any): void {
    this.userForm = new FormGroup({
      id: new FormControl(user?.id, [Validators.required]),
      name: new FormControl(user?.name, [Validators.required, Validators.minLength(3)]),
      email: new FormControl(user?.email, [Validators.required, Validators.email]),
      gender: new FormControl(user?.gender, [Validators.required]),
      status: new FormControl(user?.status?.id, [Validators.required]),
    });
  }

}
