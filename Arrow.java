import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RangeFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Bullet
{
    public Arrow(Character _character)
    {
        speed = 5;
        damage = 13;
        range = 170;
        character = _character;
    }
    
    public void act()
    {
        checkForEnemy();
        checkForCollision();
        checkForDistance(character);
        move(speed);
    }
    
    void checkForEnemy()
    {
        //Metoda scade viata inamicului cand este atins de obiect si sterge obiectul din lume
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        if(enemy != null)
        {
            enemy.setHealth(enemy.getHealth() - damage);
            getWorld().removeObject(this);
        }
    }
}
