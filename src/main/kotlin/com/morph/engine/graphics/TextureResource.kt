package com.morph.engine.graphics

import org.lwjgl.opengl.GL11.glDeleteTextures

class TextureResource(val id: Int) {
    private var count: Int = 0

    fun finalize() {
        glDeleteTextures(id)
    }

    fun addReference() {
        count++
    }

    fun removeReference(): Boolean {
        count--
        return count == 0
    }
}
