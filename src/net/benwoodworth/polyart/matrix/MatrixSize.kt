package net.benwoodworth.polyart.matrix

sealed class MatrixSize(val size: Int) {

    override fun equals(other: Any?) = this === other

    override fun hashCode() = size

    override fun toString() = "MatrixSize($size)"

    object M0 : MatrixSize(0)
    object M1 : MatrixSize(1)
    object M2 : MatrixSize(2)
    object M3 : MatrixSize(3)
    object M4 : MatrixSize(4)
    object M5 : MatrixSize(5)
    object M6 : MatrixSize(6)
    object M7 : MatrixSize(7)
    object M8 : MatrixSize(8)
    object M9 : MatrixSize(9)

    object M10 : MatrixSize(10)
    object M11 : MatrixSize(11)
    object M12 : MatrixSize(12)
    object M13 : MatrixSize(13)
    object M14 : MatrixSize(14)
    object M15 : MatrixSize(15)
    object M16 : MatrixSize(16)
    object M17 : MatrixSize(17)
    object M18 : MatrixSize(18)
    object M19 : MatrixSize(19)

    object M20 : MatrixSize(20)
    object M21 : MatrixSize(21)
    object M22 : MatrixSize(22)
    object M23 : MatrixSize(23)
    object M24 : MatrixSize(24)
    object M25 : MatrixSize(25)
    object M26 : MatrixSize(26)
    object M27 : MatrixSize(27)
    object M28 : MatrixSize(28)
    object M29 : MatrixSize(29)

    object M30 : MatrixSize(30)
    object M31 : MatrixSize(31)
    object M32 : MatrixSize(32)
    object M33 : MatrixSize(33)
    object M34 : MatrixSize(34)
    object M35 : MatrixSize(35)
    object M36 : MatrixSize(36)
    object M37 : MatrixSize(37)
    object M38 : MatrixSize(38)
    object M39 : MatrixSize(39)

    object M40 : MatrixSize(40)
    object M41 : MatrixSize(41)
    object M42 : MatrixSize(42)
    object M43 : MatrixSize(43)
    object M44 : MatrixSize(44)
    object M45 : MatrixSize(45)
    object M46 : MatrixSize(46)
    object M47 : MatrixSize(47)
    object M48 : MatrixSize(48)
    object M49 : MatrixSize(49)
}