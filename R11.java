import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R11 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R11 extends Dungeon1
{

    /**
     * Constructor for objects of class R11.
     * 
     */
    public R11()
    {
        super(true);
        prepareRoom(700,500,false,true,true,true);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        RangeEnemy rangeenemy = new RangeEnemy();
        addObject(rangeenemy,169,119);
        RangeEnemy rangeenemy2 = new RangeEnemy();
        addObject(rangeenemy2,157,505);
    }
}
