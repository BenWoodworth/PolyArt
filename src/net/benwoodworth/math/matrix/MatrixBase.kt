package net.benwoodworth.math.matrix

internal abstract class MatrixBase<TRows : MatrixSize, TColumns : MatrixSize> : Matrix<TRows, TColumns> {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Matrix<*, *>) return false

        if (rows != other.rows) return false
        if (columns != other.columns) return false

        return contentEquals(other)
    }

    protected open fun contentEquals(other: Matrix<*, *>): Boolean {
        for (row in 0 until rows) {
            for (column in 0 until columns) {
                if (this[row, column] != other[row, column]) {
                    return false
                }
            }
        }

        return true
    }

    override fun hashCode(): Int {
        var result = 37

        result = result * 23 + rows
        result = result * 23 + columns

        for (row in 0 until rows) {
            for (column in 0 until columns) {
                result = result * 31 + this[row, column].hashCode()
            }
        }

        return result
    }

    override fun toString() = StringBuilder().run {
        append('{')
        for (row in 0 until rows) {
            if (row != 0) append(", ")

            append('{')
            for (column in 0 until columns) {
                if (column != 0) append(", ")

                append(this@MatrixBase[row, column])
            }
            append('}')
        }
        append('}')

        return@run toString()
    }
}