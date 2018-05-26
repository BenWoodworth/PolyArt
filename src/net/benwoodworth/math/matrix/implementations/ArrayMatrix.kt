package net.benwoodworth.math.matrix.implementations

import net.benwoodworth.math.matrix.MatrixSize

internal class ArrayMatrix<TRows : MatrixSize, TColumns : MatrixSize>(
        rows: TRows,
        columns: TColumns,
        private vararg val values: Double
) : MatrixBase<TRows, TColumns>() {

    override val rows = rows.size
    override val columns = columns.size

    override fun get(row: Int, column: Int) = values[row * columns + column]
}