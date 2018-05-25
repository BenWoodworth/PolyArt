package net.benwoodworth.polyart.matrices

abstract class MatrixBase<TValue, TRows : MatrixSize, TColumns : MatrixSize>(
        override val rows: TRows,
        override val columns: TColumns,
        private vararg val values: TValue
) : Matrix<TValue, TRows, TColumns> {

    init {
        assert(values.size == rows.size * columns.size) {
            "Number of values (${values.size}) must equal rows*columns (${rows.size * columns.size})"
        }
    }

    override fun get(row: Int, column: Int) = values[column + columns.size * row]

    protected abstract operator fun TValue.plus(value: TValue): TValue
    protected abstract operator fun TValue.times(value: TValue): TValue

    protected abstract fun createMatrix<TNewRows : MatrixSize, TNewColumns : MatrixSize>(
            rows: TNewRows,
            columns: TNewColumns,
            crossinline values: (TValue) -> TValue){
        return Matrix
    }

    override fun equals(other: Any?): Boolean {
        when {
            other == this -> return true
            other !is Matrix<*, *, *> -> return false
            other.rows != rows -> return false
            other.columns != columns -> return false
            else -> {
                for (row in 0 until rows.size) {
                    for (column in 0 until columns.size) {
                        if (this[row, column] != other[row, column]) {
                            return false
                        }
                    }
                }

                return true
            }
        }
    }

    override fun hashCode() = values.fold(31) { accumulated, value ->
        accumulated * 37 + (value?.hashCode() ?: 0)
    }

    override fun toString() = values.asSequence()
            .map { it.toString() }
            .windowed(columns.size)
            .map { "[${it.joinToString { ", " }}]" }
            .let { "[${it.joinToString { ", " }}]" }
}