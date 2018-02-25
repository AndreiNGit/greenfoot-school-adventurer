import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon1 extends World
{
    protected final static int WIDTH = 800;
    protected final static int HEIGHT = 600;
    protected final static int CELL_SIZE = 1;
    protected int enemiesRemaining;
    protected static Hero hero;
    public Dungeon1(int _width, int _height, int _cellsize)
    {
        super(_width, _height, _cellsize);
    }
}