import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticationService} from "../service/authentication.service";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {

  username = ''
  password = ''
  invalidLogin = false

  constructor(private router: Router,
              private loginservice: AuthenticationService) {
  }

  onSubmit() {
  }

  checkLogin() {
    (this.loginservice.authenticate(this.username, this.password).subscribe(
        data => {
          this.router.navigate([''])
          this.invalidLogin = false
          console.log("asd");
        },
        error => {
          this.invalidLogin = true

        }
      )
    );

  }

}


