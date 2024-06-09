import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { CreateTaskComponent } from './pages/tasks/create/createTask.component';

export const routes: Routes = [
    {
        path: 'login',
        component: LoginComponent,
    },
    {
        path: 'tasks/create',
        component: CreateTaskComponent,
    },
];
