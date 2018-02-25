import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R33 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R33 extends Dungeon1
{

    /**
     * Constructor for objects of class R33.
     * 
     */
    public R33()
    {
        super(true);
        prepareRoom(400,400,false,false,false,true);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Chest chest2 = new Chest();
        addObject(chest2,599,125);
    }
}
