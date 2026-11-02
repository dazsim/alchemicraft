# Alchemicraft

A magic mod for Minecraft, built from one codebase for 1.20.1 (Forge, Fabric), 1.21.1 (NeoForge, Fabric) and 26.1.2, 26.2, 26.3 (NeoForge, Fabric). Still in design, nothing playable yet.

## Building

The build uses [Stonecutter](https://stonecutter.kikugie.dev/) to produce every Minecraft version and loader from the same source. Version specific values are in `stonecutter.properties.toml`.

Run `./gradlew build` with JDK 25 (Gradle fetches JDK 17 and 21 toolchains as needed). Jars end up in `versions/<version>-<loader>/build/libs/`.
