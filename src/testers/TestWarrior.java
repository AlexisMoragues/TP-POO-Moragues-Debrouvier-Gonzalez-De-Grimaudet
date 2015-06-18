package testers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import backend.Constants;
import backend.game.MatchModel;
import backend.piece.Piece;
import backend.piece.Warrior;
import backend.weapons.warriorweapon.ShortSword;



public class TestWarrior implements Constants {

	private  MatchModel match;
	private Warrior DiegoWarrior;
	private static ArrayList<ArrayList<Piece>> deployPieces = new ArrayList<ArrayList<Piece>>();
	
	
	
	
	@Before
	public void initialize(){
		
		match = new MatchModel(10,10,deployPieces);
		match.getPhaseMatch().setTypeToPlaying();
		DiegoWarrior=new Warrior (1, new ShortSword(), match);
	}
	
	@Test
	public void testWarriorHealth() {
		assertEquals(WARRIOR_HEALTH, DiegoWarrior.getHealth());
		
	}
	@Test
	public void testWarriorMAxHealth() {
	
		assertEquals(WARRIOR_HEALTH, DiegoWarrior.getMaxHealth());
		
	}
	@Test
	public void testWarriorDamage() {
	
		assertEquals(25, DiegoWarrior.getDamage());
		
	}
	@Test
	public void testWarriorMovement() {
		
		assertEquals(WARRIOR_MOVEMENT,DiegoWarrior.getMovement());
		
	}
	@Test
	public void testWarriorRange() {
		
		assertEquals(1, DiegoWarrior.getRange());
	}
	@Test
	public void testWarriorTeam() {
		
		assertEquals(1, DiegoWarrior.getTeam());
	}
	
	
	//Error porque "weapon" no es la misma instancia de ShorSword que la que tiene Diego. Quizas cambiar el equals??"
	@Test
	public void testWarriorWeapon() {
		ShortSword weapon = new ShortSword();
		
		assertEquals(weapon, DiegoWarrior.getWeapon());
	}


}
