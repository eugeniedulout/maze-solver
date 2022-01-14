package dijkstra;

import java.util.ArrayList;

public class Dijkstra {
	
	private static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous) {
		/*Déclaration des variables*/
		VertexInterface pivot= r;
		ArrayList<VertexInterface> vertices= g.getVertices();
		int vlenght= vertices.size();
		
		
		/*On initialise*/
	
		a.addVertex(r);
		pi.setPiValue(r,  0);
		
		/*On impose la valeur infinie pour tous les sommets sauf r*/
		for (VertexInterface x: g.getVertices()) {
			
			if (x != r) {
				
				pi.setPiValue(x, Integer.MAX_VALUE);
			}
		}
		
		/*Recherche du prochain pivot*/
		
		for (int j=0; j<vlenght-1; j++) {
			for (VertexInterface x: g.getSuccessors(pivot)) 
			{
				if (! a.isInA(x)) 
				{
					
					if (pi.getPi(pivot) + g.getWeight(pivot, x)< pi.getPi(x)) 
					{
						pi.setPiValue(x, pi.getPi(pivot)+g.getWeight(pivot, x));
						previous.setPrevious(x, pivot);
					}
				}
			}
			
			
				int minPi= Integer.MAX_VALUE;
				for (VertexInterface v: g.getVertices()) {
					if(! a.isInA(v) && pi.getPi(v)< minPi) {
						minPi= pi.getPi(v);
						pivot= v;
					
					}
				}
			
		a.addVertex(pivot);
		}
		return previous;

}
	
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		ASet aSet = new ASet();
		Previous previous = new Previous();
		Pi pi = new Pi();
		return dijkstra(g, r, aSet, pi, previous);
		
	}
}
