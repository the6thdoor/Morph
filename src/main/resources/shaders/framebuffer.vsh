#version 330
layout(location = 0) in vec3 position;
layout(location = 1) in vec2 texCoord;

out vec2 textureCoord;

void main() {
  gl_Position = vec4(position, 1);
  textureCoord = texCoord;
}
