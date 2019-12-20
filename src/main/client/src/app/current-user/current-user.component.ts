import {Component, OnInit} from '@angular/core';
import {User} from "../model/user";
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-current-user',
  templateUrl: './current-user.component.html',
  styleUrls: ['./current-user.component.css']
})
export class CurrentUserComponent implements OnInit {

  user: User;


  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.userService.findById(2).subscribe(data => {
      this.user = data;
      console.log();
    });
  }
}
