package com.neves6.piazzapanic.tests;

import com.neves6.piazzapanic.CreditsScreen;
import com.neves6.piazzapanic.IntroScreen;
import com.neves6.piazzapanic.PiazzaPanicGame;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class TestScreenTransitions {
    @Test
    public void testIntroScreenOnLaunch(){
        PiazzaPanicGame testGame = new PiazzaPanicGame();
        testGame.create();
        assertTrue(testGame.getScreen().getClass() == IntroScreen.class);
    }

    @Test
    public void testCreditsToTitleScreen(){
        PiazzaPanicGame testGame = new PiazzaPanicGame();
        CreditsScreen testCredits = new CreditsScreen(testGame);
        testCredits.keyDown(1);
        assertTrue(testGame.getScreen().getClass() == IntroScreen.class);
    }

}
