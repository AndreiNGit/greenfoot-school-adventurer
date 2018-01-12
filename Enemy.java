import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Character
{
    protected Hero hero;
    
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
        if(Greenfoot.getRandomNumber(1000) < 10)
        {
            turn(Greenfoot.getRandomNumber(90 - 45));
            move(Greenfoot.getRandomNumber(20));
        }
    }
}
