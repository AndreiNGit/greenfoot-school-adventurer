import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class D1_R2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class D1_R2 extends Dungeon1
{
    /**
     * Constructor for objects of class D1_R2.
     * 
     */
    public D1_R2()
    {
        super(800, 600, 1);
        prepare();
    }
    
    void prepare()
    {
        CloseEnemy closeenemy3 = new CloseEnemy(hero);
        addObject(closeenemy3,641,425);
        CloseEnemy closeenemy4 = new CloseEnemy(hero);
        addObject(closeenemy4,508,238);
        Door door2 = new Door(new D1_R3());
        addObject(door2,266,465);
    }
    
    public void act()
    {
        
    }
}
