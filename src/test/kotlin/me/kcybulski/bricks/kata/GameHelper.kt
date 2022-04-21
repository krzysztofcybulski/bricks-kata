package me.kcybulski.bricks.kata

import me.kcybulski.bricks.client.UserAlgorithm
import me.kcybulski.bricks.events.EventBus
import me.kcybulski.bricks.game.AlgorithmsPair
import me.kcybulski.bricks.game.EndedGame
import me.kcybulski.bricks.game.GameCoordinator
import me.kcybulski.bricks.game.GameSettings
import me.kcybulski.bricks.game.GamesFactory
import me.kcybulski.bricks.test.assertions.GameAssertions

private val settings = GameSettings(
    initTime = 1000L,
    moveTime = 100L,
    randomBrickChance = 0.0
)

suspend fun play(algorithms: AlgorithmsPair): EndedGame = GameCoordinator(
    algorithms,
    settings,
    GamesFactory(settings),
    EventBus()
)
    .play(algorithms.first.identity, 11)

fun GameAssertions.wonBy(algorithm: UserAlgorithm) = wonBy(algorithm.identity.name)
