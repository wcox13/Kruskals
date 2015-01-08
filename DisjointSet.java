/**
 *
 * @author williamcox
 * CS125 Pset 2
 * 
 */
public class DisjointSet
{
    // arrays to store parents and ranks
    private final int[] parents;
    private final int[] ranks;
    private final int n;
    
    // initializer will perform makeset on each of n elements
    public DisjointSet(int n)
    {
        this.n = n;
        
        // ranks will auto fill with zeros, as desired
        ranks = new int[n];
        
        // make each set its own parent
        parents = new int[n];
        for (int i = 0; i < n; i++)
        {
            parents[i] = i;
        }
    }
    
    // returns the parent of set i
    public int find(int i)
    {
        // recursively find the ultimate parent
        if (parents[i] != i)
        {
            parents[i] = find(parents[i]);
            return parents[i];
        }
        
        // bottom out if i is its own parent
        return i;
    }
    
    // links two sets together by rank, assuming both inputs are parents
    private int link(int i, int j)
    {
        // ensure j has greater rank
        if (ranks[i] > ranks[j])
        {
            int temp = i;
            i = j;
            j = temp;
        }
        
        // if the ranks are equal, one rank will have to increase
        if (ranks[i] == ranks[j])
        {
            ranks[j]++;
        }
        
        // set i's parent to j and return j
        parents[i] = j;
        return j;
    }
    
    // takes union of two sets (even if not given roots)
    public int union(int i, int j)
    {
        return link(find(i), find(j));
    }
    
    // prints representation of the forest (for testing)
    public void print()
    {
        System.out.print("Set:\t");
        for (int i = 0; i < n; i++)
        {
            System.out.print(i + "\t");
        }
        
        System.out.print("\n\nParent:\t");
        for (int i = 0; i < n; i++)
        {
            System.out.print(parents[i] + "\t");
        }
        
        System.out.print("\n\nRank:\t");
        for (int i = 0; i < n; i++)
        {
            System.out.print(ranks[i] + "\t");
        }
    }
}
