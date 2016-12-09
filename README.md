# Kruskals Algorithm
Efficiently determines the total weight of a minimum spanning tree using Kruskal's algorithm.

## Background
This project finds the average total weight of the minimum spanning tree of a graph using
Kruskal's Algorithm.  It generates complete, undirected graphs on an arbitrary number of 
vertices, with random edge weights.

## Usage
To try it out, download or clone the directory and navigate to it in your terminal.  Type

`make`

then type

`java randmst 0 [numpoints] [numtrials] [dimension]`

`0` should be left as-is, `numpoints` is the number of nodes in the random graph to 
be generated, and `numtrials` is the number of trials to run. The output is the average 
weight over all trials.  Dimension should be a member of `[0, 2, 3, 4]`.  A dimension of 
zero will choose edge weights at random.  A dimension of 2 will choose random points in 
the unit square, and the edge weights will be computed as the Euclidean distance between 
points.  Similarly, dimension 3 will use arbitrary points in the unit cube, and dimension 
4 will use arbitrary points in the unit hyper-cube.

`numpoints` should of course be greater than 2, and `numtrials` should be reasonably small
(unless you have all day!).  Note that there is no input validation, since this is merely a
algorithm study; the end-user is, well, me :)

## Notes
Before running, make sure that you have the latest JDK and JRE [installed](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html). See `Report.pdf`
for a detailed study.
