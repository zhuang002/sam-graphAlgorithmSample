/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphalgorithmssample;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author zhuan
 */
public class Graph {
    int[][] matrix=null;
    public Graph(int[][] m) {
        matrix=m;
    }
    
    public void setMatrix(int[][] m) {
        matrix=m;
    }
    
    public int[][] getMatrix() {
        return matrix;
    }

    public Graph prim() {
        int[][] treeMatrix=new int[matrix.length][matrix.length];
        ArrayList<Integer> includeSet=new ArrayList(); // the node set contains all nodes already included in the tree
        includeSet.add(0); //initialize the included set with the first node;
        while (includeSet.size()<matrix.length) { // if no all nodes are included;
            int[] newPath = getNearestPath(includeSet); // get the nearest path that connect to the sub tree
            treeMatrix[newPath[0]][newPath[1]]=newPath[2]; // expand the subtree with the new nearest node. set the originate node of the path
            treeMatrix[newPath[1]][newPath[0]]=newPath[2]; // set the destiny node of the path
            includeSet.add(newPath[1]); // add
        }
        return new Graph(treeMatrix);
        
    }
    
    public Graph kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int[] getNearestPath(ArrayList<Integer> includeSet) {
        int[] path=new int[3];
        int min=Integer.MAX_VALUE;
        for (Integer node : includeSet) {
            for (int i=0;i<matrix.length;i++) {
                int len=matrix[node][i];
                if (len>0 && !includeSet.contains(i)) {
                    if (min>len) {
                        min=len;
                        path[0]=node;
                        path[1]=i;
                        path[2]=len;
                    }
                }
            }
        }
        return path;
    }

    
    
}
