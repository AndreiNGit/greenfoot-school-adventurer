import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R10 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R10 extends Dungeon1
{

    /**
     * Constructor for objects of class R10.
     * 
     */
    public R10()
    {
        super(true);
        prepareRoom(600,400,true,false,true,true);
        prepare();
        
    }

    private void prepare()
    {
        CloseEnemy closeenemy = new CloseEnemy();
        addObject(closeenemy,608,181);
        CloseEnemy closeenemy2 = new CloseEnemy();
        addObject(closeenemy2,610,448);
    }
}
