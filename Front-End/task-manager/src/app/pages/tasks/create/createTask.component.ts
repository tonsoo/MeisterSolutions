import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { API_URL } from '../../../constants/api.contants';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Task } from '../../../models/Task';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule, HttpClientModule, RouterModule],
  templateUrl: './createTask.component.html',
  styleUrl: './createTask.component.css'
})

export class CreateTaskComponent {
  title = 'task-manager';

  task: Task = new Task();

  constructor(private http: HttpClient){
    
  }

  onSubmit(){
    const url = `${API_URL}/task/add`;

    let headers = new HttpHeaders({
        "Content-Type": "application/x-www-form-urlencoded",
        "Accept": "application/json"
    });
    
    let str = this.task.toString();
    console.log(str);
    this.http.post(url, str, {
        headers: headers
    }).subscribe((r:any) => console.log(r));
  }
}
