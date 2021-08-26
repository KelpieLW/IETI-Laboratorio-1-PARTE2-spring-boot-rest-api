package eci.edu.ieti.controller;

import eci.edu.ieti.data.TaskDto;
import eci.edu.ieti.dto.Task;
import eci.edu.ieti.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById (@PathVariable String id){

        Task foundTask=taskService.findById(id);
        if (foundTask==null){
            return new ResponseEntity<Task> (HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Task>(foundTask, HttpStatus.OK);

        }

    }
    @GetMapping
    public ResponseEntity<List<Task>>all(){

        return new ResponseEntity<List<Task>>(taskService.all(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto){

        Task taskToCreate = new Task(taskDto.getName(), taskDto.getDescription(), taskDto.getStatus(), taskDto.getAssignedTo(), taskDto.getDueDate(), taskDto.getCreated());
        taskService.create(taskToCreate);
        return new ResponseEntity<Task>(taskToCreate, HttpStatus.ACCEPTED);
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Task> update(@RequestBody TaskDto task, @PathVariable String id){

        Task newUpdatedTask = new Task(id,task.getName(), task.getDescription(), task.getStatus(), task.getAssignedTo(),task.getDueDate(),task.getCreated());
        Task updatedTask=taskService.update(newUpdatedTask, id);
        if (updatedTask==null){
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Task>(updatedTask, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id){

        if (taskService.findById(id)==null){
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }
        else{
            taskService.deleteById(id);
            return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
        }
    }
}
