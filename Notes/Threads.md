# Threads
>Threads allows a program to operate more efficiently by doing multiple things at the same time.
>Threads can be used to perform complicated tasks in the background without interrupting the main program.
## Defining and Starting a Thread
### Extending Thread class
```java
public class Main {  
    public static void main(String[] args) {  
	System.out.println("Executing Main Thread");  
	Task task = new Task();  
	task.start();  
}  
```
```java
public class Task extends Thread{  
	@Override  
	public void run() {  
		System.out.println("Executing Task Thread");  
	}  
}
```

### Anonymous Thread class
```java
public static void main(String[] args) {
	System.out.println("Executing Main Thread");
    new Thread(){
		@Override
        public void run() {
            System.out.println("Executing New Thread");
        }
    }.start();
}
```
