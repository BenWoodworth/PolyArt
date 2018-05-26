package net.benwoodworth.math.matrix.operations

import net.benwoodworth.math.matrix.Matrix
import net.benwoodworth.math.matrix.MatrixBase
import net.benwoodworth.math.matrix.MatrixSize

private class ArrayMatrix<TRows : MatrixSize, TColumns : MatrixSize>(
        rows: TRows,
        columns: TColumns,
        private vararg val values: Double
) : MatrixBase<TRows, TColumns>() {

    override val rows = rows.size
    override val columns = columns.size

    override fun get(row: Int, column: Int) = values[row * columns + column]
}

fun <TRows : MatrixSize, TColumns : MatrixSize> matrix(
        rows: TRows,
        columns: TColumns,
        vararg values: Double
): Matrix<TRows, TColumns> {

    return ArrayMatrix(rows, columns, *values)
}

inline fun <reified TRows : MatrixSize, reified TColumns : MatrixSize> matrix(
        vararg values: Double
): Matrix<TRows, TColumns> {

    return matrix(
            TRows::class.objectInstance!!,
            TColumns::class.objectInstance!!,
            *values
    )
}