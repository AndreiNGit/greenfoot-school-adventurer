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
    private boolean zDown = false;
    private boolean openChest = true;
     
    private int noChoices = 3;
    private Label text = new Label("",30);
    private SimpleTimer textTimer = new SimpleTimer();
     
    private MouseInfo mouse;
    public void act() 
    {
        openChest();
        breakChest();
        removeText();
        clickLock();
         
        mouse = Greenfoot.getMouseInfo();
    }
     
    void openChest()
    {
        List<Hero> heroList = getObjectsInRange(70, Hero.class);
        if(getWorld().getObjects(Enemy.class).isEmpty() && !heroList.isEmpty() && openChest)
        {
            if(Greenfoot.isKeyDown("z"))
            {
                addLocks();
                openChest = false;             
            }
        }
    }
     
    public void addLocks()
    {
        int locks = 6;
        int goodLockPlace = Greenfoot.getRandomNumber(locks);
        for(int i = 0; i < locks; i++)
        {
            int x = Dungeon1.WIDTH/2 - 120 + 60*i;
            if(i == goodLockPlace)
            {
                getWorld().addObject(new GoodLock(), x, Dungeon1.HEIGHT/2);
            }
            else
            {
                getWorld().addObject(new WrongLock(), x, Dungeon1.HEIGHT/2);
            }
        }
    }
     
    void breakChest()
    {
        if(noChoices <= 0)
        {
            addText("Ai ramas fara incercari.Incuietoarea s-a stricat.");
            getWorld().removeObjects(getWorld().getObjects(WrongLock.class));
            getWorld().removeObjects(getWorld().getObjects(GoodLock.class));
        }
    }
     
    void clickLock()
    {
        if (mouse != null)
        {
            int click = mouse.getButton();
            if(mouse.getActor() instanceof WrongLock && click == 1)
            {
                wrongLock();
                getWorld().removeObject(mouse.getActor());
            }
            else if(mouse.getActor() instanceof GoodLock && click == 1)
            {
                chestReward();
                getWorld().removeObjects(getWorld().getObjects(WrongLock.class));
                getWorld().removeObject(mouse.getActor());
            }
        }
    }
     
    void wrongLock()
    {
        noChoices--;
        if(noChoices > 0)
        {
            addText("Ai gresit lacatul.Incercari ramase: " + noChoices);
        }
    }
     
    void chestReward()
    {
        int reward = Greenfoot.getRandomNumber(7);
        Hero hero = Dungeon1.hero;
        switch(reward)
        {
            case 0:
                int bonusHealth = Greenfoot.getRandomNumber(20);
                hero.setHealth(hero.getHealth() + bonusHealth);
                addText("Ai primit " + bonusHealth + " puncte de viata");
                break;
                 
            case 1:
                hero.setDamage(hero.getDamage() + Greenfoot.getRandomNumber(10));
                addText("Atacul a crescut la " + hero.getDamage());
                break;
                 
            case 2:
                Arrow.setDamage(Arrow.getDamage() + Greenfoot.getRandomNumber(10));
                addText("Atacul la distanta a crescut la " + Arrow.getDamage());
                break;
                 
            case 3:
                hero.setAttackCooldown(hero.getAttackCooldown() - Greenfoot.getRandomNumber(30));
                addText("Viteza de atac a crescut");
                break;
            case 5:
             
            case 6:
                addText("Ai deschis cufarul, dar nu ai gasit nimic.");
                break;
        }
    }
     
    void addText(String _text)
    {
        if(text != null)
        {
            getWorld().removeObject(text);
        }
        text = new Label(_text, 30);
        getWorld().addObject(text, Dungeon1.WIDTH/2, 60);
        textTimer.mark();
    }
      
    void removeText()
    {
        if (text != null && textTimer.millisElapsed() > 1500)
        {
            getWorld().removeObject(text);
            text = null;
        }
    }
}