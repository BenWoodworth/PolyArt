package net.benwoodworth.math.geometry

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
}