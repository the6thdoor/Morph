#version 330
in vec4 fragColor;
in vec2 textureCoord;
out vec4 color;
uniform sampler2D diffuse;
uniform vec4 diffuseColor;

void main() {
    vec4 texColor = texture2D(diffuse, textureCoord.st);
    color = fragColor * texColor * diffuseColor;
}
