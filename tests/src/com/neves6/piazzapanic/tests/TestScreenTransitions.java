package com.neves6.piazzapanic.tests;

import static org.junit.Assert.*;

import com.badlogic.gdx.Gdx;
import com.neves6.piazzapanic.screens.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class TestScreenTransitions {
  PiazzaPanicGame testGame = new PiazzaPanicGame();

  @Test
  public void testIntroScreenOnLaunch() {
    Gdx.gl20 = Gdx.gl;
    testGame.create();
    assertSame(
        "The game must go straight to the introScreen on Launch",
        testGame.getScreen().getClass(),
        IntroScreen.class);
  }
}
