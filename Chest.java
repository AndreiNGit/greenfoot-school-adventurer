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
    private String correctChoice;
    private boolean zDown = false;
    
    public Chest(String _question, String ansA, String ansB, String ansC, String ansD, String _correctChoice)
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
    }
    
    void question(String correctAnswer)
    {
        if(zDown != Greenfoot.isKeyDown("z"))
        {
            Hero hero = (Hero)getOneObjectAtOffset(50, 50, Hero.class);
            zDown = !zDown;
            if(zDown && hero != null)
            {
                
            }
        }
    }
}
