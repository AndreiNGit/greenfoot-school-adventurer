import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    protected int speed;
    protected int health;
    protected int damage;
    protected int attackSpeed;
    protected static int frameCounter = 0;
    
    public void act() 
    {
        // Add your action code here.
        frameCounter++;
        checkFrameCounter();
    }
    
    void checkFrameCounter()
    {
        if(frameCounter > 30000)
        {
            frameCounter = 0;
        }
    }
    
    void enemyDead()
    {
        if(health <= 0)
        {
            World world = getWorld();
            world.removeObject(this);
        }
    }
}
