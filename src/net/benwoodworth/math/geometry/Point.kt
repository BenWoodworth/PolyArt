package net.benwoodworth.math.geometry

import net.benwoodworth.math.matrix.DoubleMatrix
import net.benwoodworth.math.matrix.MatrixSize
import net.benwoodworth.math.matrix.MatrixSize.*
import net.benwoodworth.math.matrix.matrixOf
import java.lang.Math.sqrt
import kotlin.math.abs

data class Point(
        val x: Double,
        val y: Double
) : Shape {

    override fun contains(point: Point) = this == point

    override fun distance(point: Point): Double {
        val dx = x - point.x
        val dy = y - point.y

        return when {
            dx == 0.0 -> dy
            dy == 0.0 -> dx
            dx == dy -> abs(dx) * sqrt(2.0)

            else -> sqrt((dx * dx) + (dy * dy))
        }
    }

    fun linearTransform(matrix: DoubleMatrix<M2, M2>): Point {
        return (matrix * matrixOf<M2, M1>(x, y)).let {
            Point(it[0, 0], it[1, 0])
        }
    }

    fun affineTransform(matrix: DoubleMatrix<M3, M3>): Point {
        return (matrix * matrixOf<M3, M1>(x, y)).let {
            Point(it[0, 0], it[1, 0])
        }
    }
}

@Suppress("UNCHECKED_CAST")
operator fun <TSize> DoubleMatrix<TSize, TSize>.times(point: Point): Point
        where TSize : MatrixSize,
              TSize : MatrixSize.GtEq.M2,
              TSize : MatrixSize.LtEq.M3 {

    return if (rows == 2) {
        point.linearTransform(this as DoubleMatrix<M2, M2>)
    } else {
        point.affineTransform(this as DoubleMatrix<M3, M3>)
    }
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun <TSize> DoubleMatrix<TSize, TSize>.invoke(point: Point): Point
        where TSize : MatrixSize,
              TSize : MatrixSize.GtEq.M2,
              TSize : MatrixSize.LtEq.M3 {

    return this * point
}
