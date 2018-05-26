package net.benwoodworth.math.matrix.operations

import net.benwoodworth.math.matrix.Matrix
import net.benwoodworth.math.matrix.MatrixSize

private class MatrixTransposed<TRows : MatrixSize, TColumns : MatrixSize>(
        val backingMatrix: Matrix<TColumns, TRows>
) : Matrix<TRows, TColumns> {

    override val rows = backingMatrix.rows
    override val columns = backingMatrix.columns

    override fun get(row: Int, column: Int) = backingMatrix[column, row]
}

val <TRows : MatrixSize, TColumns : MatrixSize> Matrix<TRows, TColumns>.transposed: Matrix<TColumns, TRows>
        get() = when(this){
            is MatrixTransposed<TRows, TColumns> -> this.backingMatrix
            else -> MatrixTransposed(this)
        }