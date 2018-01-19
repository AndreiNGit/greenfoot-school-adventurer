import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
            Hero hero = (Hero)getOneObjectAtOffset(50, 50, Hero.class);
            zDown = !zDown;
            if(zDown && hero != null)
            {
                System.out.println("true");
            }
        }
    }
}
