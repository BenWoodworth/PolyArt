package net.benwoodworth.polyart.matrix

interface Matrix<TRows : MatrixSize, TColumns : MatrixSize> {
    val rows: Int
    val columns: Int

    operator fun get(row: Int, column: Int): Double

//    val determinant: Double
//
//    val transpose: Matrix<TColumns, TRows>
//
//    fun <TArgColumns : MatrixSize> crossProduct(
//            matrix: Matrix<TColumns, TArgColumns>
//    ): Matrix<TRows, TArgColumns>
//
//    infix fun <TArgColumns : MatrixSize> x(
//            matrix: Matrix<TColumns, TArgColumns>
//    ): Matrix<TRows, TArgColumns>
//
//    operator fun plus(matrix: Matrix<TRows, TColumns>): Matrix<TRows, TColumns>
//
//    operator fun times(multiplier: Double): Matrix<TRows, TColumns>
//
//    operator fun unaryPlus(): Matrix<TRows, TColumns>
//
//    operator fun unaryMinus(): Matrix<TRows, TColumns>
}
