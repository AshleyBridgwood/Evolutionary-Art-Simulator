package test;

import java.util.Random;

public class testrng {
	
	static Random rng = new Random();
	
	 public static void main(String args[]){
		 
		 rng.setSeed(1);
		 System.out.println(rng.nextInt(5));
		 System.out.println(rng.nextInt(5));
		 System.out.println(rng.nextInt(5));
		 rng.setSeed(1);
		 System.out.println(rng.nextInt(5));
		 System.out.println(rng.nextInt(5));
		 System.out.println(rng.nextInt(5));
		 rng.setSeed(1);
		 System.out.println(rng.nextInt(5));
		 System.out.println(rng.nextInt(5));
		 System.out.println(rng.nextInt(5));
		 rng.setSeed(1);
		 System.out.println(rng.nextInt(5));
		 System.out.println(rng.nextInt(5));
		 System.out.println(rng.nextInt(5));
	 }
	
}
