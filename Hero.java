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
    private boolean spaceDown = false;
    private boolean sDown = false;
    private int chooseAttack = 2;
    private int direction = 2;
    
    public Hero()
    {
        speed = 2;
        damage = 20;
        health = 100;
    }
    
    public void act() 
    {
        move();
        gameOver();
        attack();
        chooseAttack();
        chooseAttackCooldown();
    }
    
    void move()
    {
        //Schimba locatia si seteaza variabila 'direction' pentru functia 'rangeAttack'
        if(Greenfoot.isKeyDown("up"))
        {
            direction = 1;
            setLocation(getX(), getY() - speed);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            direction = 2;
            setLocation(getX(), getY() + speed);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            direction = 3;
            setLocation(getX() + speed, getY());
        }
        if(Greenfoot.isKeyDown("left"))
        {
            direction = 4;
            setLocation(getX() - speed, getY());
        }
    }
    
    void attack()
    {
        if(spaceDown != Greenfoot.isKeyDown("space"))
        {
            spaceDown = !spaceDown;
            if(spaceDown)
            {
                if(chooseAttack == 1)
                {
                    meleeAttack();
                }
                else if(chooseAttack == 2)
                {
                    rangeAttack();
                }
            }
        }
    }
    
    void chooseAttack()
    {
        if(sDown != Greenfoot.isKeyDown("s"))
        {
            sDown = !sDown;
            if(sDown)
            {
                System.out.println(chooseAttack+ " "+ frameCounter);
                frameCounter++;
                if (chooseAttack == 1 || chooseAttack == 4)
                {
                    if(frameCounter > 180)
                    {
                        chooseAttack = 2;
                        frameCounter = 0;
                    }
                }
                else if(chooseAttack == 2 || chooseAttack == 3)
                {
                    if(frameCounter > 180)
                    {
                        chooseAttack = 1;
                        frameCounter = 0;
                    }
                }
            }
        }
    }
    
    void chooseAttackCooldown()
    {
        if (frameCounter >= 1 && frameCounter <= 180)
        {
            frameCounter++;
            if(chooseAttack == 1)
            {
                chooseAttack = 3;
            }
            else if(chooseAttack == 2)
            {
                chooseAttack = 4;
            }
            System.out.println("update " + frameCounter);
        }
    }
    
    void meleeAttack()
    {
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        if(enemy != null)
        {
            enemy.setHealth(enemy.getHealth() - damage);
        }
    }
    

    void rangeAttack()
    {   
        Arrow arrow = new Arrow(this);
        getWorld().addObject(arrow, getX(), getY());
        
        //Setarea directiei sagetii in functie de unghiul miscarii caracterului
        if(direction == 1)
        {
            arrow.setRotation(270);
        }
        if(direction == 2)
        {
            arrow.setRotation(90);
        }
        if(direction == 3)
        {
            arrow.setRotation(0);
        }
        if(direction == 4)
        {
            arrow.setRotation(180);
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