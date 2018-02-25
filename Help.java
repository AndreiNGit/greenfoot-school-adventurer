import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help extends World
{
    public Help()
    {    
        super(900, 600, 1); 
        
        BackBtn backbtn = new BackBtn();
        int dxBtn = getWidth()/2;
        int dyBtn = getHeight() - backbtn.getImage().getHeight();
        addObject(backbtn, dxBtn, dyBtn);
    }
}
