package dijkstra;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import maze.ABox;
import maze.DBox;
import maze.Maze;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		Maze maze = new Maze(10,10);
		maze.initFromTextFile("data/labyrinthe.txt");
		
		int height= maze.getHeight();
		int width=maze.getWidth();
		DBox departure = null;
		ABox arrival = null;
		
		for (int x=0; x < height; x++) {
			for (int y=0; y< width; y++) {
				if (maze.getMaze().get(x).get(y).getType()== 'D') {
					departure= (DBox) maze.getMaze().get(x).get(y);
				}
				if (maze.getMaze().get(x).get(y).getType()== 'A') {	
					arrival= (ABox) maze.getMaze().get(x).get(y);
				}
			}
		}
		
		GraphInterface g = (GraphInterface)maze;
		PreviousInterface previous= Dijkstra.dijkstra(g, departure);
		VertexInterface son= arrival;
		VertexInterface father= previous.getPrevious(son);
		
		ArrayList<VertexInterface> list = new ArrayList<VertexInterface>();
		list.add(son);
		
		while ( father != departure ) 
		{
			list.add(father);
			son=father;
			father=previous.getPrevious(father);
		}
		
		PrintWriter text= new PrintWriter("data/labyrinthe2.txt");
		for (int x =0; x<height; x++)
		{
			for (int y =0; y<width; y++)
			{
				
				{
				switch (maze.getMaze().get(x).get(y).getType())
					{	case'A':text.append("A");
						break;
						case'D':text.append("D");
						break;
						case'E':
						if ( list.contains(maze.getMaze().get(x).get(y)) )
						{
							text.write(".");
						}
						else 
						{
							text.append("E");
						}
						break;	
						case'W':text.append("W");
						break;
					}
				}
				
			}
		text.append("\n");
		}
		text.close();
		
	}


		
	}
	

	
	


