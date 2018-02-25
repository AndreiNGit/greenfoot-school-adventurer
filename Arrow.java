import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RangeFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Bullet
{
    private static int range = 300;
    private static int speed = 5;
    private static int damage = 13;
    
    public Arrow(Character _character)
    {
        character = _character;
    }
    
    public void act()
    {
        checkForEnemy();
        checkForCollision();
        checkForDistance(character, range);
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
    
    public static void setRange(int _val)
    {
        range = _val;
    }
    
    public static void setSpeed(int _val)
    {
        speed = _val;
    }
    
    public static void setDamage(int _val)
    {
        damage = _val;
    }
    
    public static int getRange()
    {
        return range;
    }
    
    public static int getDamage()
    {
        return damage;
    }
    
    public static int getSpeed()
    {
        return speed;
    }
}
