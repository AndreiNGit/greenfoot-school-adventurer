import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    protected int speed;
    protected int health;
    protected int damage;
    protected int frameCounter;
    
    public int getHealth()
    {
        return this.health;
    }
    
    public void setHealth(int _health)
    {
        this.health = _health;
    }    
}
