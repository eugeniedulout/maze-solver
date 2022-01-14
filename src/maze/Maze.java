package maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

public class Maze implements GraphInterface {
	
	private int height /*longueur*/;
	private int width /*largeur*/;
	private ArrayList<ArrayList<MBox>> maze;

	
	public Maze(int height,int width)
	{
		this.height=height;
		this.width=width;
		this.maze= new ArrayList<ArrayList<MBox>>();
		
		for (int x =0; x < height; x++) {
			ArrayList<MBox> list = new ArrayList<MBox>();
			for (int y= 0; y < width ; y++) {
				list.add(y, new EBox(x,y,this));
			}
			maze.add(x, list);
		}
		
	}
	
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public ArrayList<ArrayList<MBox>> getMaze()
	{ 
		return maze;
	}

	
	/*Renvoie tous les sommets du labyrinthe*/
	
	public ArrayList<VertexInterface> getAllVertices(){
		ArrayList<VertexInterface> AllVertices= new ArrayList<VertexInterface>();
		for (int i=0; i<height; i++) {
			for (int j=0; j< width; j++) {
				AllVertices.add(maze.get(i).get(j));
				
			}
		}
		return(AllVertices);
	}
	
	
		
	/*Renvoie les successeurs d'un sommet*/
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex){ 
		MBox box = (MBox) vertex ;
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>() ;
		int x = box.getX();
		int y = box.getY();
		
		if (y>0) {
			MBox neighbor = maze.get(x).get(y-1);
			if(neighbor.getType() !='W')  {
				successors.add(neighbor);
				}
		}
		if (y<width-1) {
			MBox neighbor = maze.get(x).get(y+1);
			if(neighbor.getType() !='W') {
				successors.add(neighbor);
				}
		}
		if (x>0) {
			MBox neighbor = maze.get(x-1).get(y);
			if(neighbor.getType() !='W') {
				successors.add(neighbor);
				}
			}
		if (x<height-1) {
			MBox neighbor = maze.get(x+1).get(y);
			if(neighbor.getType() !='W')  {
				successors.add(neighbor);
				}
			}
		return successors;
		}
	
	
	
	public int getWeight(VertexInterface src,VertexInterface dst) {
		return 1;
	}
	
	/*Lit le fichier ligne par ligne*/
	
	public final void initFromTextFile(String fileName) {
		/* declaration de buffered reader*/
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			/*On commence par parcourir les lignes*/
			for (int x = 0; x < this.height; x++){
					
				String readLine = br.readLine();
					/*nombre de lignes incohérent, on ne peut pas lire le fichier donc readLine renvoie null*/
					if (readLine == null)
						throw new MazereadingException(fileName, x, "Attention! Pas assez de lignes pour le labyrinthe");
					/*Le nombre de colonnes est insuffisant à une ligne*/
					if (readLine.length() < this.width)
						throw new MazereadingException(fileName, x, "Attention ! Pas assez de colonnes");
					/*Le nombre de colonnes est trop grand à une ligne*/
					if (readLine.length() > this.width) 
						throw new MazereadingException(fileName, x, "Attention! Trop de colonnes");
					
					/*On parcoure ensuite les colonnes*/
					for (int y = 0; y < this.width; y++){ 
						switch (readLine.charAt(y))
						{
						case 'W':
							WBox boxW = new WBox(x, y, this);
							this.maze.get(x).add(y, boxW);
							break;
						case 'A':
							ABox boxA = new ABox(x, y, this);
							this.maze.get(x).add(y,boxA);
							break;
						case 'D':
							DBox boxD = new DBox(x, y, this);
							this.maze.get(x).add(y, boxD);
							break;
						case 'E':
							EBox boxE = new EBox(x, y, this);
							this.maze.get(x).add(y, boxE);
							break;
						
						default:
							throw new MazereadingException(fileName, x, "error");
							}
						}
			       }
				} 
		catch (Exception e) {
					e.printStackTrace();
				}
		finally {
			try {
				br.close();
			} catch (Exception e) { 
				e.printStackTrace();
			}
					
		}
	}

	
	
	/*Sauvegarde le labyrinthe dans un fichier texte*/
	public final void saveToTextFile(String fileName) {
		PrintWriter pWriter = null;
		try {
			pWriter = new PrintWriter(fileName);
			for (int x=0; x<this.height; x++) {
				for (int y=0; y<this.width; y++) {
					pWriter.write(maze.get(x).get(y).getType());
					}
				pWriter.write('\n');
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Erreur: fichier pas trouvé");
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				pWriter.close();
				} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public ArrayList<VertexInterface> getVertices() {
		ArrayList<VertexInterface> list = new ArrayList<VertexInterface>();
		for (int x=0; x < this.height; x++) {
			for (int y=0; y<this.width; y++) {
				list.add(maze.get(x).get(y));
			}
		}
		return list;
	}




			
			
			
}
		
		
	
	

	






