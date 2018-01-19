import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RangeFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireBall extends Bullet
{
    public FireBall(Character _character)
    {
        speed = 4;
        damage = 16;
        range = 150;
        character = _character;
    }
    
    public void act()
    {
        move(speed);
        checkForCollision();
        checkForDistance(character);
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
                getWorld().removeObject(this);
            }
        }
    }
}