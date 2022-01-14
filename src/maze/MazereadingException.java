package maze;


public class MazereadingException extends Exception{
	
	private String error;
	private int line;
	private String file;
	
	public MazereadingException(String error, int line, String file) {
		super(file + "line" + line + error);
		this.error= error;
		this.line= line;
		this.file= file;
		
		
	}
	
	

}
