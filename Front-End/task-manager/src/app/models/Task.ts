import { TaskStatus } from "./TaskStatus";

export class Task {
    title: String = '';
    description: String = '';
    creationDate: Date = new Date();
    status: TaskStatus = TaskStatus.PENDING;
};