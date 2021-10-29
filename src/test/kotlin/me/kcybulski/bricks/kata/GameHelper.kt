package me.kcybulski.bricks.kata

import me.kcybulski.bricks.game.AlgorithmsPair
import me.kcybulski.bricks.game.EndedGame
import me.kcybulski.bricks.game.GameCoordinator
import me.kcybulski.bricks.game.GameSettings

suspend fun play(algorithms: AlgorithmsPair): EndedGame = GameCoordinator(
    algorithms,
    GameSettings(1000L, 100L)
)
    .play(algorithms.first.identity, 5)
