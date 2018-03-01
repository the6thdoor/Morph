package com.morph.engine.math

import java.util.function.Function

class Vector4f {
    var x: Float = 0.toFloat()
    var y: Float = 0.toFloat()
    var z: Float = 0.toFloat()
    var w: Float = 0.toFloat()

    val xyz: Vector3f
        get() = Vector3f(x, y, z)

    val xy: Vector2f
        get() = Vector2f(x, y)

    constructor(x: Float, y: Float, z: Float, w: Float) {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    /**
     * Clones a Vector4f.
     */
    constructor(v: Vector4f) : this(v.x, v.y, v.z, v.w) {}

    /**
     * Creates a new Vector4f from a Vector3f and a supplied z value.
     * @param v Vector3f containing new x and y values.
     */
    @JvmOverloads constructor(v: Vector3f, w: Float = 0f) : this(v.x, v.y, v.z, w) {}

    constructor() {
        this.x = 0f
        this.y = 0f
        this.z = 0f
        this.w = 0f
    }

    constructor(xy: Vector2f, z: Int, w: Int) {
        this.x = xy.x
        this.y = xy.y
        this.z = z.toFloat()
        this.w = w.toFloat()
    }

    override fun toString(): String {
        return "Vector4f($x, $y, $z, $w)"
    }

    fun add(v: Vector4f): Vector4f {
        return Vector4f(x + v.x, y + v.y, z + v.z, w + v.w)
    }

    fun sub(v: Vector4f): Vector4f {
        return Vector4f(x - v.x, y - v.y, z - v.z, w - v.w)
    }

    fun scale(k: Float): Vector4f {
        return Vector4f(x * k, y * k, z * k, w * k)
    }

    fun invScale(k: Float): Vector4f {
        return Vector4f(x / k, y / k, z / k, w / k)
    }

    operator fun set(x: Float, y: Float, z: Float, w: Float) {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    fun set(v: Vector4f) {
        this.x = v.x
        this.y = v.y
        this.z = v.z
        this.w = v.w
    }

    fun map(`fun`: Function<Float, Float>): Vector4f {
        return Vector4f(`fun`.apply(x), `fun`.apply(y), `fun`.apply(z), `fun`.apply(w))
    }
}
/**
 * Creates a new Vector4f from a Vector3f by using the x and y values of the Vector3f.
 * @param v Vector3f containing new x and y values.
 */