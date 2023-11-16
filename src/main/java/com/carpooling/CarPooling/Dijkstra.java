package com.carpooling.CarPooling;

import java.util.*;
public class Dijkstra
{
    public  int distance[];
    public  int cost[][];

    public Dijkstra(int tamaño){
        this.distance = new int[tamaño + 2];
        this.cost = new int[tamaño + 2][tamaño + 2];
    }

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
