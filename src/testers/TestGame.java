package testers;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.game.Board;
import backend.game.MatchModel;
import backend.piece.Piece;
import backend.piece.Warrior;
import backend.weapons.warriorweapon.ShortSword;

public class TestGame {

	private static MatchModel match;
	private static ArrayList<ArrayList<Piece>> deployPieces = new ArrayList<ArrayList<Piece>>();
	
	@BeforeClass
	public static void Initialization(){
		match = new MatchModel(10, 10, deployPieces);
		match.getPhaseMatch().setTypeToPlaying();
	}
	
	@Before
	public void putAPiece(){
		match.getBoard().getTile(1, 2).putPiece(new Warrior(1, new ShortSword(), match));
	}
	
	@Test
	public void testBoard(){
		assertFalse(match.getBoard().equals(new Board(10,10)));
	}
	
	

}
