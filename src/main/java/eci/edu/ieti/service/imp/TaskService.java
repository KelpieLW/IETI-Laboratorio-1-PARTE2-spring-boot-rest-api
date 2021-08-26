package eci.edu.ieti.service.imp;

import eci.edu.ieti.dto.Task;
import eci.edu.ieti.model.StatusType;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskService implements eci.edu.ieti.service.TaskService {

    private HashMap<String,Task> taskPersistence =new HashMap<String,Task>();

    /**
     * Constructor que introduce dos ejemplos de Task en el HashMap
     */
    public TaskService(){
        Task testTask1 = new Task("Buscar", "Busqueda", StatusType.TODO, "Amanda",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        Task testTask2 = new Task("Encontrar", "Encontrado", StatusType.DONE, "Amanda",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        taskPersistence.put(testTask1.getId(), testTask1);
        taskPersistence.put(testTask2.getId(), testTask2);
    }

    /**
     * Crea una nueva tarea y la introduce en el HashMap de persistencia
     * Retorna la tarea que fue introducida para crearse
     * @param task
     * @return
     */
    @Override
    public Task create(Task task) {
        Task createdTask=new Task(task.getName(), task.getDescription(), task.getStatus(), task.getAssignedTo(), task.getDueDate(), task.getCreated());
        taskPersistence.put(createdTask.getId(), createdTask);
        return createdTask;
    }

    /**
     * Busca un el identificador de una tarea en el HashMap
     * Retorna dicha tarea, o null en caso de no ser encontrada
     * @param id
     * @return
     */
    @Override
    public Task findById(String id) {
        Task foundTask = taskPersistence.get(id);
        return foundTask;
    }

    /**
     * Retorna una lista con todas las tareas registradas en el HashMap
     * @return
     */
    @Override
    public List<Task> all() {
        ArrayList<Task> usersList=new ArrayList<Task>(taskPersistence.values());
        return usersList;
    }

    /**
     * Elimina una tarea del HashMap si esta coincide con el id ingresado como parametro
     * @param id
     */
    @Override
    public void deleteById(String id) {
        taskPersistence.remove(id);
    }

    /**
     * Actualiza el valor de una tarea existente conservando el id original de la tarea
     * Retorna null si no fue posible encontrar la tarea a modificar
     * Retorna La tarea nueva en caso de haberse encontrado y modificado exitosamente
     * @param task
     * @param id
     * @return
     */
    @Override
    public Task update(Task task, String id) {
        Task foundTask = findById(id);
        if(foundTask!=null){
            taskPersistence.put(id, task);
            foundTask=task;
        }

        return task;

    }
}
