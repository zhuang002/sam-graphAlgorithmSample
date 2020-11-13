/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphalgorithmssample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author zhuan
 */
public class GraphTest {

    public GraphTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of prim method and kruskal method, of class Graph.
     */
    @Test
    public void testPrimKruskal() {
        int[][] treeMatrix = {
            {0, 1, 2},
            {0, 2, 2},
            {1, 2, 2},
            {1, 4, 3},
            {2, 3, 1},
            {2, 5, 3},
            {2, 9, 2},
            {3, 4, 2},
            {3, 5, 6},
            {3, 8, 8},
            {3, 10, 3},
            {4, 10, 2},
            {5, 6, 1},
            {5, 7, 4},
            {5, 8, 5},
            {5, 9, 3},
            {6, 8, 4},
            {6, 10, 4},
            {7, 8, 3},
            {7, 9, 3},
            {8, 9, 7},
            {8, 11, 1},
            {10, 11, 2}
        };
        System.out.println("prim & kruskal");
        Graph instance = new Graph(treeMatrix);
        int[][] expResult = instance.kruskal().getMatrix();
        int[][] result = instance.prim().getMatrix();
        for (int i = 0; i < treeMatrix.length; i++) {
            for (int j = 0; j < treeMatrix.length; j++) {
                assertEquals(expResult[i][j], result[i][j]);
            }
        }
    }
}
