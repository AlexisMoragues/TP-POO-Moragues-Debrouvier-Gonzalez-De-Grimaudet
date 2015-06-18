package backend.game;

import java.util.ArrayList;

import backend.piece.Piece;

public class MatchModel { 	
	
	public static final int DEPLOY_AREA_SIZE  = 5;
	/**
	 * Turno actual de juego
	 */
	private int playerTurn;
	
	/**
	 * Array con las piezas que se van a deployear.
	 */
	private ArrayList<ArrayList<Piece>> deployPieces = new ArrayList<ArrayList<Piece>>();
	
	/**
	 * Array con las piezas que estan el la partida.
	 */
	private ArrayList<ArrayList<Piece>> pieces = new ArrayList<ArrayList<Piece>>();
	
	/**
	 * Tablero de la partida
	 */
	private Board board;
	
	/**
	 * Variable que guarda la estapa en la cual se encuentra el Match. Que puede ser:
	 * Deploy, Jugar y Fin.
	 */
	private PhaseMatch phaseMatch;
	
	
	/**
	 * Crea una partida
	 * @param width
	 * @param height
	 * @param pieces
	 */
	public MatchModel(int width, int height, ArrayList<ArrayList<Piece>> pieces){ 
		if(DEPLOY_AREA_SIZE > height){
			throw new IllegalArgumentException();
		}
		if(width<=0 || height<=0 || pieces == null){
			throw new IllegalArgumentException();
		}
		this.playerTurn = 1;
		setPieces(pieces);
		board = new Board(width, height);
		phaseMatch = new PhaseMatch();
	}
	
	public PhaseMatch getPhaseMatch(){
		return this.phaseMatch;
	}
	
	/**
	 * Remueve una pieza del tablero
	 * @param piece La pieza a remover
	 * @return La pieza a remover
	 */
	public Piece removePiece(Piece piece){
		Piece removedPiece = piece;
		if(piece!=null){
			piece.getPosition().putPiece(null);
		}
		return removedPiece;
	}
	/**
	 * Coloca una pieza en el tablero
	 * @param piece La pieza a poner
	 * @param tileSelected El casillero donde se pondra la pieza
	 * @return Falso si el casillero se encuentra previamente ocupado
	 * 			Verdadero si se pudo colocar la pieza
	 */
	public boolean putPiece(Piece piece, Tile tileSelected){
		if(tileSelected==null){
			throw new IllegalArgumentException();
		}
		if(tileSelected.getPiece()!=null){
			return false;
		}
		tileSelected.putPiece(piece);
		return true;
	}
	
	
	/**
	 * Obtiene la pieza en una tile determinada
	 * @param tilePiece Tile a consultar
	 * @return Pieza ubicada en la Tile pedida
	 */
	public Piece getPiece (Tile tilePiece){
		if(tilePiece == null){
			throw new IllegalArgumentException();
		}
		return tilePiece.getPiece();
	}
	
	/**
	 * Obtiene la distancia entre dos tiles
	 * @param StartingTile Casillero Inicial
	 * @param EndingTile Casillero final
	 * @return La distancia entre Casillero Inicial y Casillero final
	 */
	public int getDistance(Tile StartingTile, Tile EndingTile){
		if(StartingTile==null || EndingTile == null){
			throw new IllegalArgumentException();
		}
		int distanceX = Math.abs(StartingTile.getPositionX() - EndingTile.getPositionX());
		int distanceY = Math.abs(StartingTile.getPositionY() - EndingTile.getPositionY());
		return distanceX + distanceY;
	}
	
	public int getWidth(){
		return board.getWidth();
	}
	
	public int getHeight(){
		return board.getHeight();
	}
	
	public Tile getTile(int positionX, int positionY){
		return board.getTile(positionX, positionY);
	}
	
	public Board getBoard(){
		return board;
	}


	/**
	 * Pasa el turno.
	 */
	public void pass(){
		
		if(playerTurn==pieces.size()){
			playerTurn=1;
		}
		else{
			playerTurn=playerTurn+1;
		}
		resetPieces();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return true cuando puso todas las unidades de todos los jugadores.
	 */
	public boolean deployPiece(int x, int y){
		if(x>=getHeight()  || y>=getWidth() || x<0 || y<0){
			throw new IllegalArgumentException();
		}
		
		if(!phaseMatch.isTypeDeploying()){
			verifyDeployEnd();
			return false;
		}	
		
		Tile actualTile = getTile(x,y);
		//Si el Array DeployPieces del jugador no esta vacio
		if(getDeployPieces().get(getPlayerTurn()-1).size()!=0){
			if(validDeployTile(x,y)){
				if(actualTile!=null){
					if(actualTile.getPiece()==null){
						Piece piece = deployPieces.get(playerTurn-1).remove(deployPieces.get(playerTurn-1).size()-1);
						actualTile.putPiece(piece);
						verifyDeployEnd();
						return true;
					}
				}
			}
		}
		
		verifyDeployEnd();
		return false;
		
		
		
	}
	
	/**
	 * Verifica si se quedo un array de pieza para deployear del jugador vacio y pasa al siguiente 
	 * jugador si eso pasa. Ademas si no quedan piezas para deployear, setea la phase del match en Playing.
	 */
	private void verifyDeployEnd(){
		if(getDeployPieces().get(getPlayerTurn()-1).size()==0){
			pass();
			this.getPhaseMatch().setTypeToPlaying();
			for(ArrayList<Piece> playerPieces: deployPieces){
				if(playerPieces.size()!=0){
					this.getPhaseMatch().setTypeToDeploying();
				}
			}
		}
	}
		
	/**
	 * Setea en false el estado de attacked y moved de todas las piezas del tablero
	 */
	public void resetPieces(){
		if(pieces==null){
			throw new NullPointerException();
		}
		for(ArrayList<Piece> piecePlayers: pieces){
			for(Piece piece: piecePlayers){
				piece.reset();
			}
		}
	}
	
	public int getPlayerTurn(){
		return this.playerTurn;
	}
	
	/**
	 * 
	 * @param selectedTile
	 * @return true si la pieza es del jugador cuyo turno
	 * es el actual
	 */
	public boolean sameTeamPiece(Piece piece){
		if(piece!=null){
			if(piece.getTeam()==this.playerTurn){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Completa los arrays de deploy y pieeces con las piezas seleccionadas del jugador.
	 * @param piecesToSet
	 */
	private void setPieces(ArrayList<ArrayList<Piece>> piecesToSet){
		if(piecesToSet==null){
			throw new IllegalArgumentException();
		}
		for(int i=0; i<piecesToSet.size() ; i++){
			deployPieces.add(new ArrayList<Piece>());
			pieces.add(new ArrayList<Piece>());
			for(Piece piece:piecesToSet.get(i)){
				piece.setMatch(this);
				deployPieces.get(i).add(piece);
				pieces.get(i).add(piece);
			}
		}
	}
	
	public ArrayList<ArrayList<Piece>> getDeployPieces(){
		return this.deployPieces;
	}
	
	public ArrayList<ArrayList<Piece>> getPieces(){
		return this.pieces;
	}
	
	public Piece getLastPiece(){
		return this.deployPieces.get(playerTurn-1).get(deployPieces.get(playerTurn-1).size()-1);
	}
	
	/**
	 * Devuelve si la Tile en la position x,y esta en el area del tablero en la cual
	 * le corresponde deployear al jugador.
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean validDeployTile(int x, int y) {
		int height= this.getBoard().getHeight();
		if(playerTurn==1){
			if(x>=0 && x<Math.floor(height/DEPLOY_AREA_SIZE)){//La altura es x, porque x representa la coordenada i, osea la filas.
				return true;
			}
		}
		else{ //Todos menos el player1. Hay que ver que hacemos si mas jugadores? Deberia depender del game?
			if(x<=height-1 && x>(height-Math.floor(height/DEPLOY_AREA_SIZE))-1){//-1 porque x empieza en 0 y va hasta height-1
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return Numero de jugador ganador (0 si empate y -1 si nadie gano)
	 */
	public int whoWon(){
		int playerWhoWon=0;
		ArrayList<Piece> playerPiece;
		for(int i=0; i<pieces.size(); i++){
			playerPiece=pieces.get(i);
			if(isAlive((ArrayList<Piece>) playerPiece)){
				if(playerWhoWon==0){
					playerWhoWon=i+1;
				}
				else{
					playerWhoWon=-1;
				}
			}
		}
		if(playerWhoWon!= -1){
			phaseMatch.setTypeToEnd();
		}
		return playerWhoWon;
	}
	
	private boolean isAlive(ArrayList<Piece> playerPieces) {
		for (Piece piece:playerPieces){
			if(piece.getHealth()>0){
				return true;
			}
		}
		return false;
	}

	
	public String toString(){
		String string="";
		for(int i = 0; i < this.getHeight(); i++){
			for(int j = 0; j < this.getWidth(); j++){
				string+="(" + this.getTile(i, j).getPositionX() + ",";
				string+= this.getTile(i, j).getPositionY() + ")";
				if(this.getPiece(this.getTile(i, j))!=null){
					string+=this.getPiece(this.getTile(i, j)).getName();
				}
				else{
					string+="   ";
				}
			}
			string+= "\r\n";
		}
		
		return string;
	}

	public ArrayList<Tile> getAreaDeployable() {
		int height= this.getBoard().getHeight();
		ArrayList<Tile> tilesDeployables = new ArrayList<Tile>();
		for(int i=0; i<getWidth(); i++){
			if(playerTurn==1){
				for(int j=0; j<Math.floor(height/5);j++){
					
					tilesDeployables.add(getTile(j, i));
				}
			}
			else{ 
				for(int j=height-1; j>(height-Math.floor(height/5))-1;j--){
					tilesDeployables.add(getTile(j, i));
				}
			}		
		}
		return tilesDeployables;
	}

}

