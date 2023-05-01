package com.neves6.piazzapanic.tests.poweruptests;

import static org.junit.Assert.assertEquals;

import com.neves6.piazzapanic.powerups.CheaperMachineUnlock;
import com.neves6.piazzapanic.tests.GdxTestRunner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class TestCheaperMachineUnlock {
  ArrayList<Float> testMachineUnlock = new ArrayList<>(Arrays.asList(100f, 0f));
  CheaperMachineUnlock testCheaperMachineClass = new CheaperMachineUnlock(30000L, "test");
  CheaperMachineUnlock testCheaperMachineClassII = new CheaperMachineUnlock(1000L, "test");
  Map<String, ArrayList<Float>> testMap = new HashMap<>();

  @Test
  public void testActivateUnactivePowerup() {
    testMap.put("t1", testMachineUnlock);
    testCheaperMachineClass.applyPowerUp(testMap);
      assertEquals("The values must not be modified if power-up is not active", 100f, testMachineUnlock.get(0), 0.0);
      assertEquals("The values must not be modified if power-up is not active", 0f, testMachineUnlock.get(1), 0.0);
  }

  @Test
  public void testActivatedPowerUp() {
    testMap.put("t1", testMachineUnlock);
    testCheaperMachineClass.acquirePowerUp();
    testCheaperMachineClass.applyPowerUp(testMap);
      assertEquals("The run time value must be modified when power-up is running.", 50f, testMachineUnlock.get(0), 0.0);
      assertEquals("The unlock value must not be modified by this power-up", 0f, testMachineUnlock.get(1), 0.0);
  }

  @Test
  public void testEndPowerupActive() throws InterruptedException {
    testMap.put("t1", testMachineUnlock);
    testCheaperMachineClassII.acquirePowerUp();
    testCheaperMachineClassII.applyPowerUp(testMap);
    TimeUnit.MILLISECONDS.sleep(2000L);
    testCheaperMachineClassII.endPowerUp(testMap);
      assertEquals("The run time value must return to its original value once power-up has ended.", 100f, testMachineUnlock.get(0), 0.0);
      assertEquals("The unlock value must not be modified by this power-up", 0f, testMachineUnlock.get(1), 0.0);
  }

  @Test
  public void testEndPowerupInactive() {
    testMap.put("t1", testMachineUnlock);
    testCheaperMachineClass.acquirePowerUp();
    testCheaperMachineClassII.endPowerUp(testMap);
      assertEquals("The run time must not be modified when power-up is inactive.", 100f, testMachineUnlock.get(0), 0.0);
      assertEquals("The unlock value must not be modified by this power-up", 0f, testMachineUnlock.get(1), 0.0);
  }
}
