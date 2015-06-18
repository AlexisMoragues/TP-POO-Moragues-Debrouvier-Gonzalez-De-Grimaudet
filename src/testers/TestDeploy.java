package testers;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import backend.game.MatchModel;
import backend.piece.Piece;
import backend.piece.Warrior;
import backend.weapons.warriorweapon.ShortSword;

public class TestDeploy extends JUnitCore{

	private  MatchModel match;
	private ArrayList<ArrayList<Piece>> deployPieces = new ArrayList<ArrayList<Piece>>();
	private  ArrayList<Piece> pieces;
	
	@Before
	public void Initialization() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		pieces= new ArrayList<Piece>();
		pieces.add(new Warrior(1, new ShortSword(), match));
		pieces.add(new Warrior(1, new ShortSword(), match));
		pieces.add(new Warrior(1, new ShortSword(), match));
		deployPieces.add(pieces);
		match = new MatchModel(10,10,deployPieces);
		match.getPhaseMatch().setTypeToDeploying();
		

	}
	
	@Test
	public void deployAll(){
		assertTrue(match.deployPiece(0, 0));
		assertTrue(match.deployPiece(0, 1));
		assertTrue(match.deployPiece(0, 2));
	}
	
	@Test
	public void deployOnTopOfPiece(){
		assertTrue(match.deployPiece(0, 0));
		assertTrue(match.deployPiece(0, 1));
		assertFalse(match.deployPiece(0, 1));
		assertTrue(match.deployPiece(0, 2));
	}
	
	@Test
	public void passAfterDeploy(){
		assertTrue(match.deployPiece(0, 0));
		assertTrue(match.deployPiece(0, 1));
		assertTrue(match.deployPiece(0, 2));
		match.pass();
		assertTrue(match.getPlayerTurn()==1);
	}
	
	@Test
	public void passBeforeDeploy(){
		assertTrue(match.deployPiece(0, 0));
		assertTrue(match.deployPiece(0, 1));
		match.pass();
		assertFalse(match.getPlayerTurn()==2);
		assertTrue(match.deployPiece(0, 2));
		match.pass();
		assertTrue(match.getPlayerTurn()==1);
	}
}

