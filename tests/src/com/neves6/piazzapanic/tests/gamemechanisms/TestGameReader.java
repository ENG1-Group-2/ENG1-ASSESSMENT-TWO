package com.neves6.piazzapanic.tests.gamemechanisms;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.neves6.piazzapanic.gamemaster.ScenarioGameMaster;
import com.neves6.piazzapanic.gamemechanisms.GameReader;
import com.neves6.piazzapanic.gamemechanisms.Money;
import com.neves6.piazzapanic.screens.PiazzaPanicGame;
import com.neves6.piazzapanic.staff.DeliveryStaff;
import com.neves6.piazzapanic.staff.IngredientsStaff;
import com.neves6.piazzapanic.tests.GdxTestRunner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class TestGameReader {
  @Test
  public void testLoadFromFileI() throws ParseException, IOException {
    Money testMoney = new Money();

    Stack<String> testStack = new Stack<>();
    testStack.add("object");

    TiledMap map = new TmxMapLoader().load("tilemaps/testdouble.tmx");

    GameReader testReader = new GameReader("testLoadFromFileI.json");
    ScenarioGameMaster testgm =
        testReader.createGameMaster(
            new PiazzaPanicGame(),
            map,
            testMoney,
            new IngredientsStaff(
                new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1))),
            new DeliveryStaff(
                new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1))));

    assertEquals("The selected chef must be loaded from the json", 2, testgm.getSelectedChef());
    assertEquals("The balance must be loaded in from the file", 25.5f, testMoney.getBalance(), 0.0);
    assertTrue(
        "All unlocks should be used from previously saved game", testMoney.isUnlocked("auto"));
    assertTrue(
        "All unlocks should be used from previously saved game", testMoney.isUnlocked("forming"));
    assertFalse(
        "All unlocks should be used from previously saved game", testMoney.isUnlocked("potato"));
    assertEquals("The time must be continued from the save", 2, testgm.getTimer(), 0.0);
    assertEquals("The chefs position must be maintained.", 1, testgm.getChef(1).getxCoord());
    assertEquals("The chefs position must be maintained.", 2, testgm.getChef(1).getyCoord());
    assertEquals("The chefs inventory should be maintained", testgm.getChef(1).getInventory(), testStack);
    assertEquals("Order for the first customer must be the same", "potato", testgm.getFirstCustomer().getOrder());
    assertEquals("Order time for the first customer must be the same", 2.0f, testgm.getFirstCustomer().getTimeArrived(), 0.0);
    assertTrue(
        "All the power-ups must only be active if they were activated before",
        testgm.getPowerUpRunner().displayText().startsWith("Current Active Powerups: \n"));
  }

  @Test
  public void testLoadFromFileII() throws ParseException, IOException {
    Money testMoney = new Money();

    Stack<String> testStack = new Stack<>();
    testStack.add("object");

    TiledMap map = new TmxMapLoader().load("tilemaps/testdouble.tmx");

    GameReader testReader = new GameReader("testLoadFromFileII.json");
    ScenarioGameMaster testgm =
        testReader.createGameMaster(
            new PiazzaPanicGame(),
            map,
            testMoney,
            new IngredientsStaff(
                new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1))),
            new DeliveryStaff(
                new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1))));

    assertEquals("The selected chef must be loaded from the json", 2, testgm.getSelectedChef());
    assertEquals("The balance must be loaded in from the file", 25.5f, testMoney.getBalance(), 0.0);
    assertTrue(
        "All unlocks should be used from previously saved game", testMoney.isUnlocked("auto"));
    assertTrue(
        "All unlocks should be used from previously saved game", testMoney.isUnlocked("forming"));
    assertFalse(
        "All unlocks should be used from previously saved game", testMoney.isUnlocked("potato"));
    assertEquals("The time must be continued from the save", 2, testgm.getTimer(), 0.0);
    assertEquals("The chefs position must be maintained.", 1, testgm.getChef(1).getxCoord());
    assertEquals("The chefs position must be maintained.", 2, testgm.getChef(1).getyCoord());
    assertEquals("The chefs inventory should be maintained", testgm.getChef(1).getInventory(), testStack);
    assertTrue(
        "All the power-ups must only be active if they were activated before",
        testgm.getPowerUpRunner().displayText().startsWith("Current Active Powerups: \n"));
    assertTrue(
        "Any active powerups should be continued from the json",
        testgm.getPowerUpRunner().displayText().contains("1/2 price machines for 30 seconds"));
  }
}
