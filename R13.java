import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class R13 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class R13 extends Dungeon1
{

    /**
     * Constructor for objects of class R13.
     * 
     */
    public R13()
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
        addObject(rangeenemy,183,182);
        RangeEnemy rangeenemy2 = new RangeEnemy();
        addObject(rangeenemy2,183,444);
        RangeEnemy rangeenemy3 = new RangeEnemy();
        addObject(rangeenemy3,579,183);
        RangeEnemy rangeenemy4 = new RangeEnemy();
        addObject(rangeenemy4,593,446);
    }
}
