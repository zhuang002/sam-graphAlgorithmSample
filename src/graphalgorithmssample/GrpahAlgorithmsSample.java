/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphalgorithmssample;

import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class GrpahAlgorithmsSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] matrix=readInMatrix();
        Graph graph=new Graph(matrix);
        Graph tree=graph.kruskal();// tree=grph.kruskal();
        matrix=tree.getMatrix();
        System.out.println("result of Kruskal");
        printMetrix(matrix);
        
        System.out.println("result of Prim");
        tree=graph.prim();
        printMetrix(tree.getMatrix());
        
        
        System.out.println("Calculate shortest distance");
        int distance=tree.Dijkstra(0,6);
        System.out.println("distance(0,6)="+distance);
    }

    private static int[][] readInMatrix() {
        Scanner sc=new Scanner(System.in);
        int nodes=sc.nextInt();
        int paths=sc.nextInt();
        
        int[][] matrix=new int[nodes][nodes];

        for (int i=0;i<paths;i++) {
            int node1=sc.nextInt();
            int node2=sc.nextInt();
            int length=sc.nextInt();
            matrix[node1][node2]=length;
            matrix[node2][node1]=length;
        }
        
        return matrix;
        
    }

    private static void printMetrix(int[][] matrix) {
        for (int i=0;i<matrix.length;i++) {
            for (int j=i;j<matrix.length;j++) {
                if (matrix[i][j]!=0) {
                    System.out.println(i+" "+j+" "+matrix[i][j]);
                }
            }
        }
    }

}
/*
Possible tools:
java.util.HashSet
Collections.sort()
Collections.binarySort()
ArrayList

*/