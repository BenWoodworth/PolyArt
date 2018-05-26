package net.benwoodworth.math.matrix.operations

import net.benwoodworth.math.matrix.Matrix
import net.benwoodworth.math.matrix.implementations.MatrixBase
import net.benwoodworth.math.matrix.MatrixSize

internal class MatrixMultiplier<TRows : MatrixSize, TColumns : MatrixSize>(
        private val matrix: Matrix<TRows, TColumns>,
        private val multiplier: Double
) : MatrixBase<TRows, TColumns>() {

    override val rows = matrix.rows
    override val columns = matrix.columns

    override fun get(row: Int, column: Int) = matrix[row, column] * multiplier
}