package net.benwoodworth.math.matrix.operations

import net.benwoodworth.math.matrix.Matrix
import net.benwoodworth.math.matrix.MatrixSize

private class MatrixMultiplier<TRows : MatrixSize, TColumns : MatrixSize>(
        val backingMatrix: Matrix<TRows, TColumns>,
        val multiplier: Double
) : Matrix<TRows, TColumns> {

    override val rows = backingMatrix.rows
    override val columns = backingMatrix.columns

    override fun get(row: Int, column: Int) = backingMatrix[row, column] * multiplier
}

operator fun <TRows : MatrixSize, TColumns : MatrixSize>
        Matrix<TRows, TColumns>.times(multiplier: Double): Matrix<TRows, TColumns> {
    return when {
        this is MatrixMultiplier<TRows, TColumns> ->
            MatrixMultiplier(this.backingMatrix, this.multiplier * multiplier)

        else -> MatrixMultiplier(this, multiplier)
    }
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun <TRows : MatrixSize, TColumns : MatrixSize>
        Double.times(matrix: Matrix<TRows, TColumns>) = matrix * this

@Suppress("NOTHING_TO_INLINE")
inline operator fun <TRows : MatrixSize, TColumns : MatrixSize>
        Matrix<TRows, TColumns>.div(divisor: Double) = this * (1.0 / divisor)

@Suppress("NOTHING_TO_INLINE")
inline operator fun <TRows : MatrixSize, TColumns : MatrixSize>
        Matrix<TRows, TColumns>.unaryPlus() = this

@Suppress("NOTHING_TO_INLINE")
inline operator fun <TRows : MatrixSize, TColumns : MatrixSize>
        Matrix<TRows, TColumns>.unaryMinus() = this * -1.0