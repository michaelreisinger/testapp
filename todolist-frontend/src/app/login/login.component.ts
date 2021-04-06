import { AuthenticationService } from '../service/authentication.service';
import { HttpHeaders, HttpClient} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password : string;
  errorMessage = 'Invalid Credentials';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) {   }

  ngOnInit() {
  }

  handleLogin() {
    this.authenticationService.authenticate(this.username, this.password)
    .subscribe(()=> {
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = "ok";
      this.router.navigate(['/todos']);
    }, 
    () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });      
  }

}
