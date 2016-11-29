This project finds the average total weight of the minimum spanning tree of a graph using
Kruskal's Algorithm.  It generates complete, undirected graphs on an arbitrary number of 
vertices, with random edge weights. It should be run from the command line with the usage

./randmst 0 [numpoints] [numtrials] [dimension]

Where "0" should be left as-is, numpoints is the number of nodes in the random graph to 
be generated, and numtrials is the number of trials to run. The output is the average 
weight over all trials.  Dimension should be a member of {0, 2, 3, 4}.  A dimension of 
zero will choose edge weights at random.  A dimension of 2 will choose random points in 
the unit square, and the edge weights will be computed as the Euclidean distance between 
points.  Similarly, dimension 3 will use arbitrary points in the unit cube, and dimension 
4 will use arbitrary points in the unit hyper-cube.

Before running, make sure that you have the latest JDK and JRE installed. See Report.pdf 
for a detailed study.
