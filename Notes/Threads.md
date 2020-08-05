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

## 2. Interrupt and Join
### [Thread.inrerrupt( )](https://www.javatpoint.com/interrupting-a-thread)
>If any thread is in sleeping or waiting state (i.e. sleep() or wait() is invoked), calling the interrupt() method on the thread, breaks out the sleeping or waiting state throwing InterruptedException. If the thread is not in the sleeping or waiting state, calling the interrupt() method performs normal behaviour and doesn't interrupt the thread but sets the interrupt flag to true. Let's first see the methods provided by the Thread class for thread interruption.
```java
public static void main(String[] args) {  
	System.out.println("Executing Main Thread");  
	Thread task = new Thread(){  
		@Override  
		public void run() {  
			try{  
				Thread.sleep(5000);  
			}catch (InterruptedException e){  
				System.out.println(e);  
				return;  
			}  
            System.out.println("task1 thread awake");  
		}  
		task.start();
		task.interrupt();
    };
}
```
### [Thread.join( )](https://www.geeksforgeeks.org/joining-threads-in-java/)
>**java.lang.Thread** class provides the join() method which allows one thread to wait until another thread completes its execution. If **t** is a Thread object whose thread is currently executing, then **t.join( )** will make sure that **t** is terminated before the next instruction is executed by the program.
```java
public static void main(String[] args) {  
	System.out.println("Executing Main Thread");  
	Thread task1 = new Thread(){  
		@Override  
		public void run() {  
			try{  
				Thread.sleep(5000);  
			}catch (InterruptedException e){  
				System.out.println(e);  
				return;  
			}  
            System.out.println("task1 thread awake");  
		}  
    };
    
    Thread task2 = new Thread(){  
		@Override  
		public void run() {  
	        try{  
	            System.out.println("Waiting for task1 to end");  
				task1.join();  
				System.out.println("task1 ended or timed out");  
			}catch(InterruptedException e){  
	            System.out.println(e);  
			}  
		}  
	};
	task1.start();
	task2.start();
}
```
