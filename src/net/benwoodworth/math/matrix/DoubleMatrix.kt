package net.benwoodworth.math.matrix

class DoubleMatrix<TRows : MatrixSize, TColumns : MatrixSize> private constructor(
        override val rows: Int,
        override val columns: Int,
        private vararg val values: Double
) : Matrix<TRows, TColumns> {
    init {
        require(values.size == this.rows * this.columns) {
            "Number of values must equal rows*columns"
        }
    }

    constructor(rows: MatrixSize, columns: MatrixSize, vararg values: Double) : this(rows.size, columns.size, *values)

    private inline fun <TRows : MatrixSize, TColumns : MatrixSize> create(
            rows: Int,
            columns: Int,
            init: (i: Int) -> Double
    ): DoubleMatrix<TRows, TColumns> {
        return DoubleMatrix(rows, columns, *DoubleArray(rows * columns) { init(it) })
    }

    private inline fun <TRows : MatrixSize, TColumns : MatrixSize> create(
            rows: Int,
            columns: Int,
            init: (row: Int, column: Int) -> Double
    ): DoubleMatrix<TRows, TColumns> {
        return create(rows, columns) { i -> init(i / columns, i % columns) }
    }

    val transpose: DoubleMatrix<TColumns, TRows> by lazy {
        create<TColumns, TRows>(columns, rows) { row, column ->
            this[column, row]
        }
    }

    operator fun get(row: Int, column: Int) = values[row * columns + column]

    operator fun plus(matrix: DoubleMatrix<TRows, TColumns>): DoubleMatrix<TRows, TColumns> {
        return create(rows, columns) { i ->
            values[i] + matrix.values[i]
        }
    }

    operator fun minus(matrix: DoubleMatrix<TRows, TColumns>): DoubleMatrix<TRows, TColumns> {
        return create(rows, columns) { i ->
            values[i] + matrix.values[i]
        }
    }

    operator fun <TNewColumns : MatrixSize> times(matrix: DoubleMatrix<TColumns, TNewColumns>): DoubleMatrix<TRows, TNewColumns> {
        return create(rows, matrix.columns) { row, column ->
            var result = 0.0
            for (i in 0 until columns) {
                result += this[row, i] * matrix[i, column]
            }
            result
        }
    }

    @Suppress("NOTHING_TO_INLINE")
    inline operator fun <TNewColumns : MatrixSize> invoke(matrix: DoubleMatrix<TColumns, TNewColumns>): DoubleMatrix<TRows, TNewColumns> {
        return this * matrix
    }

    operator fun times(multiplier: Double): DoubleMatrix<TRows, TColumns> {
        return create(rows, columns) { i ->
            values[i] * multiplier
        }
    }

    operator fun div(divisor: Double): DoubleMatrix<TRows, TColumns> {
        return create(rows, columns) { i ->
            values[i] * divisor
        }
    }

    @Suppress("NOTHING_TO_INLINE")
    inline operator fun unaryPlus() = this

    operator fun unaryMinus(): DoubleMatrix<TRows, TColumns> {
        return create(rows, columns) { i ->
            -values[i]
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DoubleMatrix<*, *>) return false

        if (rows != other.rows) return false
        if (columns != other.columns) return false

        for (i in values.indices) {
            if (values[i] != other.values[i]) {
                return false
            }
        }

        return true
    }

    override fun hashCode(): Int {
        var result = 31

        result = result * 17 + rows
        result = result * 17 + columns

        values.forEach { value ->
            result = result * 23 + value.hashCode()
        }

        return result
    }

    override fun toString(): String {
        val builder = StringBuilder()

        builder.append('{')
        for (row in 0 until rows) {
            if (row > 0) builder.append(", ")

            builder.append('{')
            for (column in 0 until columns) {
                if (column > 0) builder.append(", ")

                builder.append(this[row, column])
            }
            builder.append('}')
        }
        builder.append('}')

        return builder.toString()
    }
}