package me.kcybulski.bricks.kata.algorithms

import arrow.core.Either
import arrow.core.getOrHandle
import me.kcybulski.bricks.game.Algorithm
import me.kcybulski.bricks.game.Block
import me.kcybulski.bricks.game.Brick
import me.kcybulski.bricks.game.DuoBrick
import me.kcybulski.bricks.game.Identity
import me.kcybulski.bricks.game.InvalidBrick
import me.kcybulski.bricks.game.MoveTrigger
import me.kcybulski.bricks.game.NewGame
import me.kcybulski.bricks.test.horizontal

class Inky : Algorithm {

    private var map: Array<Array<Boolean>> = emptyArray()

    override val identity: Identity = Identity("Inky")

    override suspend fun initialize(game: NewGame) {
        map = Array(game.size) { Array(game.size) { false } }
    }

    override suspend fun move(last: MoveTrigger): Brick = when (last) {
        is MoveTrigger.FirstMove -> horizontal(0, 0).get()
        is MoveTrigger.OpponentMoved -> horizontal(0, 0).get()
    }
}


private fun <T> Either<InvalidBrick, T>.get() = getOrHandle { throw IllegalArgumentException() }
