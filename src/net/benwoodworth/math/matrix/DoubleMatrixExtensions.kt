package net.benwoodworth.math.matrix

inline fun <reified TRows : MatrixSize, reified TColumns : MatrixSize> matrixOf(
        vararg values: Double
): DoubleMatrix<TRows, TColumns> {
    return DoubleMatrix(
            TRows::class.objectInstance!!,
            TColumns::class.objectInstance!!,
            *values
    )
}

inline fun <reified TRows : MatrixSize, reified TColumns : MatrixSize> matrixOf(
        initializer: (row: Int, column: Int) -> Double
): DoubleMatrix<TRows, TColumns> {
    val rows = TRows::class.objectInstance!!
    val columns = TColumns::class.objectInstance!!

    return DoubleMatrix(
            rows,
            columns,
            *DoubleArray(rows.size * columns.size) { i ->
                initializer(i / columns.size, i % columns.size)
            }
    )
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun <TRows : MatrixSize, TColumns : MatrixSize> Double.times(
        matrix: DoubleMatrix<TRows, TColumns>
): DoubleMatrix<TRows, TColumns> {
    return matrix * this
}