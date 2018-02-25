import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LastScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LastScreen extends World
{

    /**
     * Constructor for objects of class LastScreen.
     * 
     */
    public LastScreen()
    {
        super(900, 600, 1); 
    }
    
    void backToMenu()
    {
        if(Greenfoot.mouseClicked(null))
        {
            Greenfoot.setWorld(new Menu());
        }
    }
}
