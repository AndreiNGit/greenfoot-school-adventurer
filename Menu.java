import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    public Menu()
    {
        super(900, 600, 1);
        prepare();
    }
    
    void prepare()
    {
        StartBtn startbtn = new StartBtn();
        HelpBtn helpbtn = new HelpBtn();
        ExitBtn exitbtn = new ExitBtn();
        
        addObject(startbtn, getWidth()/2, getHeight()/2 - helpbtn.getImage().getHeight() - 30);
        addObject(helpbtn, getWidth()/2, getHeight()/2);
        addObject(exitbtn, getWidth()/2, getHeight()/2 + exitbtn.getImage().getHeight() + 30);
    }
}
