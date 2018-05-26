package net.benwoodworth.math.geometry

data class Triangle(
        val vertex0: Point,
        val vertex1: Point,
        val vertex2: Point
) : Polygon {

    override val vertices = listOf(
            vertex0,
            vertex1,
            vertex2
    )

    override fun contains(point: Point): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun distance(point: Point): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}