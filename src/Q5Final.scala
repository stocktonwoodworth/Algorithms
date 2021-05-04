/**
 * Implementation of the Floyd-Warshall algorithm
 * to find all shortest paths.
 *
 * @author Stockton Woodworth
 */
class Q5Final {

    val INFINITY: Double = 99 // represent infinity
    val V = 11 // Number of vertices

    /**
     * Print out the adjacency matrix
     *
     * @param cost - array containing cost
     */
    def printMatrix(cost: Array[Array[Double]]): Unit = {

      var i = 0

      while (i < V) {
        var j = 0

        while (j < V) {
          if (cost(i)(j) == INFINITY) {
            print(" \u221e ") // print infinity symbol
          } else {
            // round to one decimal place
            print(BigDecimal(cost(i)(j)).setScale(1, BigDecimal.RoundingMode.HALF_DOWN).toDouble + "  ")
          }
          j += 1
        }
        println()
        i += 1
      }
    }

    /**
     * Implementation of the Floyd Warshall algorithm
     * to find all shortest paths.
     *
     * @param cost - cost or weight matrix
     * @return D - min path distance between vertices
     */
    def FloydWarshall(cost: Array[Array[Double]]): Array[Array[Double]] = {

      val D = Array.ofDim[Double](V, V) // 2-D matrix  to store updated cost
      val n = V

      // assign new matrix to cost input
      for (i <- 0 until n) {
        for (j <- 0 until n) {
          D(i)(j) = cost(i)(j)
        }
      }

      for (k <- 0 until n) {
        // Calculate the min path to a vertex
        for (i <- 0 until n) {
          for (j <- 0 until n) {

            if (D(i)(k) == INFINITY || D(k)(j) == INFINITY) {

            } else if (D(i)(k) + D(k)(j) < D(i)(j)) {
              D(i)(j) = D(i)(k) + D(k)(j)
            }
          }
        }

        println("Table " + k + ":")
        printMatrix(D)
        println("==========================================================\n")

        // Check for negative weight cycle
        for (i <- 0 until n) {
          if (D(i)(i) < 0) {
            println("No solution, negative weight cycle found.")
            return null
          }
        }
      }
      D // return D
    }
}
