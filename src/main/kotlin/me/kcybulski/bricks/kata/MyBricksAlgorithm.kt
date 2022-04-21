package me.kcybulski.bricks.kata

import me.kcybulski.bricks.client.UserAlgorithm
import me.kcybulski.bricks.api.Block
import me.kcybulski.bricks.api.Brick
import me.kcybulski.bricks.api.DuoBrick
import me.kcybulski.bricks.api.GameInitialized
import me.kcybulski.bricks.api.MoveTrigger

class MyBricksAlgorithm : UserAlgorithm() {

    override suspend fun initialize(gameInitialized: GameInitialized) {
    }

    override suspend fun firstMove(): Brick {
        return DuoBrick.unsafe(Block(0, 0), Block(1, 0))
    }

    override suspend fun move(opponentMoved: MoveTrigger.OpponentMoved): Brick {
        return DuoBrick.unsafe(Block(0, 1), Block(1, 1))
    }

}
