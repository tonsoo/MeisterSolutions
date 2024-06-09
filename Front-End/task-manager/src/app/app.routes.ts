import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { CreateTaskComponent } from './pages/tasks/create/createTask.component';
import { ListTaskComponent } from './pages/tasks/list/listTask.component';

export const routes: Routes = [
    {
        path: 'login',
        component: LoginComponent,
    },
    {
        path: 'tasks/create',
        component: CreateTaskComponent,
    },
    {
        path: 'tasks/list',
        component: ListTaskComponent,
    },
];
