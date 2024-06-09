import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { API_URL } from '../../constants/api.contants';
import { METHODS } from 'http';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {
  title = 'task-manager';

  login: Login = new Login();

  constructor(private http: HttpClient){
    
  }

  onLogin(){
    console.log(this.login);
    this.http.post(`${API_URL}/user/login`, this.login).subscribe((r:any) => {
      console.log(r);
    });
  }
}

export class Login {
    email: string = '';
    password: string = '';
}
