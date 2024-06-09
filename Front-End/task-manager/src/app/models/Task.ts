import { TaskStatus } from "./TaskStatus";

export class Task {
    id: Number = 0;
    name: string = '';
    description: string = '';
    creationDate: Date = new Date();
    status: TaskStatus = TaskStatus.PENDING;
    admin: Number = 1;

    toString(): string {
        let body = new URLSearchParams();
        body.set('name', this.name);
        body.set('description', this.description);
        body.set('admin', this.admin.toString());

        return body.toString();
    }
};