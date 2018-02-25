import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R30 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R30 extends Dungeon1
{

    /**
     * Constructor for objects of class R30.
     * 
     */
    public R30()
    {
        super(true);
        prepareRoom(400,550,true,false,false,false);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        RangeEnemy rangeenemy = new RangeEnemy();
        addObject(rangeenemy,357,518);
        RangeEnemy rangeenemy2 = new RangeEnemy();
        addObject(rangeenemy2,556,520);
        CloseEnemy closeenemy = new CloseEnemy();
        addObject(closeenemy,449,407);
        Chest chest2 = new Chest();
        addObject(chest2,618,48);
    }
}
