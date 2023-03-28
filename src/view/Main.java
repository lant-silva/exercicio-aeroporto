package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAeroporto;

public class Main {
	
	static Semaphore norte;
	static Semaphore sul;
	
	public static void main(String[] args) {
		
		norte = new Semaphore(1);
		sul = new Semaphore(1);
		
		for(int i=1;i<=12;i++) {
			
			Thread aviao = new ThreadAeroporto(i, norte, sul);
			
			aviao.start();
			
		}
		
	}
	
	
}
