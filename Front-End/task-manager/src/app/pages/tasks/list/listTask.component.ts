import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { API_URL } from '../../../constants/api.contants';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Task } from '../../../models/Task';
import { RouterModule } from '@angular/router';
import { config } from 'process';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule, HttpClientModule, RouterModule],
  templateUrl: './listTask.component.html',
  styleUrl: './listTask.component.css'
})

export class ListTaskComponent {
  title = 'task-manager';

  tasks: Array<Task> = new Array<Task>();

  constructor(private http: HttpClient){
    this.updateList();
  }

  updateList() {
    this.http.get(`${API_URL}/task/admin/1`, {}).subscribe((r:any) => {
      console.log(`reponse from: '${API_URL}/task/admin/1': `);
      this.tasks = r;
    }, (err:any) => alert(err.error.message));
  }

  removeTask(id: Number|string){
    if(!confirm('Are you sure you want to remove this task?')){
      return;
    }

    this.http.delete(`${API_URL}/task/remove/${id}`, {}).subscribe((r:any) => {
      this.updateList();
    }, (err:any) => alert(err.error.message));
  }
}
