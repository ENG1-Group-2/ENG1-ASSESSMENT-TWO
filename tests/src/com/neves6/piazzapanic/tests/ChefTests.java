package com.neves6.piazzapanic.tests;
import com.badlogic.gdx.Gdx;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;
@RunWith(GdxTestRunner.class)
public class ChefTests {
    @Test
    public void testChefConstructorValid(){
        int x=4;
        int y=20;
        String name="@<-little monkey :)";
        int chopSpeed=0;
        int frySpeed=1;
        int bakeSpeed=5;
        boolean isStickied=true;
        Stack<String> inv=<"i", "t", "e", "m">;
        int texSet=42;
        String direction="down";
        Chef testChef=new Chef(name, x, y, chopSpeed, frySpeed, bakeSpeed, isStickied, inv, texSet);
        assertTrue("Chef Constructor Valid :D", 
        testChef.getxCoord()==x &&
        testChef.getxCoord()==4 &&
        testChef.getyCoord()==y &&
        testChef.getyCoord()==20 &&
        testChef.getName()==name &&
        testChef.getName()=="@<-little monkey :)" &&
        testChef.getIsStickied()==isStickied &&
        testChef.getIsStickied()==true &&
        testChef.getInventory()==inv &&
        testChef.getInventory()==<"i", "t", "e", "m"> &&
        /**
         * 
         * testChef.getTxNow()==txDown TEXTURESET ETC??
         * 
        */
        );
    }
    @Test//NOT SURE (think needs chef construction?)
    public void testChefSetMachine(){
        Machine testMachine=new Machine("Fryer", "Uncooked Chips", "Cooked Chips", 0.5, true);
        Chef testChef=new Chef("Bob", 6, 9, 4, 2, 0, true, <"i", "t", "e", "m">, /**texture set int*/ 21);
        testChef.setMachineInteractingWith(testMachine);
        assertTrue("Set Machine Works :D",
        testChef.getMachineInteractingWith()==testMachine);
    }
    @Test//NOT SURE (same again)
    public void testChefSetSticky(){
        Chef testChef=new Chef("Bob", 6, 9, 4, 2, 0, true, <"i", "t", "e", "m">, /**texture set int*/ 21);
        boolean stickiness=true;
        testChef.setIsStickied(stickiness);
        assertTrue("Set Sticky Works :D",
        testChef.getIsStickied()==true &&
        testChef.getIsStickied()==stickiness);
    }
    @Test
    public void testInvAdd(){
        Chef testChef=new Chef("Bob", 6, 9, 4, 2, 0, true, <"i", "t", "e", "m">, /**texture set int*/ 21);
        Stack<String> testInvA=testChef.getInventory();
        testChef.addToInventory("s");
        assertTrue("Add to Inventory Works :D",
        testChef.getInventory()==testInvA.add("s") &&
        testChef.getInventory()==<"i", "t", "e", "m", "s">);
    }
    @Test
    public void testInvPop(){
        Chef testChef=new Chef("Bob", 6, 9, 4, 2, 0, true, <"i", "t", "e", "m">, /**texture set int*/ 21);
        Stack<String> testInvP=testChef.getInventory();
        testChef.removeTopFromInventory();
        assertTrue("Pop from Inventory Works :D",
        testChef.getInventory()==testInvP.pop() &&
        testChef.getInventory()==<"i", "t", "e">);
    }
    @Test
    public void testSetFacing(){
        Chef testChef=new Chef("Bob", 6, 9, 4, 2, 0, true, <"i", "t", "e", "m">, /**texture set int*/ 21);
        String facing="down"; //i think should be testChef.facing="" //on further reading might not need it at all, textures are confusing
        testChef.setFacing("up");
        assertTrue("Set Facing Works :D",
        testChef.getFacing()=="up" &&
        testChef.txtNow=txUp);
    }
}
