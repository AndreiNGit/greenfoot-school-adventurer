import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Character
{
    
    
    public void act() 
    {
    }
        
    void enemyDead()
    {
        if(health <= 0 && getWorld() != null)
        {
            World world = getWorld();
            world.removeObject(this);
        }
    }
}
