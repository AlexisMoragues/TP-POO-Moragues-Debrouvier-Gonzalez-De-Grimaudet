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

public class TestMove extends JUnitCore{
	
	private static MatchModel match;
	private static ArrayList<ArrayList<Piece>> deployPieces = new ArrayList<ArrayList<Piece>>();

		@Before
		public void Initialization(){
			match = new MatchModel(10,10,deployPieces);
			match.getPhaseMatch().setTypeToPlaying();
			
		}
	
	@Before
	public void putAPiece(){
		match.getTile(1, 2).putPiece(new Warrior(1, new ShortSword(), match));
		match.getTile(4, 2).putPiece(new Mage(2, new IceStaff(), match));
		match.getTile(1, 5).putPiece(new Ranger(1, new Crossbow(), match));
		match.getTile(1, 2).getPiece().setMoved(false);
		match.getTile(1, 5).getPiece().setMoved(false);
		match.getTile(4, 2).getPiece().setMoved(false);
		match.getTile(4, 2).getPiece().setAttacked(false);
	}
	
	@Test
	public void usedSpace(){
		assertFalse(match.getTile(1, 2).getPiece().move(match.getTile(1,5)));
		assertFalse(match.getTile(1, 2).getPiece().getMoved());
		assertTrue(match.getTile(1, 2).getPiece().move(match.getTile(1,4)));		
	}

	@Test
	public void checkMoved(){
		assertFalse(match.getTile(1, 2).getPiece().move(match.getTile(1,5)));
		assertFalse(match.getTile(1, 2).getPiece().getMoved());
		assertTrue(match.getTile(1, 2).getPiece().move(match.getTile(1,4)));
		assertTrue(match.getTile(1, 4).getPiece().getMoved());
		assertFalse(match.getTile(1, 4).getPiece().move(match.getTile(1,3)));
	}

	@Test
	public void checkMovedAfterAttack(){

		assertTrue(match.getTile(4, 2).getPiece().attack(match.getTile(1, 2)));
		assertTrue(match.getTile(4, 2).getPiece().getMoved());
	}

	@Test
	public void checkMovingOutOfRange(){
		assertTrue(match.getTile(1, 2).getPiece().move(match.getTile(1,4)));
		assertTrue(match.getTile(1, 4).getPiece().getMoved());
		match.getTile(1, 4).getPiece().setMoved(false);
		assertFalse(match.getTile(1, 4).getPiece().move(match.getTile(7,7)));
		assertFalse(match.getTile(1, 4).getPiece().getMoved());
	}
	
}
