package me.kcybulski.bricks.kata.algorithms

import me.kcybulski.bricks.api.Algorithm
import me.kcybulski.bricks.api.Block
import me.kcybulski.bricks.api.Brick
import me.kcybulski.bricks.api.GameInitialized
import me.kcybulski.bricks.api.Identity
import me.kcybulski.bricks.api.MoveTrigger
import me.kcybulski.bricks.test.horizontal

class Blinky : Algorithm {

    private var map: Array<Array<Boolean>> = emptyArray()

    override val identity: Identity = Identity("Blinky")

    override suspend fun initialize(game: GameInitialized) {
        map = Array(game.size) { Array(game.size) { false } }
    }

    override suspend fun move(last: MoveTrigger): Brick = when (last) {
        is MoveTrigger.FirstMove -> horizontal(0, 0)
            .also(this::save)
        is MoveTrigger.OpponentMoved -> {
            save(last.brick)
            findEmpty(horizontal(0, 0))
                .also(this::save)
        }
    }

    private fun save(brick: Brick) {
        brick.blocks.forEach { map[it.y][it.x] = true }
    }

    private fun findEmpty(brick: Brick): Brick = when {
        brick.blocks.all { isEmpty(it) } -> brick
        brick.blocks.any { it.x >= map.size } -> findEmpty(horizontal(0, brick.blocks.first().y + 1))
        brick.blocks.any { it.y >= map.size } -> horizontal(0, 0)
        else -> findEmpty(horizontal(brick.blocks.first().x + 2, brick.blocks.first().y))
    }

    private fun isEmpty(block: Block) = when {
        block.y >= map.size || block.x >= map[0].size -> false
        !map[block.y][block.x] -> true
        else -> false
    }

}
