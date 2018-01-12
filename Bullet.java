import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    protected int damage;
    protected int range;
    protected int speed;
    protected Character character;
    
    
    void checkForCollision()
    {
        if(this.isAtEdge()) // de adaugat
        {
            getWorld().removeObject(this);
        }
    }
    
    void checkForDistance(Character _character)
    {
        if(character != null && this.getWorld() != null && character.getWorld() != null)
        {
            int dx = getDistanceX(this.getX(), _character.getX());
            int dy = getDistanceY(this.getY(), _character.getY());
            if(dx > range || dy > range || dx < -range || dy < -range)
            {
                getWorld().removeObject(this);
            }
        }
    }
    
    private int getDistanceX(int bulletX, int characterX)
    {
        return bulletX - characterX;
    }
    
    private int getDistanceY(int bulletY, int characterY)
    {
        return bulletY - characterY;
    }
}
