import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { API_URL } from '../../../constants/api.contants';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Task } from '../../../models/Task';
import { ActivatedRoute, RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule, HttpClientModule, RouterModule],
  templateUrl: './createTask.component.html',
  styleUrl: './createTask.component.css'
})

export class CreateTaskComponent {
  title = 'task-manager';

  id: string = '';
  task: Task = new Task();

  constructor(private http: HttpClient, private route: ActivatedRoute){
    let tmp = this.route.snapshot.paramMap.get('id');
    if(tmp == null) return;
    
    this.id = tmp;

    this.getData(`${API_URL}/task/${this.id}`, (r:Task) => {
      this.task.id = r.id;
      this.task.name = r.name;
      this.task.description = r.description;
      this.task.creationDate = r.creationDate;
    });
  }

  onSubmit(){

    if(!this.task.name || !this.task.description){
      alert('Please fill all fields with (*) to continue');
      return;
    }

    let str = this.task.toString();
    this.postData(`${API_URL}/task/add`, str, (r:any) => {
      console.log(r);
    })
  }

  postData(url: string, body: any, after: CallableFunction){
    let headers = new HttpHeaders({
      "Content-Type": "application/x-www-form-urlencoded",
      "Accept": "application/json"
    });

    this.http.post(url, body, {
      headers: headers
    }).subscribe((r:any) => after(r), (err:any) => alert(err.error.message));
  }

  getData(url: string, after: CallableFunction){
    let headers = new HttpHeaders({
      "Content-Type": "application/x-www-form-urlencoded",
      "Accept": "application/json"
    });

    this.http.get(url, {
      headers: headers
    }).subscribe((r:any) => after(r), (err:any) => alert(err.error.message));
  }
}
