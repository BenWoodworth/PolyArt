package net.benwoodworth.math.matrix.operations

import net.benwoodworth.math.matrix.Matrix
import net.benwoodworth.math.matrix.implementations.MatrixBase
import net.benwoodworth.math.matrix.MatrixSize

internal class MatrixSum<TRows : MatrixSize, TColumns : MatrixSize>(
        private val matrixA: Matrix<TRows, TColumns>,
        private val matrixB: Matrix<TRows, TColumns>
) : MatrixBase<TRows, TColumns>() {

    init {
        require(matrixA.rows == matrixB.rows && matrixA.columns == matrixB.columns) {
            "The size of matrixA (${matrixA.rows}x${matrixA.columns}) " +
                    "must match the size of matrixB (${matrixB.rows}x${matrixB.columns})"
        }
    }

    override val rows = matrixA.rows
    override val columns = matrixA.columns

    override fun get(row: Int, column: Int) = matrixA[row, column] + matrixB[row, column]
}