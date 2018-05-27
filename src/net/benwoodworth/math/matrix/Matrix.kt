package net.benwoodworth.math.matrix

@Suppress("unused")
interface Matrix<TRows : MatrixSize, TColumns : MatrixSize> {

    val rows: Int
    val columns: Int

    override fun equals(other: Any?): Boolean

    override fun hashCode(): Int

    override fun toString(): String
}
