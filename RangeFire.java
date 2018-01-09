import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RangeFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RangeFire extends Actor
{
    private int speed = 1;
    private int damage = 15;
     
    public void shoot(RangeEnemy enemy, Character character)
    {
        World world = enemy.getWorld();
        RangeFire shoot = new RangeFire();
        world.addObject(shoot, enemy.getX(), enemy.getY());
        shoot.turnTowards(character.getX(), character.getY());
        shoot.move(speed);
        if(shoot.isTouching(Character.class))
        {
            character.setHealth(character.getHealth() - damage);
            world.removeObject(shoot);
        }
        else if (shoot.isTouching(null) || shoot.isAtEdge())
        {
            world.removeObject(shoot);
        }
    }
}
