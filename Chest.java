import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Chest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chest extends Actor
{
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private char correctChoice;
    private boolean zDown = false;
    private int noChoice = 3;
    private int windowWidth = 150;
    private int windowsHeight = 150;
    
    public Chest(String _question, String ansA, String ansB, String ansC, String ansD, char _correctChoice)
    {
        question = _question;
        answerA = ansA;
        answerB = ansB;
        answerC = ansC;
        answerD = ansD;
        correctChoice = _correctChoice;
    }
    
    public void act() 
    {
        question(correctChoice);
    }
    
    void question(char _correctChoice)
    {
        if(zDown != Greenfoot.isKeyDown("z"))
        {
            List<Hero> hero = getObjectsInRange(100, Hero.class);
            zDown = !zDown;
            if(zDown && !hero.isEmpty())
            {
                System.out.println("true");
                drawWindow(question, answerA, answerB, answerC, answerD);
            }
        }
    }
    
    void drawWindow(String _question, String ansA, String ansB, String ansC, String ansD)
    {
        GreenfootImage background = new GreenfootImage(windowWidth, windowsHeight);
        background.drawRect(getWorld().getWidth()/2, getWorld().getHeight()/2, windowWidth, windowsHeight);
        background.setColor(Color.WHITE);
        background.fillRect(getWorld().getWidth()/2, getWorld().getHeight()/2, windowWidth, windowsHeight);
        setImage(background);
    }
}
