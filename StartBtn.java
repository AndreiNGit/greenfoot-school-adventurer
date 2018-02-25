import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartBtn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartBtn extends Button
{
    Dungeon1 dungeon;
    
    public StartBtn()
    {
        dungeon = new Dungeon1(false);
    }
    
    public void act() 
    {
        startGame();
    }
    
    void startGame()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(Dungeon1.worldArr[0][0]);
        }
    }
}
