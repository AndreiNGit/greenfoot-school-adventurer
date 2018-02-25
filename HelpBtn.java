import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpBtn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpBtn extends Button
{
    Help help;
    
    public HelpBtn()
    {
        help = new Help();
    }
    
    public void act() 
    {
        helpMenu();
    }
    
    void helpMenu()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(help);
        }
    }
}
