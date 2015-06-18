package testers;

import static org.junit.Assert.*;

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
import backend.weapons.mageweapon.FireStaff;
import backend.weapons.rangerweapon.Crossbow;
import backend.weapons.warriorweapon.ShortSword;

public class TestLineAndSquare extends JUnitCore{
	
	private static MatchModel match;
	private static ArrayList<ArrayList<Piece>> deployPieces = new ArrayList<ArrayList<Piece>>();

		@BeforeClass
		public static void Initialization(){
			match = new MatchModel(10,10,deployPieces);
			match.getPhaseMatch().setTypeToPlaying();
			
		}
		
		@Before
		public void putAPiece(){
			match.getTile(1, 2).putPiece(new Warrior(1, new ShortSword(), match));
			match.getTile(4, 2).putPiece(new Mage(2, new FireStaff(), match));
			match.getTile(2, 2).putPiece(new Ranger(2, new Crossbow(), match));
			match.getTile(1, 2).getPiece().setMoved(false);
			match.getTile(2, 2).getPiece().setMoved(false);
			match.getTile(4, 2).getPiece().setMoved(false);
			match.getTile(1, 2).getPiece().setAttacked(false);
			match.getTile(2, 2).getPiece().setAttacked(false);
			match.getTile(4, 2).getPiece().setAttacked(false);
		}
	@Test
	public void testWildFire() {
		assertTrue(match.getTile(4, 2).getPiece().tryToSkill(match.getTile(4, 2), match.getTile(3, 2), 1));
		assertFalse(match.getTile(1, 2).getPiece().getHealth()==match.getTile(1, 2).getPiece().getMaxHealth());
		assertFalse(match.getTile(2, 2).getPiece().getHealth()==match.getTile(1, 2).getPiece().getMaxHealth());
	}
	
	@Test
	public void testFireBomb(){
		assertTrue(match.getTile(4, 2).getPiece().tryToSkill(match.getTile(4, 2), match.getTile(2, 2), 0));
		assertFalse(match.getTile(1, 2).getPiece().getHealth()==match.getTile(1, 2).getPiece().getMaxHealth());
		assertFalse(match.getTile(2, 2).getPiece().getHealth()==match.getTile(1, 2).getPiece().getMaxHealth());
	}

	@Test
	public void testCleanse(){
		assertTrue(match.getTile(4, 2).getPiece().tryToSkill(match.getTile(4, 2), match.getTile(2, 2), 2));
		assertFalse(match.getTile(2, 2).getPiece().getHealth()==match.getTile(1, 2).getPiece().getMaxHealth());
	}
}
