package net.benwoodworth.math.geometry

import kotlin.math.atan2
import kotlin.math.cos

data class LineSegment(
        val point0: Point,
        val point1: Point
) : Shape {

    val length = point0.distance(point1)

    val angle = atan2(
            x = point1.x - point0.x,
            y = point1.y - point0.y
    )

    override fun contains(point: Point): Boolean {
        if (point == point0) return true
        if (point == point1) return true

        TODO()
    }

    override fun distance(point: Point): Double {
        if (length == 0.0) {
            return point0.distance(point)
        }

        var relativeX = point.x
        var relativeY = point.y

        // Align point0 to origin
        val translatedX = point.x - point0.x
        val translatedY = point.y - point0.y


        // Rotate point1 to y=0
        //val rotatedX = translatedX * cos(-angle) + translatedY *
        TODO()
    }
}