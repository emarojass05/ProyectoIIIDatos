import java.util.ArrayList;
import java.util.Arrays;

class Graph {
    public ArrayList<Node> vertex = new ArrayList<>();

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

    public void addSingleRelationToNode (String nodeToUpdateName, String nodeToAddName, int weight) {
        for (Node node : this.vertex) {
            if (node.name.matches(nodeToUpdateName)) {
                node.addSingleTo(this.getNodeByName(nodeToAddName), weight);
                break;
            }
        }
    }

    public void addRelationsToNode (String nodeToUpdateName, Object[][] relations) {
        for (Node node : this.vertex) {
            if (node.name.matches(nodeToUpdateName)) {
                for (Object[] relation : relations) {
                    node.addSingleTo(this.getNodeByName((String)relation[0]), (int)relation[1]);
                }
                break;
            }
        }
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



    /* Grafo del mapa */
    public static void main (String[] args) {
        Graph cartagoGraph = MapGraph.getMapGraph();
        cartagoGraph.getRelationMatrix();
    }
    
}
