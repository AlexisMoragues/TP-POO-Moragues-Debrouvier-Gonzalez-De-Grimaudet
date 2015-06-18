package testers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.game.MatchModel;
import backend.piece.Mage;
import backend.piece.Piece;
import backend.piece.Ranger;
import backend.piece.Warrior;
import backend.weapons.mageweapon.ArcaneStaff;
import backend.weapons.mageweapon.IceStaff;
import backend.weapons.rangerweapon.Crossbow;
import backend.weapons.warriorweapon.Zweihander;

public class ConeAoeSkills {

	
	private static MatchModel match;
	private static ArrayList<ArrayList<Piece>> deployPieces = new ArrayList<ArrayList<Piece>>();

		@BeforeClass
		public static void Initialization(){
			match = new MatchModel(10,10,deployPieces);
			match.getPhaseMatch().setTypeToPlaying();
			
		}
		
		@Before
		public void putAPiece(){
			match.getTile(4, 4).putPiece(new Warrior(1, new Zweihander(), match));
			match.getTile(7, 3).putPiece(new Mage(2, new ArcaneStaff(), match));
			match.getTile(6, 3).putPiece(new Mage(2, new IceStaff(), match));
			match.getTile(5, 2).putPiece(new Ranger(3, new Crossbow(), match));
			match.getTile(4, 1).putPiece(new Ranger(3, new Crossbow(), match));
			match.getTile(4, 0).putPiece(new Ranger(3, new Crossbow(), match));
			match.getTile(4, 4).getPiece().setAttacked(false);
			match.getTile(7, 3).getPiece().setAttacked(false);
		}
		
		@Test
		public void invertedCone(){
			assertTrue(match.getTile(4,4).getPiece().tryToSkill(match.getTile(4, 4), match.getTile(4,3), 0));
			assertFalse(match.getTile(6,3).getPiece().getHealth()==match.getTile(6,3).getPiece().getMaxHealth());
			assertFalse(match.getTile(5,2).getPiece().getHealth()==match.getTile(5,2).getPiece().getMaxHealth());
			assertFalse(match.getTile(4,1).getPiece().getHealth()==match.getTile(4,1).getPiece().getMaxHealth());
		}
		
		@Test
		public void normalCone(){
			assertTrue(match.getTile(7, 3).getPiece().tryToSkill(match.getTile(7, 3), match.getTile(6, 3), 2));
			assertTrue(match.getTile(6, 3).getPiece()==null);
			assertFalse(match.getTile(5,2).getPiece().getHealth()==match.getTile(5,2).getPiece().getMaxHealth());
			assertFalse(match.getTile(4,1).getPiece().getHealth()==match.getTile(4,1).getPiece().getMaxHealth());
		}
}
