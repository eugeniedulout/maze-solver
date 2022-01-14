package dijkstra;

import java.util.ArrayList;

public interface GraphInterface {
	
	/* Renvoie la liste de tous les sommets*/
	public ArrayList<VertexInterface> getVertices();
	
	/*Renvoie le successeur d'un sommet*/
	public ArrayList<VertexInterface> getSuccessors(VertexInterface x);
	
	/*Renvoie la distance entre deux sommets a et b*/
	public int getWeight(VertexInterface x, VertexInterface y);





}
