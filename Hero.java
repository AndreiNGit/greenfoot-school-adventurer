import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.String;
/**
 * Write a description of class Hero here.
 * 
 * @author Andrei Nicusor
 * @version 1.5
 */
public class Hero extends Character
{
    public Hero()
    {
        speed = 2;
        damage = 10;
        health = 100;
        attackSpeed = 50;
    }
    
    public void act() 
    {
        //frameCounter++;
        gameOver();
        move();
        MeleeAttack();
    }
    
    void move()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - speed);
            //move(speed);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + speed);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + speed, getY());
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - speed, getY());
        }
    }
    
    void MeleeAttack()
    {
        if(Greenfoot.getKey() == "space")
        {
            Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
            if(enemy != null)
            {
                enemy.health -= damage;
            }
        }
    }
    
    void gameOver()
    {
        if (health <= 0)
        {
            health = 0;
            Greenfoot.stop();
        }
    }
}