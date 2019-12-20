import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UserListComponent} from './user-list/user-list.component';
import {UserFormComponent} from './user-form/user-form.component';
import {CurrentUserComponent} from "./current-user/current-user.component";
import {LoginFormComponent} from "./login-form/login-form.component";
import {BidListComponent} from "./bid-list/bid-list.component";
import {ItemListComponent} from "./item-list/item-list.component";

const routes: Routes = [
  {path: 'users', component: UserListComponent},
  {path: 'adduser', component: UserFormComponent},
  {path: 'currentuser', component: CurrentUserComponent},
  {path: 'login', component: LoginFormComponent},
  {path: 'bids', component: BidListComponent},
  {path: 'items', component: ItemListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
