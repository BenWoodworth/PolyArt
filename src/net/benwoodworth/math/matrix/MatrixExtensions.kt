package net.benwoodworth.math.matrix

import net.benwoodworth.math.matrix.implementations.ArrayMatrix

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

@Suppress("NOTHING_TO_INLINE")
inline operator fun <TRows:MatrixSize, TColumns:MatrixSize> Double.times(
        matrix: Matrix<TRows, TColumns>
): Matrix<TRows, TColumns> {
    return matrix * this
}