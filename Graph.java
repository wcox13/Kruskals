import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

/**
 *
 * @author williamcox
 * CS125 Pset 2
 *
 */


public class Graph 
{ 
    // constants for determining max edge length
    // max edges = (factor) (n)^(exp)
    public static final double DIM_0_FACTOR = 1.1075;
    public static final double DIM_0_EXP = -0.81574;
    
    public static final double DIM_2_FACTOR = 1.2110;
    public static final double DIM_2_EXP = -0.44683;
    
    public static final double DIM_3_FACTOR = 1.3887;
    public static final double DIM_3_EXP = -0.32956;
    
    public static final double DIM_4_FACTOR = 1.0554;
    public static final double DIM_4_EXP = -0.21002;
    
    // number of vertices, dimension, and number of edges (length of array)
    private final int n;
    private final int dim;
    
    // tolerance factor for throwing out edges
    private final double toleranceFactor;
    
    // max edge weight
    private final float maxWeight;
    
    // array of edges and their endpoints
    private final ArrayList<Edge> graph;
    
    // creates a new graph with given dimension
    public Graph(int n, int dim, double toleranceFactor)
    {        
        this.n = n;
        this.dim = dim;
        this.toleranceFactor = toleranceFactor;
        
        // find max edge
        // does not handle dimensions outside {0, 2, 3, 4}!
        if (dim == 0)
        {
            maxWeight = (float) (toleranceFactor * DIM_0_FACTOR *
                    Math.pow(n, DIM_0_EXP));
        }
        
        else if (dim == 2)
        {
            maxWeight = (float) (toleranceFactor * DIM_2_FACTOR *
                    Math.pow(n, DIM_2_EXP));
        }
        
        else if (dim == 3)
        {
            maxWeight = (float) (toleranceFactor * DIM_3_FACTOR *
                    Math.pow(n, DIM_3_EXP));            
        }
        
        else
        {
            maxWeight = (float) (toleranceFactor * DIM_4_FACTOR *
                    Math.pow(n, DIM_4_EXP));
        }
        
        // find number of edges
        graph = new ArrayList<>(n);
        
        //instantiate random number generator
        Random gen1 = new Random();
        
        // handle zero dim special case
        if (dim == 0)
        {   
            // fill array with an edge weight for each unique pair of verts
            for (int i = 0; i < n - 1; i++)
            {
                for (int j = 0; j < n - i - 1; j++)
                {
                    float weight = gen1.nextFloat();
                    
                    if (weight < maxWeight)
                    {
                        graph.add(new Edge(i, i + j + 1, weight));
                    }
                }
            }
        }
        
        // handle arbitrary dimension
        else if (dim > 1)
        {
            // create and fill 2-d array to store coordinates
            float[][] coords = new float[n][dim];
            Random gen2 = new Random();
            
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < dim; j++)
                {
                    coords[i][j] = gen2.nextFloat();
                }
            }
            
            // fill array with an edge weight for each unique pair of verts
            for (int i = 0; i < n - 1; i++)
            {
                for (int j = 0; j < n - i - 1; j++)
                {
                    // calculate distance^2
                    float dist = 0;
                    for (int k = 0; k < dim; k++)
                    {
                        float diff = coords[i][k] - coords[i + j + 1][k];
                        dist += diff * diff;
                    }
                    
                    // add to graph if weight is small enough
                    float weight = (float) Math.sqrt(dist);
                    
                    if (weight < maxWeight)
                    {
                        graph.add(new Edge(i, i + j + 1, weight));
                    }
                }
            }
        }
    }

    // returns the weight of the mst
    public float kruskal()
    {
        // sort edges by weight using java built in array sort
        Collections.sort(graph);
        
        // create disjoint sets
        DisjointSet s = new DisjointSet(n);
        
        // iterate over sorted edges
        // i is position in index
        int i = 0, j = 0;
        float totalWeight = 0.f;
        while (j < n - 1)
        {
            // check whether endpoints of graph[i] are in same set
            try
            {
                Edge e = graph.get(i);
                int v1 = e.getVert1(), v2 = e.getVert2();
            
                if (s.find(v1) != s.find(v2))
                {
                    // if not, add edge to mst and combine sets
                    totalWeight += e.getWeight();
                    s.union(v1, v2);
                    j++;
                }

                i++;
            }
            
            // if we get index out of bounds, the graph does not connect
            // in other words, too many edges were thrown out
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("Tolerance factor too small.  Try again"
                        + " with a larger tolerance factor.");
                
                System.exit(0);
            }
        }
        
        return totalWeight;
    }
    
    // prints adjacency matrix (for testing)
    public static void print(ArrayList<Edge> graph)
    {
        System.out.print("\nVert1:\t");
        for (Edge e : graph)
        {
            System.out.print(e.getVert1() + "\t");
        }
        
        System.out.print("\n\nVert2:\t");
        for (Edge e : graph)
        {
            System.out.print(e.getVert2() + "\t");
        }
        
        System.out.print("\n\nWeight:\t");
        for (Edge e : graph)
        {
            System.out.print(String.format("%.2f\t", e.getWeight()));
        }
        
        System.out.println("\n");
    }
}
