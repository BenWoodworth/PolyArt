package net.benwoodworth.math.matrix

@Suppress("unused")
interface Matrix<TRows : MatrixSize, TColumns : MatrixSize> {
    val rows: Int
    val columns: Int

    operator fun get(row: Int, column: Int): Double
}
