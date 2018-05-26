package net.benwoodworth.math.matrix.operations

import net.benwoodworth.math.matrix.Matrix
import net.benwoodworth.math.matrix.implementations.MatrixBase
import net.benwoodworth.math.matrix.MatrixSize

internal class MatrixTranspose<TRows : MatrixSize, TColumns : MatrixSize>(
        private val backingMatrix: Matrix<TColumns, TRows>
) : MatrixBase<TRows, TColumns>() {

    override val rows = backingMatrix.rows
    override val columns = backingMatrix.columns

    override fun get(row: Int, column: Int) = backingMatrix[column, row]
}