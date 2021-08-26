### Part 2: Implementing the Tasks Microservice RESTFUL API

1. Create a new project using the [Spring Initializr](https://start.spring.io/)
  * Use either *Java* or *Kotlin* as programming language.
  * Use Gradle as project option(if your computer is slow then use  Maven)
  * Add Spring Web dependency before generating the project.
2. Create a new repository on Github and commit the files generated in 1.
3. Create a new package called *com.ieti.ieti.dto* and inside define your *TaskDto* object with at least the following fields:
    * name.
    * description.
    * status [TODO, DOING, REVIEW and DONE].
    * assignedTo.
    * dueDate.
    * created.
4. Create a new package called *com.ieti.ieti.data* and inside define your *Task* com.ieti.ieti.data object with at least the following fields:
    * id.
    * name.
    * description.
    * status [TODO, DOING, REVIEW and DONE].
    * assignedTo.
    * dueDate.
    * created.
5. Create a new package called *com.ieti.ieti.service* an inside create the following interface:

**Java:**
 ```java
     public interface TaskService
     {
         Task create( Task task );

         Task findById( String id );
         
         List<Task> all();

         void deleteById( String id );

         Task update( Task task, String id );
     }
  ```
  **Kotlin:**
  ```kotlin
      interface TaskService {

         fun create( task: Task): Task

         fun findById( String id ): Task?
         
         fun  all(): List<Task>

         fun deleteById( String id )

         fun update( Task task, String id ): Task

      }
  ```
6. Create an implementation of the TaskService using a HashMap com.ieti.ieti.data structure inside.
7. Make your com.ieti.ieti.service implementation *TaskServiceHashMap* injectable using the *@Service* annotation.
8. Implement you *TaskController* (try to avoid copy paste, use the User Microservice as reference but try doing it consciously).
9. Test ALL the endpoints of your API using PostMan or any other tool of your preference.
