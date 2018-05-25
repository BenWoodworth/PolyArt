package net.benwoodworth.polyart.matrices

interface Matrix<TValue, TRows : MatrixSize, TColumns : MatrixSize> {

    val rows: TRows
    val columns: TColumns

    val determinant: TValue

    val transpose: Matrix<TValue, TColumns, TRows>

    operator fun get(row: Int, column: Int): TValue

    fun <TArgColumns : MatrixSize> dot(
            matrix: Matrix<TValue, TColumns, TArgColumns>
    ): Matrix<TValue, TRows, TArgColumns>

    operator fun plus(matrix: Matrix<TValue, TRows, TColumns>): Matrix<TValue, TRows, TColumns>

    operator fun times(value: TValue): Matrix<TValue, TRows, TColumns>

    operator fun unaryPlus(): Matrix<TValue, TRows, TColumns>

    operator fun unaryMinus(): Matrix<TValue, TRows, TColumns>

    companion object {
        fun create<TValue, TRows, TColumns>(
                rows: TRows,
                columns: TColumns,
                vararg values: TValue
        ){
            return
        }
    }
}
