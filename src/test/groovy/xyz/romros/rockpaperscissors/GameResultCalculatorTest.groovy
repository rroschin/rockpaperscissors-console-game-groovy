package xyz.romros.rockpaperscissors

import spock.lang.Specification

class GameResultCalculatorTest extends Specification {
    def "CompareChoices when ROCK vs SCISSORS then ROCK should WIN"() {
        given:
        def userChoice = GameFigure.ROCK
        def computerChoice = GameFigure.SCISSORS

        when:
        def result = new GameResultCalculator().compareChoices(userChoice, computerChoice)

        then:
        result == GameResult.WIN
    }

    def "CompareChoices when PAPER vs ROCK then PAPER should WIN"() {
        given:
        def userChoice = GameFigure.PAPER
        def computerChoice = GameFigure.ROCK

        when:
        def result = new GameResultCalculator().compareChoices(userChoice, computerChoice)

        then:
        result == GameResult.WIN
    }

    def "CompareChoices when SCISSORS vs PAPER then SCISSORS should WIN"() {
        given:
        def userChoice = GameFigure.SCISSORS
        def computerChoice = GameFigure.PAPER

        when:
        def result = new GameResultCalculator().compareChoices(userChoice, computerChoice)

        then:
        result == GameResult.WIN
    }

    def "CompareChoices when ROCK vs PAPER then ROCK should LOSE"() {
        given:
        def userChoice = GameFigure.ROCK
        def computerChoice = GameFigure.PAPER

        when:
        def result = new GameResultCalculator().compareChoices(userChoice, computerChoice)

        then:
        result == GameResult.LOSE
    }

    def "CompareChoices when PAPER vs SCISSORS then PAPER should LOSE"() {
        given:
        def userChoice = GameFigure.PAPER
        def computerChoice = GameFigure.SCISSORS

        when:
        def result = new GameResultCalculator().compareChoices(userChoice, computerChoice)

        then:
        result == GameResult.LOSE
    }

    def "CompareChoices when SCISSORS vs ROCK then SCISSORS should LOSE"() {
        given:
        def userChoice = GameFigure.SCISSORS
        def computerChoice = GameFigure.ROCK

        when:
        def result = new GameResultCalculator().compareChoices(userChoice, computerChoice)

        then:
        result == GameResult.LOSE
    }

    def "CompareChoices when ROCK vs ROCK then it is a DRAW"() {
        given:
        def userChoice = GameFigure.ROCK
        def computerChoice = GameFigure.ROCK

        when:
        def result = new GameResultCalculator().compareChoices(userChoice, computerChoice)

        then:
        result == GameResult.DRAW
    }

    def "CompareChoices when PAPER vs PAPER then it is a DRAW"() {
        given:
        def userChoice = GameFigure.PAPER
        def computerChoice = GameFigure.PAPER

        when:
        def result = new GameResultCalculator().compareChoices(userChoice, computerChoice)

        then:
        result == GameResult.DRAW
    }

    def "CompareChoices when SCISSORS vs SCISSORS then it is a DRAW"() {
        given:
        def userChoice = GameFigure.SCISSORS
        def computerChoice = GameFigure.SCISSORS

        when:
        def result = new GameResultCalculator().compareChoices(userChoice, computerChoice)

        then:
        result == GameResult.DRAW
    }

}
