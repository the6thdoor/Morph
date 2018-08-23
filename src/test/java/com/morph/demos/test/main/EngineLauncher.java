package com.morph.demos.test.main;

import com.morph.engine.core.GameApplication;

public class EngineLauncher {
	private static GameApplication launcher;
	private static Engine engine;
	
	public static void main(String[] args) {
		engine = new Engine(1366, 768, 60, false);
		launcher = new GameApplication(engine);
		
		launcher.launchGame();
	}
}
