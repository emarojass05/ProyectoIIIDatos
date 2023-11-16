package com.carpooling.CarPooling;
import java.util.*;

class Node {
    private boolean visited = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;
    private ArrayList<ArrayList<Object>> associations = new ArrayList<>();

    public Node (String name) {
        this.name = name;
    }

    public Node (String name, ArrayList<ArrayList<Object>> relations) {
        this.name = name;
        this.associations = relations;
    }
    public void addSingleTo (Node nodeTo, int weight) {
        ArrayList<Object> association = new ArrayList<>();
        association.add(nodeTo);
        association.add(weight);
        this.associations.add(association);
    }

    public void addTo (ArrayList<ArrayList<Object>> relations) {
        for (ArrayList<Object> relation : relations) {
            if (!this.associations.contains(relation)) {
                this.associations.add(relation);
            }
        }
    }

    public ArrayList<ArrayList<Object>> getAssociations () {
        return this.associations;
    }

    public void displayInfo () {
        System.out.println("Las conexiones del nodo " + this.name + " son:");
        for (ArrayList<Object> relation : this.associations) {
            System.out.println("Nodo " + ((Node) relation.get(0)).name + ", Peso: " + relation.get(1));
        }
    }

    public int getRelation (String nodeName) {
        if (nodeName.matches(this.name)) {
            return 0;
        }
        for (ArrayList<Object> a : this.associations) {
            if (((Node)a.get(0)).name.matches(nodeName)) {
                return (int)a.get(1);
            }
        }
        return 999;
    }

    public void setVisited () {
        this.visited = true;
    }

    public void setNotVisited () {
        this.visited = false;
    }
}