/**
 *
 * @author williamcox
 * CS125 Pset 2
 * 
 */
public class Edge implements Comparable<Edge>
{
    private final int vert1;
    private final int vert2;
    private final float weight;
    
    // constructor
    public Edge(int v1, int v2, float w)
    {
        vert1 = v1;
        vert2 = v2;
        weight = w;
    }

    // getters
    public int getVert1()
    {
        return vert1;
    }
    
    public int getVert2()
    {
        return vert2;
    }
    
    public float getWeight()
    {
        return weight;
    }
    
    // compare edges by weight only
    @Override public int compareTo(Edge that)
    {
        if (this.weight < that.weight)
        {
            return -1;
        }
        
        else if (this.weight > that.weight)
        {
            return 1;
        }
        
        else
        {
            return 0;
        }
    }
}
