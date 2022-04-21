package me.kcybulski.bricks.kata.algorithms

import me.kcybulski.bricks.api.Algorithm
import me.kcybulski.bricks.api.Block
import me.kcybulski.bricks.api.Brick
import me.kcybulski.bricks.api.DuoBrick
import me.kcybulski.bricks.api.GameInitialized
import me.kcybulski.bricks.api.Identity
import me.kcybulski.bricks.api.MoveTrigger
import me.kcybulski.bricks.test.horizontal

class Clyde : Algorithm {

    private var size = 0

    override val identity: Identity = Identity("Clyde")

    override suspend fun initialize(game: GameInitialized) {
        size = game.size
    }

    override suspend fun move(last: MoveTrigger): Brick = when (last) {
        is MoveTrigger.FirstMove -> horizontal(0, 0)
        is MoveTrigger.OpponentMoved -> move(last)
    }

    private fun move(last: MoveTrigger.OpponentMoved): Brick =
        DuoBrick.unsafe(last.brick.blocks.first().opposite(), last.brick.blocks[1].opposite())

    private fun Block.opposite() = Block(
        x = size - x - 1,
        y = size - y - 1
    )
}
