package me.kcybulski.bricks.kata.algorithms

import me.kcybulski.bricks.api.Algorithm
import me.kcybulski.bricks.api.Brick
import me.kcybulski.bricks.api.GameInitialized
import me.kcybulski.bricks.api.Identity
import me.kcybulski.bricks.api.MoveTrigger
import me.kcybulski.bricks.test.horizontal
import me.kcybulski.bricks.test.vertical

class Inky : Algorithm {

    private var emptyPlaces: MutableList<Brick> = mutableListOf()

    override val identity: Identity = Identity("Inky")

    override suspend fun initialize(gameInitialized: GameInitialized) {
        (0 until gameInitialized.size - 1)
            .forEach { y ->
                (0 until gameInitialized.size - 1).forEach { x ->
                    horizontal(x, y).also { emptyPlaces += it }
                    vertical(x, y).also { emptyPlaces += it }
                }
            }
        emptyPlaces = emptyPlaces.shuffled().toMutableList()
    }

    override suspend fun move(last: MoveTrigger): Brick {
        if (last is MoveTrigger.OpponentMoved) {
            removeEveryWith(last.brick)
        }
        return emptyPlaces
            .firstOrNull()
            ?.also(this::removeEveryWith)
            ?: horizontal(0, 0)
    }

    private fun removeEveryWith(brick: Brick) {
        emptyPlaces.removeIf { b -> b.blocks.any { it in brick.blocks } }
    }
}
