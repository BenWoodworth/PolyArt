package net.benwoodworth.math.matrix.operations

import net.benwoodworth.math.matrix.Matrix
import net.benwoodworth.math.matrix.MatrixSize

@Suppress("UNCHECKED_CAST")
private class MatrixProduct<TRows : MatrixSize, TMatching : MatrixSize, TColumns : MatrixSize>(
        private val matrixA: Matrix<TRows, TMatching>,
        private val matrixB: Matrix<TMatching, TColumns>
) : Matrix<TRows, TColumns> {

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

operator fun <TRows : MatrixSize, TMatching : MatrixSize, TColumns : MatrixSize> Matrix<TRows, TMatching>.times(
        matrix: Matrix<TMatching, TColumns>
): Matrix<TRows, TColumns> {
    return MatrixProduct(this, matrix)
}

operator fun <TRows : MatrixSize, TMatching : MatrixSize, TColumns : MatrixSize> Matrix<TRows, TMatching>.invoke(
        matrix: Matrix<TMatching, TColumns>
): Matrix<TRows, TColumns> {
    return MatrixProduct(this, matrix)
}

