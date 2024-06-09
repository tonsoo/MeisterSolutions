import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { API_URL } from '../../constants/api.contants';
import { METHODS } from 'http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {
  title = 'task-manager';

  login: Login = new Login();

  onLogin(){
    fetch(`${API_URL}/user/login`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      mode: 'cors',
      // mode: 'no-cors',
      body: JSON.stringify({
        email: this.login.email,
        password:  this.login.password
      })
    }).then(r => r.json()).then(j => console.log(j)).catch(e => {
      console.log(e);
    });
  }
}

export class Login {
    email: string = '';
    password: string = '';
}
