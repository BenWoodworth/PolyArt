package net.benwoodworth.polyart.matrices

class DoubleMatrix<TRows : MatrixSize, TColumns : MatrixSize>(rows: TRows, columns: TColumns, vararg values: Double) : MatrixBase<Double, TRows, TColumns>(rows, columns, *values.toTypedArray()) {

    override fun TValue.plus(value: TValue): TValue {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun plus(matrix: Matrix<TValue, TRows, TColumns>): Matrix<TValue, TRows, TColumns> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun TValue.times(value: TValue): TValue {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun times(value: TValue): Matrix<TValue, TRows, TColumns> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}