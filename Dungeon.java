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
        Character character = new Character();

        Hero hero = new Hero();
        addObject(hero,548,307);
        CloseEnemy closeenemy = new CloseEnemy();
        addObject(closeenemy,287,209);
        CloseEnemy closeenemy2 = new CloseEnemy();
        addObject(closeenemy2,298,424);
        HealthStatus healthstatus = new HealthStatus(hero);
        addObject(healthstatus,101,54);
        addObject(character,796,1);
        closeenemy2.setLocation(418,59);
        closeenemy.setLocation(574,53);
        RangeEnemy rangeenemy = new RangeEnemy();
        addObject(rangeenemy,160,439);
        removeObject(character);
    }
    
}
