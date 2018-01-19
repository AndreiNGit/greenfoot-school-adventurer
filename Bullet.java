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
        if(this.getWorld() != null && character.getWorld() != null)
        {
            if(this.isAtEdge()) // de adaugat
            {
                getWorld().removeObject(this);
            }
        }
    }
    
    void checkForDistance(Character _character)
    {
        //Metoda sterge obiectul din lume cand depaseste o anumita distanta fata de npc/caracter
        if(this.getWorld() != null && character.getWorld() != null)
        {
            int dx = getDistanceX(this.getX(), _character.getX());
            int dy = getDistanceY(this.getY(), _character.getY());
            if(dx > range || dy > range || dx < -range || dy < -range)
            {
                getWorld().removeObject(this);
            }
        }
    }
    
    int getDistanceX(int bulletX, int characterX)
    {
        return bulletX - characterX;
    }
    
    int getDistanceY(int bulletY, int characterY)
    {
        return bulletY - characterY;
    }
}
