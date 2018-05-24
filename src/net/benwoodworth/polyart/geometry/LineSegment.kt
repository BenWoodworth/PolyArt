package net.benwoodworth.polyart.geometry

data class LineSegment(
        val point0: Point,
        val point1: Point
) : Shape{

    override fun contains(point: Point): Boolean {
        if (point == point0) return true
        if (point == point1) return true


    }
}