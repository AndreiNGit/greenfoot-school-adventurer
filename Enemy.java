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
        frameCounter++;
    }
        
    protected void checkLife()
    {
        if(health <= 0 && getWorld() != null)
        {
            World world = getWorld();
            world.removeObject(this);
        }
    }
    
    protected void moveRandom()
    {
        if(frameCounter % 100 == 0)
        {
            turn(Greenfoot.getRandomNumber(90));
            move(Greenfoot.getRandomNumber(15));
        }
    }
}
