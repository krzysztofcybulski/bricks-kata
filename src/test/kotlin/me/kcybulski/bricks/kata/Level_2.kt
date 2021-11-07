package me.kcybulski.bricks.kata

import io.kotest.core.spec.style.FunSpec
import me.kcybulski.bricks.game.vs
import me.kcybulski.bricks.kata.algorithms.Blinky
import me.kcybulski.bricks.test.assertions.GameAssertions.Companion.assertThat

class Level_2 : FunSpec({

    val myAlgorithm = MyBricksAlgorithm()

    test("Win with Blinky") {
        assertThat(play(myAlgorithm vs Blinky()))
            .wonBy(myAlgorithm.identity)
    }

})
