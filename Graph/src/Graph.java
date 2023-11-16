import java.util.ArrayList;
import java.util.Arrays;

class Graph {
    private ArrayList<Node> vertex = new ArrayList<>();

    public void addNode (Node nodeToAdd) {
        this.vertex.add(nodeToAdd);
    }

    public void getNodeInfoByName (String nodeName) {
        for (Node node : this.vertex) {
            if (node.name.matches(nodeName)) {
                node.displayInfo();
                break;
            }
        }
    }

    public Node getNodeByName (String nodeName) {
        for (Node node : this.vertex) {
            if (node.name.matches(nodeName)) {
               return node;
            }
        }
        return null;
    }

    public int[][] getRelationMatrix () {
        int[][] result = new int[this.vertex.size()][this.vertex.size()];
        for (int i = 0; i < this.vertex.size(); i++) {
            Node node = (Node) this.vertex.get(i);
            for (int j = 0; j < this.vertex.size(); j++) {
                result[i][j] = node.getRelation(((Node)this.vertex.get(j)).name);
                System.out.print(result[i][j] + " ");
            }
            System.out.print("\n");
        }
        return result;
    }



    /* Grafo de ejemplo */
    public static void main (String[] args) {
        Graph grafo = new Graph();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        ArrayList<ArrayList<Object>> aTo = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(nodeD,5)),
                new ArrayList<>(Arrays.asList(nodeF,3)),
                new ArrayList<>(Arrays.asList(nodeC,3))
        ));
        nodeA.addTo(aTo);
        ArrayList<ArrayList<Object>> BTo = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(nodeE,7)),
                new ArrayList<>(Arrays.asList(nodeF,6))
        ));
        nodeB.addTo(BTo);
        ArrayList<ArrayList<Object>> CTo = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(nodeA,3)),
                new ArrayList<>(Arrays.asList(nodeD,4))
        ));
        nodeC.addTo(CTo);
        ArrayList<ArrayList<Object>> DTo = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(nodeA,5)),
                new ArrayList<>(Arrays.asList(nodeE,2)),
                new ArrayList<>(Arrays.asList(nodeC,4))
        ));
        nodeD.addTo(DTo);
        ArrayList<ArrayList<Object>> ETo = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(nodeD,2)),
                new ArrayList<>(Arrays.asList(nodeB,7)),
                new ArrayList<>(Arrays.asList(nodeF,2))
        ));
        nodeE.addTo(ETo);
        ArrayList<ArrayList<Object>> FTo = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(nodeA,3)),
                new ArrayList<>(Arrays.asList(nodeB,6)),
                new ArrayList<>(Arrays.asList(nodeE,2))
        ));
        nodeF.addTo(FTo);

        Node[] a = {nodeA, nodeB, nodeC, nodeD, nodeE, nodeF};
        for (Node node : a) {
            grafo.addNode(node);
        }

        grafo.getRelationMatrix();
    }
    
}
