import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R32 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R32 extends Dungeon1
{
    /**
     * Constructor for objects of class R32.
     * 
     */
    public R32()
    {
        super(true);
        prepareRoom(700,500,false,false,false,true);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Boss boss2 = new Boss();
        addObject(boss2,623,317);
    }
}
