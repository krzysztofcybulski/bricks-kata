package me.kcybulski.bricks.kata

import kotlinx.coroutines.runBlocking
import me.kcybulski.bricks.client.BricksWebClient

fun main() = runBlocking {
    BricksWebClient("bricks-api.kcybulski.me")
        .register(MyBricksAlgorithm())
}
