import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { API_URL } from '../../../constants/api.contants';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Task } from '../../../models/Task';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './createTask.component.html',
  styleUrl: './createTask.component.css'
})

export class CreateTaskComponent {
  title = 'task-manager';

  task: Task = new Task();

  constructor(private http: HttpClient){
    
  }

  onSubmit(){
    this.http.post(`${API_URL}/task/add`, this.task).subscribe((r:any) => {
      console.log(r);
    });
  }
}
