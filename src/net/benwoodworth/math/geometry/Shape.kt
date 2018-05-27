package net.benwoodworth.math.geometry

interface Shape{

    fun contains(point: Point): Boolean

    fun distance(point: Point): Double
}
