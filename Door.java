import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    World nextRoom;
    
    public Door(World _nextRoom)
    {
        nextRoom = _nextRoom;
    }
    
    public void act() 
    {
        nextRoom(nextRoom);
    }
    
    public void nextRoom(World nextWorld)
    {
        if(getWorld().getObjects(Enemy.class).isEmpty())
        {
            Hero hero = (Hero)getOneIntersectingObject(Hero.class);
            if(hero != null)
            {
                nextWorld.addObject(hero,100,150);
                Greenfoot.setWorld(nextWorld);
            }
        }
    }
}
