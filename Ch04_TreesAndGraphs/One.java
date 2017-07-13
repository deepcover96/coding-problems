import java.util.*;



class One {


	//
	//
	//           /------------> D -------> F -----> H
	//    /---> E                     /-->     /-->
	//   /       \----------> B -----/        /
	//	C                /-->                /
	// 	 \              /                   /
	//    \---> A ---> G ------------------/
	//                 \
	//                  \--> X --> Y
	//                        \
	//                         \--> Z

  public static void main(String[] args) {
  	Graph graph = new Graph();
  	GraphNode a = graph.addNode(new GraphNode("A"));
  	GraphNode b = graph.addNode(new GraphNode("B"));
  	GraphNode c = graph.addNode(new GraphNode("C"));
  	GraphNode d = graph.addNode(new GraphNode("D"));
  	GraphNode e = graph.addNode(new GraphNode("E"));
  	GraphNode f = graph.addNode(new GraphNode("F"));
  	GraphNode g = graph.addNode(new GraphNode("G"));
  	GraphNode h = graph.addNode(new GraphNode("H"));
  	GraphNode x = graph.addNode(new GraphNode("X"));
  	GraphNode y = graph.addNode(new GraphNode("Y"));
  	GraphNode z = graph.addNode(new GraphNode("Z"));

  	c.addNode(e);
  	c.addNode(a);
  	e.addNode(d);
  	e.addNode(b);
  	a.addNode(g);
  	d.addNode(f);
  	b.addNode(f);
  	g.addNode(b);
  	g.addNode(h);
  	f.addNode(h);

  	System.out.println("Is there a path between C and H?");
  	System.out.println("   " + isRouteBetweenNodes(c, h));
  	graph.reset();

  	System.out.println("Is there a path between A and B?");
  	System.out.println("   " + isRouteBetweenNodes(a, b));
  	graph.reset();

  	System.out.println("Is there a path between B and X?");
  	System.out.println("   " + isRouteBetweenNodes(b, x));
  }

  // Route between Nodes: Given a directed graph, design an algorithm 
  // to find out whether there is a route between two nodes
  public static boolean isRouteBetweenNodes(GraphNode nA, GraphNode nB) {
	if (GraphNode.bredthFirstSearch(nA, nB.getName()) != null)
		return true;
	else if (GraphNode.bredthFirstSearch(nB, nA.getName()) != null)
		return true;
	else
		return false;
  }
}