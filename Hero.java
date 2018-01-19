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
        speed = 3;
        damage = 20;
        health = 100;
    }

    public void act() 
    {
        move();
        gameOver();
        attack();
        changeAttackStart();
        changeAttackCooldown();
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
        //Daca tasta space este apasata atunci caracterul ataca folosind metoda curenta
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

    void changeAttackStart()
    {
        //Daca tasta 's' este apasata atunci caracterul comuta intre cele doua moduri de atac
        if(sDown != Greenfoot.isKeyDown("s"))
        {
            sDown = !sDown;
            if(sDown)
            {
                frameCounter = 1; //se atribuie valoarea 1 pentru a executa metoda changeAttackCoolDown()
                //3,4 sunt valori reziduale folosite pentru a evita folosirea atacului in timpul schimbului
                if(chooseAttack == 1)
                {
                    chooseAttack = 3;
                }
                else if(chooseAttack == 2)
                {
                    chooseAttack = 4;
                }
            }
        }
    }

    void changeAttackCooldown()
    {
        //Metoda actioneaza ca un timer pentru schimbul atacurilor
        if (frameCounter >= 1 && frameCounter <= 100)
        {
            frameCounter++;
            if(chooseAttack == 4 && frameCounter == 100)
            {
                chooseAttack = 1;
                frameCounter = 0; //se atribuie valoarea 0 pentru a opri din executie metoda
            }
            else if(chooseAttack == 3 && frameCounter == 100)
            {
                chooseAttack = 2;
                frameCounter = 0;
            }
            System.out.println("frameCounter " + frameCounter);
            System.out.println("attack " + chooseAttack);
        }
    }
    
    void meleeAttack()
    {
        //Caracterul ataca inamicul cu care se intersecteaza
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        if(enemy != null)
        {
            enemy.setHealth(enemy.getHealth() - damage);
        }
    }

    void rangeAttack()
    {
        //Caracterul ataca de la distanta folosind obiectele din clasa Arrow
        Arrow arrow = new Arrow(this);
        getWorld().addObject(arrow, getX(), getY());

        //Setarea directiei sagetii in functie de orientarea caracterului
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
        //Opreste jocul in momentul in care caracterul moare
        if (health <= 0)
        {
            health = 0;
            Greenfoot.stop();
        }
    }
}