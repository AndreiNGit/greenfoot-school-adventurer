import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon here.
 * 
 * @author Andrei Nicusor
 * @version 1.1
 */
public class Dungeon extends World
{
    

    public Dungeon()
    {    
        super(800, 600, 1);
        prepare();
    }
    
    private void prepare()
    {
        Hero hero = new Hero();
        HealthStatus healthstatus = new HealthStatus(hero);
        CloseEnemy closeenemy = new CloseEnemy();
        RangeEnemy rangeenemy = new RangeEnemy();
        Enemy enemy = new Enemy();

        addObject(enemy,268,206);
        addObject(rangeenemy,279,288);
        addObject(closeenemy,274,381);
        addObject(hero,450,292);
        addObject(healthstatus,73,55);
    }
    
}
