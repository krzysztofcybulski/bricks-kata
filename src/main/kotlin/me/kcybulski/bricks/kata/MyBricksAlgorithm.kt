package me.kcybulski.bricks.kata

import me.kcybulski.bricks.api.Block
import me.kcybulski.bricks.api.Brick
import me.kcybulski.bricks.api.DuoBrick
import me.kcybulski.bricks.client.UserArrayMapAlgorithm

class MyBricksAlgorithm : UserArrayMapAlgorithm() {

    override suspend fun move(map: Array<Array<MapField>>): Brick {
        return DuoBrick.unsafe(
            Block(1, 1),
            Block(2, 1)
        )
    }

}
