import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R03 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R03 extends Dungeon1
{

    /**
     * Constructor for objects of class R03.
     * 
     */
    public R03()
    {
        super(true);
        prepareRoom(500, 500, false, false, true, false);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        CloseEnemy closeenemy = new CloseEnemy();
        addObject(closeenemy,404,308);
        Chest chest2 = new Chest();
        addObject(chest2,583,74);
    }
}
