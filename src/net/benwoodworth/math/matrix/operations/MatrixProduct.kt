package net.benwoodworth.math.matrix.operations

import net.benwoodworth.math.matrix.Matrix
import net.benwoodworth.math.matrix.implementations.MatrixBase
import net.benwoodworth.math.matrix.MatrixSize

internal class MatrixProduct<TRows : MatrixSize, TMatching : MatrixSize, TColumns : MatrixSize>(
        private val matrixA: Matrix<TRows, TMatching>,
        private val matrixB: Matrix<TMatching, TColumns>
) : MatrixBase<TRows, TColumns>() {

    init {
        require(matrixA.columns == matrixB.rows) {
            "The number of columns in matrixA (${matrixA.columns}) " +
                    "must equal the number of rows in matrixB (${matrixB.rows})."
        }
    }

    override val rows = matrixA.rows
    override val columns = matrixB.columns

    val values = DoubleArray(rows * columns)
    val valuesLoaded = BooleanArray(values.size)

    override fun get(row: Int, column: Int): Double {
        val valueIndex = row * columns + column

        if (valuesLoaded[valueIndex]) {
            return values[valueIndex]
        }

        var result = 0.0
        for (i in 0 until matrixA.columns) {
            val a = matrixA[row, i]
            if (a == 0.0) continue

            val b = matrixB[i, column]
            result += a * b
        }

        values[valueIndex] = result
        valuesLoaded[valueIndex] = true

        return result
    }
}

