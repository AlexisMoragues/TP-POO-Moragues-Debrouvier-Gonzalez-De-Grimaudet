package backend;

import java.util.ArrayList;

import backend.piece.Piece;

public class SelectScreen{

	private int nOfPlayers;
	private ArrayList<Player> players = new ArrayList<Player>();
	private int playerTurn;
	private ArrayList<ArrayList<Piece>> pieces = new ArrayList<ArrayList<Piece>>();
	
	public SelectScreen(int gold){
		this.nOfPlayers=2;
		this.players = new ArrayList();
		this.playerTurn=1;
		
		for(int i=0; i<nOfPlayers; i++){
			players.add(new Player(i+1, gold));
			pieces.add(new ArrayList<Piece>());
		}
		
	}

	public boolean buyPiece (Piece newPiece){
		
		if(players.get(playerTurn-1).getResources()>=newPiece.getCost()){ //max units
			players.get(playerTurn-1).useResources(newPiece.getCost()); //Recursos
			pieces.get(playerTurn-1).add(newPiece);
			return true;
		}
		return false;
	}
	public int getPlayerTurn(){
		return this.playerTurn;
	}
	public void passPlayerTurn(){
		this.playerTurn=playerTurn+1;
	}
	public int nOfPlayers(){
		return this.players.size();
	}
	public Player getPlayerPlaying(){
		return this.players.get(this.playerTurn-1);
	}
	public ArrayList<ArrayList<Piece>> getPlayerPieces(){
		return this.pieces;
	}
	public int getNOfPlayers(){
		return this.nOfPlayers;
	}

	
	/**
	 * Si el jugador que esta jugando gasto todos los recursos. De no ser el ultimo jugador
	 * se pasa al siguiente jugador. En caso contrario, se devuelve true y se espera que
	 * el controlador pase de la SelectScreen al MatchModel.
	 * @return
	 */
	public boolean done() {
		if(getPlayerPlaying().getResources()==0){//Si se quedo sin recursos
			if(getPlayerTurn()<nOfPlayers()){ //Si todavia quedan jugadores
				passPlayerTurn();
			}
			else{  //Si es el ultimo turno de seleccion de unidades y se gastaron todos los recursos
				return true;
			}
		}
		
		return false;
		
	}
	
}

