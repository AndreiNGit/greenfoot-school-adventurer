import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R01 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R01 extends Dungeon1
{

    /**
     * Constructor for objects of class R01.
     * 
     */
    public R01()
    {
        super(true);
        prepareRoom(400,400,false,false,true,false);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        CloseEnemy closeenemy = new CloseEnemy();
        addObject(closeenemy,305,301);
        Chest chest2 = new Chest();
        addObject(chest2,463,123);
    }
}
