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
        ArrayList<Integer> includeSet=new ArrayList();
        includeSet.add(0);
        while (includeSet.size()<matrix.length) {
            int[] newPath = getNearestPath(includeSet);
            treeMatrix[newPath[0]][newPath[1]]=newPath[2];
            treeMatrix[newPath[1]][newPath[0]]=newPath[2];
            includeSet.add(newPath[1]);
        }
        return new Graph(treeMatrix);
        
    }
    
    public Graph kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int[] getNearestPath(ArrayList<Integer> includeSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
