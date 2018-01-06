import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RangeEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RangeEnemy extends Enemy
{
    public RangeEnemy()
    {
        speed = 2;
        damage = 10;
        health = 100;
        attackSpeed = 50;
    }
    
    public void act() 
    {
        //System.out.println("RangeEnemy health:" + health);
    }
}
