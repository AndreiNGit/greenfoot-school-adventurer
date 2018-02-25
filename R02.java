import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R02 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R02 extends Dungeon1
{

    /**
     * Constructor for objects of class R02.
     * 
     */
    public R02()
    {
        super(true);
        prepareRoom(700,500,false,false,true,false);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        RangeEnemy rangeenemy2 = new RangeEnemy();
        addObject(rangeenemy2,153,125);
        RangeEnemy rangeenemy3 = new RangeEnemy();
        addObject(rangeenemy3,160,295);
        RangeEnemy rangeenemy4 = new RangeEnemy();
        addObject(rangeenemy4,157,463);
        CloseEnemy closeenemy2 = new CloseEnemy();
        addObject(closeenemy2,647,129);
        CloseEnemy closeenemy3 = new CloseEnemy();
        addObject(closeenemy3,632,482);
        CloseEnemy closeenemy4 = new CloseEnemy();
        addObject(closeenemy4,377,305);
        Chest chest2 = new Chest();
        addObject(chest2,769,76);
    }
}
