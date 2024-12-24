package package2;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class gitThreads {
	
	
	 public static void main(String[] args) throws InterruptedException {
		 // THREADS CLASS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		Thread threadtask1=new ThreadsTask("Threadtask 1");
		Thread threadtask2=new ThreadsTask("Threadtask 1");

		 
		threadtask1.start();
		threadtask2.start();
		 
		 // RUNNABLE INTERFACE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	        // Create Runnable tasks
		 RunnableTask task1 = new RunnableTask("Runnable Task 1");
		 RunnableTask task2 = new RunnableTask("Runnable Task 2");

	        // Create Thread objects and pass Runnable tasks
	        Thread thread1 = new Thread(task1);
	        Thread thread2 = new Thread(task2);

	        // Start the threads
	        thread1.start();
	        thread2.start();
	        
	     // EXECUTOR SERVICE WITH RUNNABLE TASKS
	        ExecutorService executorServiceRunnable = Executors.newFixedThreadPool(2);

	        executorServiceRunnable.submit(new RunnableTask("Executor Task 1"));
	        executorServiceRunnable.submit(new RunnableTask("Executor Task 2"));
	        
	        
	        executorServiceRunnable.shutdown();

	        // EXECUTOR SERVICE WITH CALLABLE TASKS
	        ExecutorService callableExecutorService = Executors.newFixedThreadPool(2);

	        // Create Callable tasks
	        CallableTask callableTask1 = new CallableTask("Callable Task 1");
	        CallableTask callableTask2 = new CallableTask("Callable Task 2");

	        // Submit Callable tasks to executor
	        Future<String> future1 = callableExecutorService.submit(callableTask1);
	        Future<String> future2 = callableExecutorService.submit(callableTask2);

	        try {
	            // Retrieve results from Callable tasks
	            System.out.println("Result from " + callableTask1.getTaskName() + ": " + future1.get());
	            System.out.println("Result from " + callableTask2.getTaskName() + ": " + future2.get());
	        } catch ( ExecutionException e) {
	            System.out.println("Exception occurred: " + e.getMessage());
	        } finally {
	            // Shutdown the callable executor
	            callableExecutorService.shutdown();
	        }

	        // Shutdown the other executor
	        
	        // Example of CompletableFuture
	        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
	            for (int i = 1; i <= 5; i++) {
	                System.out.println("CompletableFuture1 Task - Count: " + i);
	                try {
	                    Thread.sleep(500); // Pause for 500 milliseconds
	                } catch (InterruptedException e) {
	                    System.out.println("CompletableFuture Task interrupted");
	                }
	            }
	            System.out.println("CompletableFuture Task completed.");
	        });

	        // Wait for CompletableFuture to complete
	        completableFuture1.join(); // This will block until the CompletableFuture is complete

	        // Another CompletableFuture example that returns a result
	        CompletableFuture<String> completableFutureResult = CompletableFuture.supplyAsync(() -> {
	            StringBuilder result = new StringBuilder();
	            for (int i = 1; i <= 5; i++) {
	                result.append("CompletableFuture Result - Count: ").append(i).append("\n");
	                try {
	                    Thread.sleep(500); // Pause for 500 milliseconds
	                } catch (InterruptedException e) {
	                    result.append("CompletableFuture Result interrupted\n");
	                }
	            }
	            return result.toString();
	        });

	        // Process the result when it's ready
	        completableFutureResult.thenAccept(result -> {
	            System.out.println("Result from CompletableFuture:\n" + result);
	        });

	        // Wait for the CompletableFuture to complete
	        completableFutureResult.join(); // This will block until the CompletableFuture is complete

	    
	    }
	 

}

class RunnableTask implements Runnable {
    private String taskName;

    public RunnableTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        // Code to be executed by each thread
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Count: " + i);
            try {
                Thread.sleep(500); // Pause for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted");
            }
        }
        System.out.println(taskName + " completed.");
    }
}

class ThreadsTask extends Thread {
    private String taskName;

    public ThreadsTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        // Code to be executed by each thread
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Count: " + i);
            try {
                Thread.sleep(500); // Pause for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted");
            }
        }
        System.out.println(taskName + " completed.");
    }
}

class CallableTask implements Callable<String> {
    private String taskName;

    public CallableTask(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            result.append(taskName).append(" - Count: ").append(i).append("\n");
            try {
                Thread.sleep(500); // Pause for 500 milliseconds
            } catch (InterruptedException e) {
                result.append(taskName).append(" interrupted\n");
            }
        }
        result.append(taskName).append(" completed.\n");
        return result.toString();//returns this
    }
}


