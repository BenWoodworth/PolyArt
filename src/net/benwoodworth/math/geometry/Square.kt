package net.benwoodworth.math.geometry

import java.lang.Math.sqrt

data class Square(
        val location: Point,
        val size: Double
) : Polygon {

    init {
        assert(size >= 0) { "Size must be positive" }
    }

    override val vertices = listOf(
            location,
            location.offset(dy = size),
            location.offset(dx = size, dy = size),
            location.offset(dx = size)
    )

    override fun contains(point: Point): Boolean {
        val relativeX = point.x - location.x
        val relativeY = point.y - location.y

        return relativeX in 0.0..size && relativeY in 0.0..size
    }

    override fun distance(point: Point): Double {
        val left = location.x - point.x
        val right = point.x - (location.x + size)
        val above = point.y - (location.y + size)
        val below = location.y - point.y

        fun diagonal(a: Double, b: Double) = sqrt(a * a + b * b)

        return when {
            left > 0 -> when {
                above > 0 -> diagonal(left, above)
                below > 0 -> diagonal(left, below)
                else -> left
            }
            right > 0 -> when {
                above > 0 -> diagonal(right, above)
                below > 0 -> diagonal(right, below)
                else -> right
            }
            else -> when {
                above > 0 -> above
                below > 0 -> below
                else -> 0.0
            }
        }
    }
}