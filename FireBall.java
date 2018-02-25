import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RangeFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireBall extends Bullet
{
    private static int range = 300;
    private static int damage = 16;
    private static int speed = 4;
    
    public FireBall(Character _character)
    {
        character = _character;
    }
    
    public void act()
    {
        move(speed);
        checkForCollision();
        checkForDistance(character, range);
        checkForHero();
    }
    
    void checkForHero()
    {
        //Metoda scade viata caracterului daca este atins de obiect si sterge obiectul din lume
        if(this.getWorld() != null)
        {
            Hero hero = (Hero)getOneIntersectingObject(Hero.class);
            if(hero != null)
            {
                hero.setHealth(hero.getHealth() - this.damage);
                hero.updateHealthStatus();
                getWorld().removeObject(this);
            }
        }
    }
}