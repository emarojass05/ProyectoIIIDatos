package com.Carpooling;

/**
 * Esta clase representa el algoritmo de la ruta mas corta entre 2 puntos
 */
public class Dijkstra
{
    /**
     * distance: representa un arreglo con la distancia entre nodos
     * cost; representa una matriz con el costo de todos los nodos o (Matriz de adyacencias)
     */
    public  int distance[];
    public  int cost[][];

    /**
     * Constructor
     * @param tamaño
     */
    public Dijkstra(int tamaño){
        this.distance = new int[tamaño + 2];
        this.cost = new int[tamaño + 2][tamaño + 2];
    }

    /**
     * Metodo que calcula la ruta mas corta
     * @param n
     * @param s
     */
    public void calc(int n,int s)
    {
        int flag[] = new int[n+1];
        int i,minpos=1,k,c,minimum;
        int path[] = new int[100];
        int path_pos = 0;

        for(i=1;i<=n;i++)
        {
            flag[i]=0;
            this.distance[i]=this.cost[s][i];
        }
        c=2;
        while(c<=n)
        {
            minimum=99;
            for(k=1;k<=n;k++)
            {
                if(this.distance[k]<minimum && flag[k]!=1)
                {
                    minimum=this.distance[i];
                    minpos=k;
                }
            }
            flag[minpos]=1;
            c++;
            for(k=1;k<=n;k++){
                if(this.distance[minpos]+this.cost[minpos][k] <  this.distance[k] && flag[k]!=1){
                    System.out.println("Antes: " + this.distance[minpos] + ", " + this.cost[minpos][k]);
                    this.distance[k]=this.distance[minpos]+this.cost[minpos][k];
                    System.out.println("Despues: " + this.distance[k]);
                }
            }
        }
    }

}
