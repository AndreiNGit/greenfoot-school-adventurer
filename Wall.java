import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    int width;
    int height;
    GreenfootImage tile;
    
    public Wall(int _width, int _height)
    {
        width = _width;
        height = _height;
        tile = getImage();
        tile.scale(_width, _height);
    }
}
