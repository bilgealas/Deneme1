package omdb;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public abstract class Test {

	public static void main(String[] args) throws InterruptedException {
	
		ExecutorService executor = Executors.newFixedThreadPool(5);

        //for (int i = 0; i < 20; i++) {
           Thread thread1 = new Thread(new ExculatorServices("Forrest Gump" , "Drama ,Romance"));
           executor.execute(thread1);
           
           Thread thread2 = new Thread(new ExculatorServices("Seven Pounds" , "Drama"));
           executor.execute(thread2);
           
          // thread1.start();        
        //}
        
        
		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);
		System.out.println("---------");
        System.out.println("Bitti");
	}

}