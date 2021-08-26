package eci.edu.ieti.service.imp;

import eci.edu.ieti.dto.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskService implements eci.edu.ieti.service.TaskService {

    private HashMap<String,Task> taskPersistence =new HashMap<String,Task>();

    @Override
    public Task create(Task task) {
        Task createdTask=new Task(task.getName(), task.getDescription(), task.getStatus(), task.getAssignedTo(), task.getDueDate(), task.getCreated());
        taskPersistence.put(createdTask.getId(), createdTask);
        return createdTask;
    }

    @Override
    public Task findById(String id) {
        Task foundTask = null;
        taskPersistence.get(id);
        return foundTask;
    }

    @Override
    public List<Task> all() {
        ArrayList<Task> usersList=new ArrayList<Task>(taskPersistence.values());
        return usersList;
    }

    @Override
    public void deleteById(String id) {
        taskPersistence.remove(id);
    }

    @Override
    public Task update(Task task, String id) {
        Task foundUser = findById(id);
        if(foundUser!=null){
            taskPersistence.put(id, task);
        }
        return foundUser;

    }
}
