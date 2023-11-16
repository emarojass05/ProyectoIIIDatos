package com.carpooling.CarPooling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<Node> vertex = new ArrayList<>();

    public void addNode (Node nodeToAdd) {
        this.vertex.add(nodeToAdd);
    }

    public int getGraphGrade(){
        int grado = 0;
        for (Node node : this.vertex) {
            grado++;
        }
        return grado;
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

    public ArrayList<Node> getNodes(){
        ArrayList<Node> lista = new ArrayList<Node>();
        for (Node node : this.vertex) {
            lista.add(node);
        }
        return lista;
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

    public int getPesoRuta(Graph grafo, int[] lista, int grade){
        int ruta = 0;
        int[][] matriz = grafo.getRelationMatrix();
        Dijkstra d = new Dijkstra(grafo.getGraphGrade());
        for (int i = 1; i <= grafo.getGraphGrade(); i++){
            for (int j = 1; j <= grafo.getGraphGrade(); j++){
                d.cost[i][j] = matriz[i-1][j-1];
            }
        }
        for (int i = 1; i < lista.length; i++){
            d.calc(grade, lista[i]);
            System.out.println("source :"+(lista[i-1])+"\t destination :"+lista[i]+"\t MinCost is :"+d.distance[lista[i-1]]+"\t");
            ruta += d.distance[lista[i-1]];
        }
        return ruta;
    }

    /* Grafo de ejemplo */
    public static void main (String[] args) throws JsonProcessingException {
        Graph grafo = new Graph();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        ArrayList<ArrayList<Object>> aTo = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(nodeB, 3)),
                new ArrayList<>(Arrays.asList(nodeD, 5))
        ));
        nodeA.addTo(aTo);
        ArrayList<ArrayList<Object>> BTo = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(nodeA, 3)),
                new ArrayList<>(Arrays.asList(nodeC, 6)),
                new ArrayList<>(Arrays.asList(nodeD, 4))
        ));
        nodeB.addTo(BTo);
        ArrayList<ArrayList<Object>> CTo = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(nodeB, 6)),
                new ArrayList<>(Arrays.asList(nodeE, 2))
        ));
        nodeC.addTo(CTo);
        ArrayList<ArrayList<Object>> DTo = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(nodeA, 5)),
                new ArrayList<>(Arrays.asList(nodeB, 4)),
                new ArrayList<>(Arrays.asList(nodeE, 7))
        ));
        nodeD.addTo(DTo);
        ArrayList<ArrayList<Object>> ETo = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(nodeC, 2)),
                new ArrayList<>(Arrays.asList(nodeD, 7))
        ));
        nodeE.addTo(ETo);

        Node[] a = {nodeA, nodeB, nodeC, nodeD, nodeE};
        for (Node node : a) {
            grafo.addNode(node);
        }
        int[] lista = new int[]{3, 5, 1};

        System.out.println(grafo.getPesoRuta(grafo, lista, grafo.getGraphGrade()));





    }
}