package net.benwoodworth.math.matrix.implementations

import net.benwoodworth.math.matrix.Matrix
import net.benwoodworth.math.matrix.MatrixSize
import net.benwoodworth.math.matrix.operations.MatrixMultiplier
import net.benwoodworth.math.matrix.operations.MatrixProduct
import net.benwoodworth.math.matrix.operations.MatrixSum
import net.benwoodworth.math.matrix.operations.MatrixTranspose

internal abstract class MatrixBase<TRows : MatrixSize, TColumns : MatrixSize> : Matrix<TRows, TColumns> {

    override val transposed: Matrix<TColumns, TRows> by lazy { MatrixTranspose(this) }

    override fun plus(matrix: Matrix<TRows, TColumns>): Matrix<TRows, TColumns> {
        return MatrixSum(this, matrix)
    }

    override fun minus(matrix: Matrix<TRows, TColumns>): Matrix<TRows, TColumns> {
        return MatrixSum(this, -matrix)
    }

    override fun <TNewColumns : MatrixSize> times(matrix: Matrix<TColumns, TNewColumns>): Matrix<TRows, TNewColumns> {
        return MatrixProduct(this, matrix)
    }

    override fun <TNewColumns : MatrixSize> invoke(matrix: Matrix<TColumns, TNewColumns>): Matrix<TRows, TNewColumns> {
        return MatrixProduct(this, matrix)
    }

    override fun times(multiplier: Double): Matrix<TRows, TColumns> {
        return MatrixMultiplier(this, multiplier)
    }

    override fun Double.times(matrix: Matrix<TRows, TColumns>): Matrix<TRows, TColumns> { //TODO Accessible?
        return MatrixMultiplier(matrix, this)
    }

    override fun div(divisor: Double): Matrix<TRows, TColumns> {
        return MatrixMultiplier(this, 1.0 / divisor)
    }

    override fun unaryPlus(): Matrix<TRows, TColumns> {
        return this
    }

    override fun unaryMinus(): Matrix<TRows, TColumns> {
        return MatrixMultiplier(this, -1.0)
    }

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