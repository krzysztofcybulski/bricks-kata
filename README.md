# Bricks Kata 🧱

Your goal is to win with your opponent by making him unable to move.

## Rules

* Board is defined as NxN square
* Players take turns
* Game is initialized with random blocks
* You can place 2x1 bricks (vertically or horizontally)
* You cannot place brick on other brick
* Player which makes illegal move automatically loses the game
* Time for making a move is limited

## How to implement an algorithm?

First you have to choose algorithm template you want to use.

|       Base class        |                    Description                    |
|:-----------------------:|:-------------------------------------------------:|
|      UserAlgorithm      |      Decide how to store state by your own.       |
|  UserArrayMapAlgorithm  | Uses two-dimensional array to store current map.  |
| UserBlocksListAlgorithm | Uses set of taken positions to store current map. |

Both `UserArrayMapAlgorithm` and `UserBlocksListAlgorithm` are designed to be easy to use.
They take care of keeping application state for you. 
Ale you have to to is to return on what positions you want to place your brick.

```kotlin
class MyBricksAlgorithm : UserArrayMapAlgorithm() {

    override suspend fun move(map: Array<Array<MapField>>): Brick {
        return DuoBrick.unsafe(
            Block(1, 1),
            Block(2, 1)
        )
    }

}
```

Note that these are coroutines methods, so you can take advantage of all the coroutines goodness.

Maximum time is limited (depending on specific game setting), so make sure you return something, otherwise you will
automatically lose entire game.

## Tests

There are simple algorithms in `test` directory, which you can use to benchmark your own solution or to get some
inspiration.
If you manage to beat them all you will be ready to compete online.

## Online competition

The host have to run a server with [bricks](https://github.com/krzysztofcybulski/bricks) on it and provide you
an `ip address`.
Then you can just join specific lobby, by running `BricksWebClient` in you `main` method.

```kotlin
fun main() = runBlocking {
    BricksWebClient("bricks-api.kcybulski.me")
        .register(MyBricksAlgorithm())
}
```

When joining you have to provide server address and your algorithm instance. 
You will be asked to enter lobby you want to join as well as api key.
All your and your opponent's moves will be logged on your machines.

## Tricks & tips

* Implement as simple algorithm as you can think of and improve it
* Learn what are your opponent's strategies
* Implement some kind of fallback in case your move is running out of time
* Catch exceptions to be sure that they won't crash your entire algorithm
* Play with other structures by using `UserAlgorithm` interface directly

Have fun! 🐻
