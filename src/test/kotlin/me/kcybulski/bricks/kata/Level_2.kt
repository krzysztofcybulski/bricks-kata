package me.kcybulski.bricks.kata

import io.kotest.core.spec.style.FunSpec
import me.kcybulski.bricks.game.vs
import me.kcybulski.bricks.kata.algorithms.Clyde
import me.kcybulski.bricks.test.assertions.GameAssertions.Companion.assertThat

class Level_2 : FunSpec({

    val myAlgorithm = MyBricksAlgorithm()

    test("Win with Pinky") {
        assertThat(play(myAlgorithm vs Clyde()))
            .wonBy(myAlgorithm.identity)
    }

})
