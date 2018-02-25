import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Boss extends Enemy
{
    private boolean attacked = false;
    private SimpleTimer attackTimer = new SimpleTimer();
    private int attackMillis;
    private Label healthStatus;
    
    public Boss()
    {
        health = 500;
        attackMillis = 2300;
        speed = 1;
        
        attackTimer.mark();
        healthStatus = new Label("Viata inamicului: " + health, 30);
    }
    
    public void act() 
    {
        randomMove();
        collision();
        rangeAttack();
        winGame();
        updateHealthStatus();
    }
    
    void rangeAttack()
    {
        if(health <= 350)
        {
            attackMillis = 900;
        }
        else if(health <= 400)
        {
            attackMillis = 1300;
        }
        else if(health <= 450)
        {
            attackMillis = 1700;
        }
        
        if(attackTimer.millisElapsed() > attackMillis)
        {
            for(int i = 0; i < 8; i++)
            {
                FireBall fireball = new FireBall(this);
                getWorld().addObject(fireball, this.getX(), this.getY());
                fireball.turn(45*i);
            }
            attackTimer.mark();
        }
    }
    
    void updateHealthStatus()
    {
        healthStatus.setValue("Viata inamicului: " + health);
        healthStatus.updateImage();
        getWorld().addObject(healthStatus, Dungeon1.WIDTH/2, 60);
    }
    
    void winGame()
    {
        if(this.health <= 0)
        {
            Greenfoot.setWorld(new Win());
        }
    }
}
