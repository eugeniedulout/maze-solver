package dijkstra;

public interface PreviousInterface {
	
	public void  setPrevious(VertexInterface x, VertexInterface previous);
	
	public VertexInterface getPrevious(VertexInterface x);

}
