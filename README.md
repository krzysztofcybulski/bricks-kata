# Bricks Kata 🧱

Your goal is to win with your opponent by making him unable to move.

## Rules
* Board is defined as NxN square
* Players take turnes
* You can place 2x1 bricks (verically or horizontally)
* You cannot place brick on other brick
* Player which makes illegal move automatically loses the game
* Time for making a move is limited

## How to implement an algorithm?

```
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
```

Set your name in `Identity` field.

Initialize game state in `initialize` method. Maybe you need to clear some memory or warm up your fancy AI engine?

Return your answer for opponent's move in `move` method. Note that this is coroutines method, so you can take advantage of all the coroutines goodnes. 
Maxium time is limited (depending from specific game setting), so make sure you return something, otherwise you will automatically lose entire game.

## Tests

There are simple algorithms in `test` directory, which you can use to benchmark your own solution or to get some inspiration. 
If you manage to beat them all you will be ready to compete online.

## Online competition

The host have to run a server with [bricks](https://github.com/krzysztofcybulski/bricks) on it and provide you an `ip address`. 
Then you can just join specific lobby, by running `BricksWebClient` - for example in you `main` method.

```
fun main() {
  BricksWebClient("amelinium.kcybulski.me")
    .register("lobby", MyBricksAlgorithm())
}
```

When joining you have to provide server address, lobby name you want to join and your algorithm instance. All your and your opponent's moves will be logged on your machines. 

Have fun! 🐻
