package org.cuatrovientos.KillEnemies;

public class Enemy implements Character {

	@Override
	public boolean isEnemy() {
		return true;
	}
	
	public void kill() {
		System.out.println("Ahhhgg, me mataste, bastardo!");
	}

}
