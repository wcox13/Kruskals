/**
 *
 * @author williamcox
 * CS125 Pset 2
 * 
 */
public class randmst 
{
    // default tolerance factor
    public static final double DEFAULT_TF = 5;
    
    public static void main(String[] args) 
    {   
        // get command line inputs
        double toleranceFactor = Double.parseDouble(args[0]);
        int n = Integer.parseInt(args[1]);
        int trials = Integer.parseInt(args[2]);
        int dim = Integer.parseInt(args[3]);
        
        // catch bad tolerance factors (including 0) and
        // set to arbitrary default
        if (toleranceFactor < 1.)
        {
            toleranceFactor = DEFAULT_TF;
        }
        
        // average tree size over trials
        float averageWeight = 0.f;
        
        for (int i = 0; i < trials; i++)
        {
            Graph g = new Graph(n, dim, toleranceFactor);
            averageWeight += g.kruskal();
        }
        
        averageWeight /= trials;
        
        System.out.println(averageWeight + " " + n + " "
                + trials + " " + dim);
        
    }
}
