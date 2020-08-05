# Threads
>Threads allows a program to operate more efficiently by doing multiple things at the same time.
>Threads can be used to perform complicated tasks in the background without interrupting the main program.
## 1. Defining and Starting a Thread
### Extending Thread class
```java
public class Task extends Thread{  
	@Override  
	public void run() {  
		System.out.println("Executing Task Thread");  
	}  
}
```
```java
public class Main {  
    public static void main(String[] args) {  
	System.out.println("Executing Main Thread");  
	Task task = new Task();  
	task.start();  
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
### Implementing Runnable Interface
```java
public class Task implements Runnable{  
    @Override  
	public void run() {  
		System.out.println("Executing Task Thread");  
	}  
}
```
```java
public static void main(String[] args) {  
	System.out.println("Executing Main Thread");  
	Thread task = new Thread(new Task());  
	task.start();  
}
```
