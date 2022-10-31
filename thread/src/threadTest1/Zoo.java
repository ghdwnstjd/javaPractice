package threadTest1;

public class Zoo {
	   public static void main(String[] args) {
		   
	      String[] sounds = {"어흥", "야옹", "음메멈멍"};
	      Animal[] animals = new Animal[sounds.length];
	      Thread[] threads = new Thread[sounds.length];
	      
	      for (int i = 0; i < threads.length; i++) {
	         animals[i] = new Animal();
	         threads[i] = new Thread(animals[i], sounds[i]);
	      }
	      
	      for (int i = 0; i < threads.length; i++) {
	         threads[i].start();
	         if(i != 0) {
	            try {threads[i].join();} catch (InterruptedException e) {;}
	         }
	      }
	   }
	}
