package com.capgemini.hanoi;

public class Hanoi {
	
	//tablica przechowująca aktualny stan trzech slupkow
	int[][] rods = new int[0][0];
	
	//inicjalizacja slupkow, n jako liczba krazkow
	public int[][] initialize(int n) {

		if (n < 2) {
			System.out.println("Aby rozpoczac gre potrzebne beda przynajmniej 2 krazki!");
			throw new IllegalArgumentException();
		}
		else {
			rods = new int[3][n];
			
			for (int i = 0; i < n; i++) {
				rods[0][i] = i + 1;
			}
			return rods;
		}
	}
	
	//wyswietlanie w konsoli stanu slupkow
	public void show_rods() {
		
		System.out.printf("Aktualny stan slupkow: \n %20s %20s %20s \n", "Pierwszy:", "Drugi:", "Trzeci:");
		
		for (int j = 0; j < rods[0].length; j++) {
			for (int i = 0; i < 3; i++) System.out.printf("| %20d |", rods[i][j]);
			System.out.println("\n");
		}

	}
	
	//przenoszenie pojedynczego krazka ze slupka "a" na slupek "b"
	public void move_disk(int a, int b) {
		if (a == b || a < 1 || a > 3 || b < 1 || b > 3) 
			System.out.println("Musisz wybrac dwa rozne slupki sposrod 1, 2 i 3!");
		else {
			int le = rods[0].length; 
			if (rods[a-1][le-1] == 0) {
				System.out.println("Na " + a + ". slupku nie ma krazkow do przeniesienia!");
			}
			else {
				int disk_value = 0;
				int i = 0;
				do { 
					if (rods[a-1][i] != 0) {
						disk_value = rods[a-1][i]; //zapisanie wartosci najwyzej polozonego krazka ze slupka "a"
						rods[a-1][i] = 0; //usuniecie wartosci krazka z tablicy slupkow
						break;
					}
					else i++;
				} while (true);
				
				for (int j = le-1; j >= 0; j--) {
					if (rods[b-1][j] == 0) {
						if (rods [b-1][le-1] == 0 || rods[b-1][j+1] > disk_value) { //spr czy na docelowym slupku lezy krazek o wiekszej wartosci niz przenoszony
							rods[b-1][j] = disk_value;
						}
						else {
							System.out.println("Niedozwolona operacja!");
							rods[a-1][i] = disk_value;
						}
						break;
					}
				}
			}
		}
	} 
	
	public boolean are_finished() {
		if (rods[2][0] == 1 || rods[1][0] == 1) return true; //warunek zakonczenia gry
		else return false;
	}

}
