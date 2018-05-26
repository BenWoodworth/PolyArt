package net.benwoodworth.math.matrix

@Suppress("unused")
interface Matrix<TRows : MatrixSize, TColumns : MatrixSize> {

    val rows: Int
    val columns: Int

    val transposed: Matrix<TColumns, TRows>

    operator fun get(row: Int, column: Int): Double

    operator fun plus(matrix: Matrix<TRows, TColumns>): Matrix<TRows, TColumns>

    operator fun minus(matrix: Matrix<TRows, TColumns>): Matrix<TRows, TColumns>

    operator fun <TNewColumns : MatrixSize> times(matrix: Matrix<TColumns, TNewColumns>): Matrix<TRows, TNewColumns>

    operator fun <TNewColumns : MatrixSize> invoke(matrix: Matrix<TColumns, TNewColumns>): Matrix<TRows, TNewColumns>

    operator fun times(multiplier: Double): Matrix<TRows, TColumns>

    operator fun div(divisor: Double): Matrix<TRows, TColumns>

    operator fun unaryPlus(): Matrix<TRows, TColumns>

    operator fun unaryMinus(): Matrix<TRows, TColumns>

    override fun equals(other: Any?): Boolean

    override fun hashCode(): Int

    override fun toString(): String
}