package net.benwoodworth.polyart.geometry

import java.lang.Math.sqrt
import kotlin.math.abs

data class Point(
        val x: Double,
        val y: Double
) : Shape {

    fun offset(dx: Double = 0.0, dy: Double = 0.0): Point {
        return when {
            (dx == 0.0) && (dy == 0.0) -> this
            else -> Point(x + dx, y + dy)
        }
    }

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