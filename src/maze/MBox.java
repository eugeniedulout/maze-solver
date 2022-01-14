package maze;

import java.util.ArrayList;

import dijkstra.VertexInterface;

public class MBox implements VertexInterface{
	
	//On definit les coordonnées x et y de chaque box
	private int x;
	private int y;
	private Maze maze;
	private char type;
	
	public MBox(int x, int y, Maze maze, char type) {
	
		this.x = x;
		this.y = y;
		this.maze= maze;
		this.type= type;
	}
	
	public final int getX()
	{return x;}
	
	public final int getY() {
		return y;
	}
	
	public final char getType() {
		return(type);
	}


	public void getLabel() {
		System.out.print("x="+x+"y="+y);
	}


	}


	

