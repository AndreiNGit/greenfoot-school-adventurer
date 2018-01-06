import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CloseEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CloseEnemy extends Enemy
{
    public CloseEnemy()
    {
        speed = 2;
        damage = 10;
        health = 100;
        attackSpeed = 50;
    }
    
    public void act() 
    {
        System.out.println("CloseEnemy health:" + health);
    }
    
    void attackHero()
    {
        
    }
}
