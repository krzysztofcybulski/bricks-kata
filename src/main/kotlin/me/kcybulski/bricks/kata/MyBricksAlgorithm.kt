package me.kcybulski.bricks.kata

import arrow.core.getOrHandle
import me.kcybulski.bricks.game.Algorithm
import me.kcybulski.bricks.game.Block
import me.kcybulski.bricks.game.Brick
import me.kcybulski.bricks.game.DuoBrick
import me.kcybulski.bricks.game.Identity
import me.kcybulski.bricks.game.MoveTrigger
import me.kcybulski.bricks.game.NewGame

class MyBricksAlgorithm : Algorithm {
    override val identity: Identity = Identity.default()

    override suspend fun initialize(game: NewGame) {
    }

    override suspend fun move(last: MoveTrigger): Brick =
        DuoBrick.of(
            Block(0, 0),
            Block(1, 0)
        ).getOrHandle { throw IllegalArgumentException() }

}
