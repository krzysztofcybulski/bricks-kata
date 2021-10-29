rootProject.name = "bricks-kata"

sourceControl {
    gitRepository(java.net.URI("https://github.com/krzysztofcybulski/bricks.git")) {
        producesModule("me.kcybulski.bricks:game")
    }
}
