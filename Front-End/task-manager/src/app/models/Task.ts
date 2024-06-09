import { TaskStatus } from "./TaskStatus";

export class Task {
    name: string = '';
    description: string = '';
    creationDate: Date = new Date();
    status: TaskStatus = TaskStatus.PENDING;
    admin: Number = 0;

    toString(): string {
        let body = new URLSearchParams();
        body.set('name', this.name);
        body.set('description', this.description);

        return body.toString();
    }
};