import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R31 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R31 extends Dungeon1
{

    /**
     * Constructor for objects of class R31.
     * 
     */
    public R31()
    {
        super(true);
        prepareRoom(500,500,false,true,false,true);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        CloseEnemy closeenemy4 = new CloseEnemy();
        addObject(closeenemy4,253,136);
        RangeEnemy rangeenemy = new RangeEnemy();
        addObject(rangeenemy,523,146);
    }
}
