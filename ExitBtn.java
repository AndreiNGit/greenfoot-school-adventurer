import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExitBtn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitBtn extends Button
{    
    public void act() 
    {
        exitGame();
    }
    
    void exitGame()
    {
        if(Greenfoot.mouseClicked(this))
        {
            System.exit(1);
        }
    }
}
