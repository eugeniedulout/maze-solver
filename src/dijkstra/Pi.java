package dijkstra;

import java.util.Hashtable;

public class Pi implements PiInterface{
	
	private final Hashtable<VertexInterface, Integer> table;
	
	public Pi() {
		table = new Hashtable<VertexInterface, Integer>();
	}

	@Override
	public int getPi(VertexInterface v) {
		return table.get(v).intValue();
	}

	@Override
	public void setPiValue(VertexInterface v, int i) {
		table.put(v, i);
		
	}
	
	
	

}
