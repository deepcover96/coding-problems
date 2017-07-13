import java.util.*;



class GraphNode {

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

    System.out.println("Looking for F...");
    GraphNode n = bredthFirstSearch(c, "F");
    if (n == null)
        System.out.println("F not Found.");
    else
        System.out.println("Found: " + n.getName());

  }

  private String name;
  private boolean visited;
  private List<GraphNode> nodes;


  public GraphNode(String name) {
    this.name = name;
    this.visited = false;
    this.nodes = new ArrayList<GraphNode>();
  }

  public String getName() { return name; }
  public boolean isVisited() { return visited; }
  public void setVisit(boolean visit) { visited = visit; }
  public List<GraphNode> getNodes() { return nodes; }
  public void addNode(GraphNode node) {
    nodes.add(node);
  }




  public static GraphNode bredthFirstSearch(GraphNode start, String value) {
    Queue<GraphNode> queue = new LinkedList<GraphNode>();
    queue.add(start);

    while (!queue.isEmpty()) {
        GraphNode node = queue.remove();
        System.out.println("Checking: " + node.getName());
        for (GraphNode n : node.getNodes()) {
            if (!n.isVisited()) {
                n.setVisit(true);
                if (n.getName() == value)
                    return n;
                else
                    queue.add(n);
            }
        }
    }

    return null;
  }
}

class Graph {
    List<GraphNode> graphList;

    public Graph() {
        graphList = new ArrayList<GraphNode>();
    }

    public GraphNode addNode(GraphNode node) {
        graphList.add(node);
        return node;
    }

    public void reset() {
        for (GraphNode n : graphList) {
            n.setVisit(false);
        }
    }
}