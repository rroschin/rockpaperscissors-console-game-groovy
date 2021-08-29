package xyz.romros.rockpaperscissors

enum GameFigure {

    ROCK('Rock', 'r', '1'),
    PAPER('Paper', 'p', '2'),
    SCISSORS('Scissors', 's', '3')

    def readable
    def hotkey
    def index

    GameFigure(final readable, final hotkey, final index) {
        this.readable = readable
        this.hotkey = hotkey
        this.index = index
    }

    static GameFigure byHotkeyOrIndex(final hotkeyOrIndex) {
        values().stream()
                .filter { i -> i.hotkey == hotkeyOrIndex || i.index == hotkeyOrIndex}
                .find()
    }
}
