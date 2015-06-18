package backend.game;

import java.util.Arrays;

/**
 * Clase que representa el tablero de juego donde se ubicaran las piezas
 */
public class Board {

	private int width;
	private int height;
	private Tile[][] board;
	
	/**
	 * Crea el tablero de forma iterativa
	 * @param width Ancho del Tablero
	 * @param height Altura del Tablero
	 */
	public Board(int width, int height){
		if(width<=0 || height<=0){
			throw new IllegalArgumentException();
		}
		
		this.width = width;
		this.height = height;
		
		board =  new Tile[height][width];
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				board[i][j]=new Tile(i,j);
				
			}
		}
		
	}

	public int getHeight(){
		return this.height;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public Tile[][] getBoard(){
		return this.board;
	}
	/**
	 * Obtiene la tile ubicada en unas coordenadas
	 * La posicion (0,0) se encuentra arriba de todo a la izquierda
	 * @param positionX Coordenada X
	 * @param positionY Coordenada Y
	 * @return El casillero en la posicion (x,y) del tablero
	 */
	public Tile getTile(int positionX, int positionY){
		if(positionX<0 || positionY<0 || positionX>=height || positionY>=width){
			throw new IllegalArgumentException();
		}
		return (this.board[positionX][positionY]);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(board);
		result = prime * result + height;
		result = prime * result + width;
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
		Board other = (Board) obj;
		if (!Arrays.deepEquals(board, other.board))
			return false;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
	
}
