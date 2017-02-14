package com.fate.game.tetris;

import com.fate.engine.core.GameApplication;

public class TetrisGameLauncher {
    private static GameApplication gameLauncher;
    private static TetrisGame game;

    public static void main(String[] args) {
        game = new TetrisGame(800, 600, 60, false);
        gameLauncher = new GameApplication(game);

        gameLauncher.launch();
    }

    /**
     * TODO: Prototype 1
     *
     * Player
     * Level (bag of Obstacles)
     * KeyboardController
     */
}
