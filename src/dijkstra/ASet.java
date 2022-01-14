package dijkstra;

import java.util.HashSet;

public class ASet implements ASetInterface{
	/**
	 * Set de Vertexinterface
	 * */
	private final HashSet<VertexInterface> aSet;
	
	/**
	 * On initialise l'ensemble A de type Set
	 * */
	public ASet() {
		aSet= new HashSet<VertexInterface>();
	}
	
	public void addVertex(VertexInterface vertex) {
		aSet.add(vertex);
	}
	
	public boolean isInA(VertexInterface vertex) {
		return (aSet.contains(vertex));
	}

}
