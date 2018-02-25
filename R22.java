import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R22 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R22 extends Dungeon1
{

    /**
     * Constructor for objects of class R22.
     * 
     */
    public R22()
    {
        super(true);
        prepareRoom(700, 500, false, true, true, true);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        CloseEnemy closeenemy = new CloseEnemy();
        addObject(closeenemy,201,483);
        CloseEnemy closeenemy2 = new CloseEnemy();
        addObject(closeenemy2,683,461);
        closeenemy2.setLocation(687,481);
        RangeEnemy rangeenemy = new RangeEnemy();
        addObject(rangeenemy,173,115);
        RangeEnemy rangeenemy2 = new RangeEnemy();
        addObject(rangeenemy2,736,120);
        Chest chest2 = new Chest();
        addObject(chest2,471,72);
    }
}
