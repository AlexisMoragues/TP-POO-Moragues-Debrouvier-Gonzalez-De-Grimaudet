package testers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import backend.game.MatchModel;
import backend.piece.Mage;
import backend.piece.Piece;
import backend.piece.Ranger;
import backend.piece.Warrior;
import backend.weapons.mageweapon.IceStaff;
import backend.weapons.rangerweapon.Crossbow;
import backend.weapons.warriorweapon.ShortSword;

public class TestAttack extends JUnitCore{
	
	private static MatchModel match;
	private static ArrayList<ArrayList<Piece>> deployPieces = new ArrayList<ArrayList<Piece>>();

	
		@Before
		public void Initialization(){
			match = new MatchModel(10,10,deployPieces);
			Warrior warrior = new Warrior(1, new ShortSword(), match);
			Mage mage = new Mage(2, new IceStaff(), match);
			Ranger ranger = new Ranger(2, new Crossbow(), match);
			match.getTile(1, 2).putPiece(warrior);
			match.getTile(4, 2).putPiece(mage);
			match.getTile(1, 5).putPiece(ranger);
			match.getPhaseMatch().setTypeToPlaying();
			
		}
		
		@Before
		public void putAPiece(){
		
			match.getTile(1, 2).getPiece().setMoved(false);
			match.getTile(1, 5).getPiece().setMoved(false);
			match.getTile(4, 2).getPiece().setMoved(false);
			match.getTile(1, 2).getPiece().setAttacked(false);
			match.getTile(1, 5).getPiece().setAttacked(false);
			match.getTile(4, 2).getPiece().setAttacked(false);
		}
		
	@Test
	public void testAttack() {
		match.getTile(1, 2).getPiece().move(match.getTile(1,4));
		assertTrue(match.getTile(1, 4).getPiece().attack(match.getTile(1, 5)));
		match.getTile(1, 4).getPiece().setAttacked(false);
		match.getTile(1, 4).getPiece().attack(match.getTile(1, 5));
		match.getTile(1, 4).getPiece().setAttacked(false);
		match.getTile(1, 4).getPiece().attack(match.getTile(1, 5));
		match.getTile(1, 4).getPiece().setAttacked(false);
		assertFalse(match.getTile(1, 4).getPiece().attack(match.getTile(1, 5)));
		match.getTile(1, 4).getPiece().setAttacked(false);
		assertFalse(match.getTile(1, 4).getPiece().attack(match.getTile(1, 5)));
	}
	
	@Test
	public void testAttackRange(){
		assertFalse(match.getTile(1, 2).getPiece().attack(match.getTile(1, 5)));
		assertTrue(match.getTile(1, 5).getPiece().attack(match.getTile(1, 2)));
		assertFalse(match.getTile(1, 5).getPiece().attack(match.getTile(4, 2)));
	}
	
	@Test
	public void friendlyFire(){
		match.getTile(1, 3).putPiece(new Warrior(1, new ShortSword(), match));
		assertFalse(match.getTile(1, 2).getPiece().attack(match.getTile(1, 3)));
		assertFalse(match.getTile(1, 2).getPiece().attack(match.getTile(1, 2)));
	}
	
	@Test
	public void testSetAttacked(){
		assertFalse(match.getTile(1, 2).getPiece().attack(match.getTile(1, 3)));
		assertFalse(match.getTile(1, 2).getPiece().getAttacked());
		match.getTile(1, 2).getPiece().move(match.getTile(1,4));
		assertTrue(match.getTile(1, 4).getPiece().attack(match.getTile(1, 5)));
		assertTrue(match.getTile(1, 4).getPiece().getAttacked());

	}

}