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

```kotlin
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
```

Initialize game state in `initialize` method. Maybe you need to clear some memory or warm up your fancy AI engine?

Return your first move in `firstMove` method if you start the game. If your opponent starts the method won't be called.

Return your answer for opponent's move in `move` method. 

Note that these are coroutines methods, so you can take advantage of all the coroutines goodness. 

Maximum time is limited (depending on specific game setting), so make sure you return something, otherwise you will automatically lose entire game.

## Tests

There are simple algorithms in `test` directory, which you can use to benchmark your own solution or to get some inspiration. 
If you manage to beat them all you will be ready to compete online.

## Online competition

The host have to run a server with [bricks](https://github.com/krzysztofcybulski/bricks) on it and provide you an `ip address`. 
Then you can just join specific lobby, by running `BricksWebClient` in you `main` method.

```kotlin
fun main() = runBlocking {
    BricksWebClient("bricks-game.herokuapp.com")
        .register(MyBricksAlgorithm())
}
```

When joining you have to provide server address and your algorithm instance. All your and your opponent's moves will be logged on your machines. 

## Tricks & tips

* Implement as simple algorithm as you can think of and improve it
* Learn what are your opponent's strategies
* Implement some kind of fallback in case your move is running out of time
* Give your algorithm a cool name
* Change your behaviour by knowing who you play against
* Catch exceptions to be sure that they won't crash your entire algorithm

Have fun! 🐻
