import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthStatus here.
 * 
 * @author Andrei Nicusor
 * @version 1.2
 */
public class HealthStatus extends Actor
{
    GreenfootImage healthStatus;
    //Dungeon dungeon = (Dungeon)getWorld();
    //Hero hero = dungeon.getHero();
    Hero hero;
    
    public HealthStatus(Hero _hero)
    {
        hero = _hero;
    }
    
    public void act() 
    {
        updateHealthStatus(hero.health);
    }
    
    void updateHealthStatus(int _health)
    {
        healthStatus = new GreenfootImage("Health: " + _health, 24, Color.RED, Color.WHITE);
        setImage(healthStatus);
    }
}
