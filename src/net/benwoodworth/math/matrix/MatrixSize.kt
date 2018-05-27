package net.benwoodworth.math.matrix

sealed class MatrixSize(val size: Int) {

    override fun equals(other: Any?) = this === other

    override fun hashCode() = size

    override fun toString() = "MatrixSize($size)"

    object M0 : MatrixSize(0), GtEq.M0, LtEq.M0
    object M1 : MatrixSize(1), GtEq.M1, LtEq.M1
    object M2 : MatrixSize(2), GtEq.M2, LtEq.M2
    object M3 : MatrixSize(3), GtEq.M3, LtEq.M3
    object M4 : MatrixSize(4), GtEq.M4, LtEq.M4
    object M5 : MatrixSize(5), GtEq.M5, LtEq.M5
    object M6 : MatrixSize(6), GtEq.M6, LtEq.M6
    object M7 : MatrixSize(7), GtEq.M7, LtEq.M7
    object M8 : MatrixSize(8), GtEq.M8, LtEq.M8
    object M9 : MatrixSize(9), GtEq.M9, LtEq.M9

    /**
     * Greater than or equal to.
     */
    sealed class GtEq {
        interface M0
        interface M1 : M0
        interface M2 : M1
        interface M3 : M2
        interface M4 : M3
        interface M5 : M4
        interface M6 : M5
        interface M7 : M6
        interface M8 : M7
        interface M9 : M8
    }

    /**
     * Less than or equal to.
     */
    sealed class LtEq {
        interface M0 : M1
        interface M1 : M2
        interface M2 : M3
        interface M3 : M4
        interface M4 : M5
        interface M5 : M6
        interface M6 : M7
        interface M7 : M8
        interface M8 : M9
        interface M9 /*: M10*/
    }
}
