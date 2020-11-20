/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphalgorithmssample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author zhuan
 * 
 * testing data:
 * 
 * 
12 23
0 1 2
0 2 2
1 2 2
1 4 3
2 3 1
2 5 3
2 9 2
3 4 2
3 5 6
3 8 8
3 10 3
4 10 2
5 6 1
5 7 4
5 8 5
5 9 3
6 8 4
6 10 4
7 8 3
7 9 3
8 9 7
8 11 1
10 11 2
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
        Set<Integer> includeSet=new HashSet(); // the node set contains all nodes already included in the tree
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
        ArrayList<int[]> paths = retrievePaths();
        Collections.sort(paths, (x,y)->x[2]-y[2]);
        Set<Set<int[]>> subtrees=new HashSet();
        Set<Integer> includeNodes=new HashSet();
        int[][] treeMatrix=new int[matrix.length][matrix.length];
        for (int[] path:paths) {
            if (includeNodes.size()==matrix.length && subtrees.size()==1)
                break;
            Set<int[]> subtree1=getSubtree(path[0],subtrees);
            Set<int[]> subtree2=getSubtree(path[1],subtrees);
            if (subtree1==null) { 
                // the first node is not in any subtree
                if (subtree2==null) { // the second node is not in any subtree
                    Set<int[]> newSubTree=new HashSet();
                    newSubTree.add(path);
                    subtrees.add(newSubTree);
                    includeNodes.add(path[0]);
                    includeNodes.add(path[1]);
                } else {
                    // the second node is in a subtree but the first is not in any subtree
                    subtree2.add(path);
                    includeNodes.add(path[0]);
                }
            } else { // the first node is in a subtree
                if (subtree2==null) {
                    // the first node is in a subtree but second node is not.
                    subtree1.add(path);
                    includeNodes.add(path[1]);
                } else { //both nodes are in subtrees.
                    if (subtree1!=subtree2) { // compare the reference
                        // the 2 subtrees are not the same. we need to merge them.
                        subtree1.addAll(subtree2);
                        subtree1.add(path);
                        subtrees.remove(subtree2);
                    }
                }
            }
        }
        Set<int[]> treePaths=subtrees.iterator().next();
        for (int[] path:treePaths) {
            treeMatrix[path[0]][path[1]]=path[2];
            treeMatrix[path[1]][path[0]]=path[2];
        }
        return new Graph(treeMatrix);
        
    }

    private int[] getNearestPath(Set<Integer> includeSet) {
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

    private ArrayList<int[]> retrievePaths() {
        ArrayList<int[]> paths=new ArrayList();
        for (int i=0;i<matrix.length;i++) {
            for (int j=i+1;j<matrix.length;j++) {
                if (matrix[i][j]>0) {
                    int[] path=new int[3];
                    path[0]=i;
                    path[1]=j;
                    path[2]=matrix[i][j];
                    paths.add(path);
                }
            }
        }    
        return paths;
    }

    private Set<int[]> getSubtree(int node, Set<Set<int[]>> subtrees) {
        for (Set<int[]> subtree:subtrees) {
            for (int[] path:subtree) {
                if (path[0]==node || path[1]==node)
                    return subtree;
            }
        }
        return null;
    }

    int Dijkstra(int start, int end) {
        Set<Integer> current=new HashSet();
        Set<Integer> used=new HashSet();
        int[] distances=new int[this.matrix.length]; // the index is the node id, the value is the nearest distance to the start node.
        for (int i=0;i<distances.length;i++)
            distances[i]=-1;
        distances[start]=0;
        current.add(start); //starting from node start, 
                            //so that the set of nodes being processed initally contains only start 
        
        while (!current.isEmpty()) {
            // select the nearest node in processed node set to expand
            int nearestNode=getNearestNode(current,distances); 
            // get neighbours of the nearest node, and add to the process node set
            current.addAll(getNeighbours(nearestNode,used,distances)); 
            
            // remove the node(the nearest node that has just been processed from the process node set)
            current.remove(nearestNode);
            // add the processed node (nearest node) to the used node set.
            used.add(nearestNode);
        }
        
        
        
    }

    private int getNearestNode(Set<Integer> current, int[] distances) {
        // return a nearest node to the start node.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Set<Integer> getNeighbours(int node, Set<Integer> used, int[] distances) {
        // get unprocessed neighbout nodes of a node. 
        // and calculate the distances of this neighbours from the start node.
        return null;
    }

    
    
}
