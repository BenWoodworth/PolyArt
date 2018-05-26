package net.benwoodworth.polyart

import net.benwoodworth.math.matrix.MatrixSize.*
import net.benwoodworth.math.matrix.matrix

fun main(args: Array<String>) {
    val a = matrix<M3, M3>(
            1.0, 2.0, 3.0,
            4.0, 5.0, 6.0,
            7.0, 8.0, 9.0
    )

    val b = matrix<M3, M3>(
            5.0, 2.0, 3.0,
            4.0, 5.0, 5.0,
            6.0, 8.0, 7.0
    )

    val c = matrix<M3, M3>(
            2.0, 2.0, 3.0,
            4.0, 5.0, 7.0,
            7.0, 2.0, 9.0
    )

    val point = matrix<M3, M1>(
            2.0,
            3.0,
            1.0
    )

    println(
            3.0 * a * 3.0 * b * c * point
    )
}