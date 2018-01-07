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
        HealthStatus healthstatus = new HealthStatus(hero);
        CloseEnemy closeenemy = new CloseEnemy();
        RangeEnemy rangeenemy = new RangeEnemy();
        Enemy enemy = new Enemy();

        addObject(enemy,5,5);
        addObject(rangeenemy,10,10);
        addObject(closeenemy,7,7);
        addObject(hero,3, 3);
        addObject(healthstatus,15,15);
        healthstatus.setLocation(277,291);
        healthstatus.setLocation(63,40);
        closeenemy.setLocation(270,208);
        rangeenemy.setLocation(270,303);
        hero.setLocation(272,393);
        hero.setLocation(451,256);
        enemy.setLocation(271,382);
        removeObject(healthstatus);
        removeObject(rangeenemy);
        removeObject(enemy);
        HealthStatus healthstatus2 = new HealthStatus(hero);
        addObject(healthstatus2,63,53);
    }
    
}
