This maze solver is based on the Dijkstra algorithm. Each free cell being considered as a node, and each full cell being considered as a node located at infinite distance from all empty cells. The entire algorithm (including the 10 extras) has been hand-coded in Java, with an object-oriented method including a very square architecture.

The different classes are:

- In the Dijkstra folder all classes allowing the implementation of the algorithm if known:
  - GraphInterface: class of graphs associated with the problem
  - ASet: which allows modification of the graphs via the different vertices
  - Pi: class associated with the distance between two nodes
  - Previous: refers to the father of a node
  - VertexInterface: class of a vertex
- In the Maze folder, all classes related to the maze itself:
  - MBox: class for any box
  - ABox: class for the arrival box
  - DBox: class for the departure box
  - EBox: class for an empty box
  - WBox: class for a 'wall' box, that is not empty
  - Maze: class which assembles a real maze with nodes with all these boxes
All the test mazes are located in the data files. 
