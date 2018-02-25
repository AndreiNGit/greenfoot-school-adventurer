import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    private boolean doorClosed = true;
    
    public void act() 
    {
        changeRoom();
        openDoor();
    }
    
    public void changeRoom()
    {
        List<Hero> hero = getObjectsInRange(50, Hero.class);
        
        if (!hero.isEmpty() && getWorld().getObjects(Enemy.class).isEmpty())
        {
            int dx = 0;
            int dy = 0;
            if (getX() < getWorld().getWidth()/2)
            {
                dx--;
            }
            if (getX() >  getWorld().getWidth()/2)
            {
                dx++;
            }
            if (getY() <  getWorld().getHeight()/2)
            {
                dy++;
            }
            if (getY() >  getWorld().getWidth()/2)
            {
                dy--;
            }
            Dungeon1.room += dx;
            Dungeon1.level += dy;
            
            Dungeon1 gotoWorld = Dungeon1.worldArr[Dungeon1.room][Dungeon1.level];
            gotoWorld.addObject(hero.get(0), Dungeon1.WIDTH/2, Dungeon1.HEIGHT/2);
            gotoWorld.addObject(hero.get(0).getHealthStatus(), Dungeon1.WIDTH/2 - 200, 20);
            gotoWorld.addObject(hero.get(0).getXpStatus(), Dungeon1.WIDTH/2 + 200, 20);
            gotoWorld.addObject(hero.get(0).getLvlStatus(), Dungeon1.WIDTH/2, 20);
            Greenfoot.setWorld(gotoWorld);
        }
    }
    
    void openDoor()
    {
        if(doorClosed)
        {
            if(getWorld().getObjects(Enemy.class).isEmpty())
            {
                if (getX() < getWorld().getWidth()/2)
                {
                    setImage("leftDoor1.png");
                }
                if (getX() >  getWorld().getWidth()/2)
                {
                    setImage("rightDoor1.png");
                }
                if (getY() <  getWorld().getHeight()/2)
                {
                    setImage("upDoor1.png");
                }
                if (getY() >  getWorld().getWidth()/2)
                {
                    setImage("downDoor1.png");
                }
                doorClosed = false;
            }
        }
    }
}
