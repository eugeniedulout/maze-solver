package dijkstra;

public interface ASetInterface {
	//Ajoute un element a l'ensemble A
	public void addVertex (VertexInterface vertex);
	
	//verifie si un element y est dans A
	public boolean isInA (VertexInterface vertex);
	
	
}
