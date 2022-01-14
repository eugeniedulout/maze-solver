package dijkstra;

import java.util.Hashtable;

public class Previous implements PreviousInterface {
	private final Hashtable<VertexInterface, VertexInterface> previous ;
	
	public Previous() {
		previous= new Hashtable<VertexInterface, VertexInterface>();
	}

	@Override
	public void setPrevious(VertexInterface x, VertexInterface p) {
		previous.put(x,p); /*indique que le père de x est p*/
		
	}

	@Override
	public VertexInterface getPrevious(VertexInterface x) {
		return previous.get(x);
	}
	

	

}
