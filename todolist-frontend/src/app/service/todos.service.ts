import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Todo } from '../model/Todo';
import { AuthenticationService } from './authentication.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodosService {

  constructor(private http: HttpClient, private authenticationService: AuthenticationService) { }

  API_URL = "http://localhost:8080/login/todo-api/v1";

  retrieveAllTodos() {
    return this.http.get<Todo[]>(`${this.API_URL}/all`);    
  }

  deleteTodo(id :string){
    return this.http.delete(`${this.API_URL}/delete/` + id);
  }

  addTodo(task:string){
    return this.http.post(`${this.API_URL}/new`, task);
  }

  toggleTodoComplete(todo: Todo, id: number){
    return this.http.put(`${this.API_URL}/complete/${id}`, todo);
  }
}
