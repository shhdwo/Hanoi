package com.capgemini.hanoi;

import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		
		Play launch = new Play();
		launch.game();
	}
	
	//metoda startowa
	public void game() {
		Hanoi towers = new Hanoi();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Witaj w wiezach Hanoi! Celem gry jest przeniesienie wszystkich elementow z jednej wiezy na inna!\nProsze wybierz liczbe elementow:");
		
		try {
			int n = in.nextInt();
			towers.initialize(n);
			playIt(in, towers);
		}
		catch (Exception e) {
			System.out.println("Podano niepoprawna wartosc");
		}
		finally {
			in.close();
		}
	}
		
		
	//glowna petla w trakcie rozgrywki
	public void playIt(Scanner in, Hanoi towers) {
		do {
			towers.show_rods();
		
			System.out.println("Z ktorej wiezy chcesz zabrac element? (1,2,3)");
			int a = in.nextInt();
			
			System.out.println("Na ktora wieze chcesz go przeniesc? (1,2,3)");
			int b = in.nextInt();
			
			for (int i = 0; i < 50; ++i) System.out.println(); //czyszczenie konsoli
			
			towers.move_disk(a,b);
		
		} while (!towers.are_finished());
		
		System.out.println("Gratulacje! Koniec gry!");
	}

}
