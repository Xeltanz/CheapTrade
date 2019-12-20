import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {UserListComponent} from './user-list/user-list.component';
import {UserFormComponent} from './user-form/user-form.component';
import {UserService} from './service/user.service';
import {CurrentUserComponent} from './current-user/current-user.component';
import {LoginFormComponent} from './login-form/login-form.component';
import {AuthenticationService} from "./service/authentication.service";
import {BidListComponent} from './bid-list/bid-list.component';
import {BidService} from "./service/bid.service";
import {ItemListComponent} from './item-list/item-list.component';
import {ItemService} from "./service/item.service";

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent,
    CurrentUserComponent,
    LoginFormComponent,
    BidListComponent,
    ItemListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService, AuthenticationService, BidService, ItemService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
