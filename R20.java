import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R20 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R20 extends Dungeon1
{

    /**
     * Constructor for objects of class R20.
     * 
     */
    public R20()
    {
        super(true);
        prepareRoom(450,500,true,false,false,true);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        CloseEnemy closeenemy3 = new CloseEnemy();
        addObject(closeenemy3,552,110);
        CloseEnemy closeenemy4 = new CloseEnemy();
        addObject(closeenemy4,245,123);
        CloseEnemy closeenemy5 = new CloseEnemy();
        addObject(closeenemy5,401,490);
    }
}
