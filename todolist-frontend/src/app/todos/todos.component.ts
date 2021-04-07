import { Component, OnInit } from '@angular/core';
import { Todo } from '../model/Todo';
import { TodosService } from '../service/todos.service';


@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css']
})
export class TodosComponent implements OnInit {

  todos:Todo[];

  inputTodo:string = "";

  constructor(private todosService: TodosService) { 

  }

  ngOnInit(): void {
    this.refreshTodos();
  }

  refreshTodos () {
    this.todosService.retrieveAllTodos()
    .subscribe( 
      (data) => {
        console.log(data)
      this.todos = data;
    });
  }

  toggleDone (todo: Todo, id: number) {
    this.todosService.toggleTodoComplete(todo, id)
    .subscribe(data => {
      console.log(data);
      this.refreshTodos();
    })
  }

  deleteTodo (id:number) {
    this.todosService.deleteTodo(id.toString())
    .subscribe(data => {
      console.log(data);
      this.refreshTodos();
    })
  }

  addTodo () {
    this.todosService.addTodo(this.inputTodo)
    .subscribe(data => {
      console.log(data);
      this.refreshTodos();
    });
    this.inputTodo = "";
  }

}
