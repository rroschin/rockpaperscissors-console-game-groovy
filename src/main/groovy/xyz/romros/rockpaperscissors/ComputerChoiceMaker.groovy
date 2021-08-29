package xyz.romros.rockpaperscissors

class ComputerChoiceMaker {

    def gameFigures = [
            (GameFigure.ROCK.index)    : GameFigure.ROCK,
            (GameFigure.PAPER.index)   : GameFigure.PAPER,
            (GameFigure.SCISSORS.index): GameFigure.SCISSORS
    ]

    GameFigure makeChoice() {
        def randomIndex = new Random().nextInt(3) + 1
        gameFigures[randomIndex.toString()]
    }
}
