import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    GreenfootImage floor;
    GreenfootImage tile = new GreenfootImage("upWall.png");
    
    public Wall(int _width, int _height, int direction)
    {
        if(direction == 1)
        {
            turn(0);
        }
        else if(direction == 2)
        {
            turn(180);
        }
        else if(direction == 3)
        {
            turn(90);
        }
        else if(direction == 4)
        {
            turn(270);
        }
        getImage().scale(_width, _height);
    }
}
