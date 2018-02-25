import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackBtn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackBtn extends Button
{
    public void act() 
    {
        back();
    }    
    
    void back()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Menu());
        }
    }
}
