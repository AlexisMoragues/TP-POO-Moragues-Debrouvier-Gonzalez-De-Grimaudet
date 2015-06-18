package backend.game;

import backend.piece.Piece;

/**
 * Representa a los casilleros del tablero de juego 
 */
public class Tile {
	
	private int positionX;
	private int positionY;
	private Piece piece;
	
	/**
	 * Crea una Tile 
	 * @param positionX Coordenada X
	 * @param positionY Coordenada Y
	 */
	public Tile(int positionX, int positionY){
		if (positionX <0 || positionY<0){
			throw new IllegalArgumentException("");
		}
		this.positionX=positionX;
		this.positionY=positionY;
		this.piece=null;
	}
	
	public int getPositionX(){
		return this.positionX;
	}
	
	public int getPositionY(){
		return this.positionY;
	}
	
	public Piece getPiece(){
		return this.piece;
	}
	
	private void setPiece(Piece piece){
		this.piece=piece;
	}
	
	/**
	 * @return coordenadas del casillero (arranca en (0,0))
	 */
	public String toString(){
		StringBuffer string = new StringBuffer();
		string.append("(" + positionX + ";" + positionY + ")");
		if(this.piece!=null){
			string.append(this.piece);
		}
		return string.toString();
	}
	
	/**
	 * Pone una pieza en el casillero
	 * @param piece
	 */
	public void putPiece(Piece piece){//No verifica que pise pieza. Bien o mal? Quizas trabajar con remove y putPiece?
		if(getPiece()!=piece){
			setPiece(piece);
			if(piece!=null){
				piece.setPosition(this);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((piece == null) ? 0 : piece.hashCode());
		result = prime * result + positionX;
		result = prime * result + positionY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		if (piece == null) {
			if (other.piece != null)
				return false;
		} else if (!piece.equals(other.piece))
			return false;
		if (positionX != other.positionX)
			return false;
		if (positionY != other.positionY)
			return false;
		return true;
	}
	


}
