package com.capgemini.hanoi;


import org.junit.Test;
import org.junit.Assert;

public class HanoiTest {
	/**
	 * Dysk mozna klasc tylko na dysku wiekszym
	 * Gra konczy sie gdy na drugiej lub trzeciej wiezy pierwszy dysk ma dlugosc 1
	 */
	
	@Test
	public void shouldNotPutBiggerOnSmallerDisk() {
		//given
		Hanoi towers = new Hanoi();
		towers.initialize(3);
		towers.move_disk(1, 3);
		towers.move_disk(1, 3);
		//when
		int diskValue = towers.rods[2][1];
		//then
		Assert.assertEquals(0, diskValue);
	}
	
	@Test
	public void shouldEndWhenSecondTowerHasSmallestDiskOnTop() {
		//given
		Hanoi towers = new Hanoi();
		towers.initialize(3);
		towers.rods[1][0] = 1;
		//when
		boolean finished = towers.are_finished();
		//then
		Assert.assertTrue(finished);
	}
	
	@Test
	public void shouldEndWhenThirdTowerHasSmallestDiskOnTop() {
		//given
		Hanoi towers = new Hanoi();
		towers.initialize(3);
		towers.rods[2][0] = 1;
		//when
		boolean finished = towers.are_finished();
		//then
		Assert.assertTrue(finished);
	}
}
