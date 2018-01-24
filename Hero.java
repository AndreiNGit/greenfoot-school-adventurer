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
    private int animationCounter = 0;
    private int maxHealth;
    
    private SimpleTimer rangeAttackTimer = new SimpleTimer();
    Label healthStatus = new Label("Health:" + getHealth(), 30);

    private GreenfootImage[] noWeaponSprites = {
    new GreenfootImage("upIdle.png"),
    new GreenfootImage("upMove1.png"),
    new GreenfootImage("upMove2.png"),
    new GreenfootImage("downIdle.png"),
    new GreenfootImage("downMove1.png"),
    new GreenfootImage("downMove2.png"),
    new GreenfootImage("rightIdle.png"),
    new GreenfootImage("rightMove1.png"),
    new GreenfootImage("rightMove2.png"),
    new GreenfootImage("leftIdle.png"),
    new GreenfootImage("leftMove1.png"),
    new GreenfootImage("leftMove2.png"),
    }; 
    
    public Hero()
    {
        speed = 3;
        damage = 20;
        maxHealth = 80;
        health = maxHealth;
    }

    public void act() 
    {
        idleAnimation();
        move();
        Status();
        attack();
        changeAttackStart();
        changeAttackCooldown();
    }
    
    void move()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            direction = 1;
            if(upCollision()) //executa miscarea daca nu exista un zid in fata
            {
                movingAnimation(noWeaponSprites[0], noWeaponSprites[1], noWeaponSprites[2]);
                setLocation(getX(), getY() - speed);
            }
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            direction = 2;
            if(downCollision())
            {
                movingAnimation(noWeaponSprites[3], noWeaponSprites[4], noWeaponSprites[5]);
                setLocation(getX(), getY() + speed);
            }
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            direction = 3;
            if(rightCollision())
            {
                movingAnimation(noWeaponSprites[6], noWeaponSprites[7], noWeaponSprites[8]);
                setLocation(getX() + speed, getY());
            }
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            direction = 4;
            if(leftCollision())
            {
                movingAnimation(noWeaponSprites[9], noWeaponSprites[10], noWeaponSprites[11]);
                setLocation(getX() - speed, getY());
            }
        }
    }
    
    void movingAnimation(GreenfootImage idle, GreenfootImage mv1, GreenfootImage mv2)
    {
        animationCounter++;
        if (animationCounter == 10)
        {
            setImage(mv1);
        }
        if (animationCounter == 20)
        {
            setImage(idle);
        }
        if (animationCounter == 30)
        {
            setImage(mv2);
        }
        if (animationCounter == 40)
        {
            setImage(idle);
            animationCounter = 0;
        }
    }
    
    void idleAnimation()
    {
        if(!Greenfoot.isKeyDown("up") && direction == 1)
        {
            setImage(noWeaponSprites[0]);
        }
        else if(!Greenfoot.isKeyDown("down") && direction == 2)
        {
            setImage(noWeaponSprites[3]);
        }
        else if(!Greenfoot.isKeyDown("right") && direction == 3)
        {
            setImage(noWeaponSprites[6]);
        }
        else if(!Greenfoot.isKeyDown("left") && direction == 4)
        {
            setImage(noWeaponSprites[9]);
        }
    }
    
    boolean upCollision()
    {
        Actor upWall = getOneObjectAtOffset(0, -30, Wall.class);
        Actor upChest = getOneObjectAtOffset(0, -30, Chest.class);
        Actor upEnemy = getOneObjectAtOffset(0, -30, Enemy.class);
        
        if(upWall != null || upChest != null || upEnemy != null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    boolean downCollision()
    {
        Actor downWall = getOneObjectAtOffset(0, 30, Wall.class);
        Actor downChest = getOneObjectAtOffset(0, 30, Chest.class);
        Actor downEnemy = getOneObjectAtOffset(0, 30, Enemy.class);
        if(downWall != null || downChest != null || downEnemy != null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    boolean rightCollision()
    {
        Actor rightWall = getOneObjectAtOffset(15, 0, Wall.class);
        Actor rightChest = getOneObjectAtOffset(15, 0, Chest.class);
        Actor rightEnemy = getOneObjectAtOffset(15, 0, Enemy.class);
        if(rightWall != null || rightChest != null || rightEnemy != null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    boolean leftCollision()
    {
        Actor leftWall = getOneObjectAtOffset(-15, 0, Wall.class);
        Actor leftChest = getOneObjectAtOffset(-15, 0, Chest.class);
        Actor leftEnemy = getOneObjectAtOffset(-15, 0, Enemy.class);
        if(leftWall != null || leftChest != null || leftEnemy != null)
        {
            return false;
        }
        else
        {
            return true;
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
        
    void Status()
    {
        if(health >= 0)
        {
            healthStatus.setValue("Health: " + health + "/" + maxHealth);
        }
        else
        {
            healthStatus.setValue("Health: " + 0  + "/" + maxHealth);
        }
        healthStatus.updateImage();
        getWorld().addObject(healthStatus, 120,40);
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