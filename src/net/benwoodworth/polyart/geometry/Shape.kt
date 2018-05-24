package net.benwoodworth.polyart.geometry

import kotlin.math.sqrt

interface Shape{

    fun contains(point: Point): Boolean

    fun distance(point: Point): Double
}