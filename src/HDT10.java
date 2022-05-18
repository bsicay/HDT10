public class HDT10 {
    public static void main(String[] args){
        Reader read = new Reader();
        int[][] matrix = read.getMatrix();

        AllPairShortestPath a = new AllPairShortestPath();

        // Print the solution
        a.floydWarshall(matrix);
    }
}
