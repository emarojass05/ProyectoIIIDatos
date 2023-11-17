package com.Carpooling.repositories;


import com.Carpooling.Graph;
import com.Carpooling.Node;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class RutaRepository {

    public static int calcular(int[] lista){
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

        return grafo.getPesoRuta(grafo, lista, grafo.getGraphGrade());
    }
}
