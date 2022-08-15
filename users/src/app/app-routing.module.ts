import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateUserComponent } from './pages/create-user/create-user.component';
import { EditUserComponent } from './pages/edit-user/edit-user.component';
import { UsersComponent } from './pages/users/users.component';

const routes: Routes = [
  {
    path: "",
    component: UsersComponent
  },
  {
    path: "add",
    component: CreateUserComponent
  },
  {
    path: "edit/:id",
    component: EditUserComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
