package xyz.romros.rockpaperscissors

class GameResultCalculator {

    GameResult compareChoices(final GameFigure userChoice, final GameFigure computerChoice) {
        if (userChoice == computerChoice) {
            return GameResult.DRAW
        } else if (userChoice == GameFigure.ROCK) {
            return computerChoice == GameFigure.SCISSORS ? GameResult.WIN : /* GameFigure.PAPER */ GameResult.LOSE
        } else if (userChoice == GameFigure.PAPER) {
            return computerChoice == GameFigure.ROCK ? GameResult.WIN : /* GameFigure.SCISSORS */ GameResult.LOSE
        } else if (userChoice == GameFigure.SCISSORS) {
            return computerChoice == GameFigure.PAPER ? GameResult.WIN : /* GameFigure.ROCK */ GameResult.LOSE
        } else {
            throw new IllegalStateException('What game are we paying?')
        }
    }

    String explainResult(final GameResult gameResult, final GameFigure userChoice, final GameFigure computerChoice) {
        if (gameResult == GameResult.DRAW) {
            return "${userChoice.readable} and ${computerChoice.readable} are the same"
        } else if (gameResult == GameResult.WIN) {
            return "${userChoice.readable} beats ${computerChoice.readable}"
        } else if (gameResult == GameResult.LOSE) {
            "${computerChoice.readable} beats ${userChoice.readable}"
        } else {
            throw new IllegalStateException('What game are we paying?')
        }
    }
}
