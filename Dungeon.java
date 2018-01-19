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
        super(800, 600 ,1);
        prepare();
    }
    
    private void prepare()
    {
        Hero hero = new Hero();
        addObject(hero,731,334);
        HealthStatus healthstatus = new HealthStatus(hero);
        addObject(healthstatus,97,54);
        RangeEnemy rangeenemy = new RangeEnemy(hero);
        addObject(rangeenemy,188,225);
        RangeEnemy rangeenemy2 = new RangeEnemy(hero);
        addObject(rangeenemy2,190,342);
        CloseEnemy closeenemy = new CloseEnemy(hero);
        addObject(closeenemy,723,54);
        CloseEnemy closeenemy2 = new CloseEnemy(hero);
        addObject(closeenemy2,534,62);
        rangeenemy.setLocation(173,181);
        rangeenemy2.setLocation(189,347);
        Chest chest = new Chest("a", " ", " ", " ", " ", 'a');
        addObject(chest,614,585);
    }
}
