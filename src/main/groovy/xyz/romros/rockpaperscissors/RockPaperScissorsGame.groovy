package xyz.romros.rockpaperscissors

class RockPaperScissorsGame {

    def EXIT_STRING = '!q:'
    def HELP_STRING = 'help'

    void begin() {
        printWelcomeMessage()


        def scanner = new Scanner(System.in)
        while (scanner.hasNext()) {
            def input = scanner.next()
            switch (input) {
                case EXIT_STRING:
                    {
                        println 'Thanks for playing! Bye!'
                        return //exit
                    }
                case GameFigure.ROCK.hotkey:
                case GameFigure.ROCK.index:
                case GameFigure.PAPER.hotkey:
                case GameFigure.PAPER.index:
                case GameFigure.SCISSORS.hotkey:
                case GameFigure.SCISSORS.index:
                    {
                        println playRound(input)
                        println 'Once again? Your choice:\n'
                        break
                    }
                case HELP_STRING:
                    {
                        printWelcomeMessage()
                        break
                    }
                default:
                    {
                        println "You told me something I do not understand, type 'help' to read the rules again."
                    }

            }
        }
    }

    void printWelcomeMessage() {
        println buildWelcomeMessage()
    }

    private String buildWelcomeMessage() {
        def gameFigures = GameFigure.values()*.readable
        def gameFiguresOptions = GameFigure.values().stream()
                .map { i -> "   - ${i.readable}: ${i.hotkey} or ${i.index}" }
                .toList()
        def gameResults = GameResult.values()*.name()
        def welcomeMessage = """*************************************************
                                      |*** Welcome to the Rock, Paper, Scissors Game ***
                                      |*************************************************
                                      |
                                      |The Rules of the Game are:
                                      | 1. You choose any of: ${gameFigures}
                                      | 2. You announce your choice by typing for 
                                      |${String.join("\n", gameFiguresOptions)}
                                      | 3. I (the Computer) make my choice and let you know about it
                                      | 4. I print the result for you: ${gameResults}
                                      | 5. I explain the result
                                      | 6. We continue playing until you type: '!q:' to exit the game
                                      | 
                                      |Let's go!

                                      |Your choice:
                                      |""".stripMargin()
        welcomeMessage
    }

    String playRound(final String input) {
        def userChoice = GameFigure.byHotkeyOrIndex(input)
        def computerChoice = new ComputerChoiceMaker().makeChoice()

        def gameResultCalculator = new GameResultCalculator()
        def result = gameResultCalculator.compareChoices(userChoice, computerChoice)
        def explainedResult = gameResultCalculator.explainResult(result, userChoice, computerChoice)

        def messageForUser = """Your choice is ${userChoice.readable}, my choice is: ${computerChoice.readable}, so
                                      |${result == GameResult.DRAW ? 'It is a' : 'You'} ${result}
                                      |Because ${explainedResult}
                                      """.stripMargin()
        messageForUser
    }
}
