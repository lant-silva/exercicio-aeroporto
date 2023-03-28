package controller;

import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread{
	int i;
	Semaphore norte;
	Semaphore sul;
	int ir=0;
	
	public ThreadAeroporto(int i, Semaphore norte, Semaphore sul) {
		this.i = i;
		this.norte = norte;
		this.sul = sul;
	}
	
	@Override
	public void run() {
		iniciarSistema();
	}
	
	public void iniciarSistema() {
		manobra();
		taxiar();
	}
	
	public void manobra() {
		int tempo = (int) ((Math.random()*4)+4);
		
		System.out.println("Avião "+i+" iniciou manobra");
		try {
			sleep(tempo*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Avião "+i+" terminou manobra");
	}
	
	public void taxiar() {
		
		int tempo = (int) ((Math.random()*6)+5);
		
		System.out.println("Avião "+i+" iniciou taxi");
		try {
			sleep(tempo*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Avião "+i+" terminou taxi");
		
		ir =(int) (Math.random()*2)+1;
		if (ir == 1) {
			try {
				norte.acquire();
				System.out.println("Avião "+i+" entrou na pista norte");
				decolagem();
				afastamento();
				
			} catch (Exception e) {
				
			}	finally {
				norte.release();
			}
		}else {
			try {
				sul.acquire();
				System.out.println("Avião "+i+" entrou na pista sul");
				decolagem();
				afastamento();
				
			} catch (Exception e) {
				
			}	finally {
				sul.release();
			}
		}
	}
	public void decolagem() {
		int tempo = (int) ((Math.random()*4)+1);
		
		System.out.println("Avião "+i+" iniciou decolagem");
		try {
			sleep(tempo*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Avião "+i+" terminou decolagem");	
	}
	
	public void afastamento() {
		
		int tempo = (int) ((Math.random()*6)+3);
		
		System.out.println("Avião "+i+" iniciou afastamento");
		try {
			sleep(tempo*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Avião "+i+" terminou afastamento");	
	}
}
