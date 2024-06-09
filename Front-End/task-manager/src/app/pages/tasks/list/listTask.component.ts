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
    });
  }

  // onSubmit(){
  //   const url = `${API_URL}/task/add`;

  //   let headers = new HttpHeaders({
  //       "Content-Type": "application/x-www-form-urlencoded",
  //       "Accept": "application/json"
  //   });
    
  //   let str = this.task.toString();
  //   console.log(str);
  //   this.http.post(url, str, {
  //       headers: headers
  //   }).subscribe((r:any) => console.log(r));
  // }
}
