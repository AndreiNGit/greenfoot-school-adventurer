import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.String;
/**
 * Write a description of class Hero here.
 * 
 * @author Andrei Nicusor
 * @version 1.5
 */
public class Hero extends Character
{    
    private boolean spaceDown = false;
    private boolean sDown = false;
    private boolean rewardTrigger = false;
    
    private int chooseAttack = 1;
    private int direction = 2;
    private int animationCounter = 0;
    private int animCounter = 0;
    private int maxHealth;
    private int attackCooldown;
    
    private int lvl;
    private int xp;
    private int maxXp;
    
    private SimpleTimer attackTimer = new SimpleTimer();
    private SimpleTimer meleeTimer = new SimpleTimer();
    private SimpleTimer rewardTimer = new SimpleTimer();
    
    private Label healthStatus;
    private Label lvlStatus;
    private Label xpStatus;
    Label textReward;
    
    private GreenfootImage[] noWeaponSprites = {
    new GreenfootImage("upIdle.png"),
    new GreenfootImage("upMove1.png"),
    new GreenfootImage("upMove2.png"),
    new GreenfootImage("downIdle.png"),
    new GreenfootImage("downMove1.png"),
    new GreenfootImage("downMove2.png"),
    new GreenfootImage("rightIdle.png"),
    new GreenfootImage("rightMove1.png"),
    new GreenfootImage("rightMove2.png"),
    new GreenfootImage("leftIdle.png"),
    new GreenfootImage("leftMove1.png"),
    new GreenfootImage("leftMove2.png")
    };
    
    private GreenfootImage[] meleeSprites = {
    new GreenfootImage("mUpIdle.png"),
    new GreenfootImage("mUpMove1.png"),
    new GreenfootImage("mUpMove2.png"),
    new GreenfootImage("mDownIdle.png"),
    new GreenfootImage("mDownMove1.png"),
    new GreenfootImage("mDownMove2.png"),
    new GreenfootImage("mRightIdle.png"),
    new GreenfootImage("mRightMove1.png"),
    new GreenfootImage("mRightMove2.png"),
    new GreenfootImage("mLeftIdle.png"),
    new GreenfootImage("mLeftMove1.png"),
    new GreenfootImage("mLeftMove2.png"),
    new GreenfootImage("mAttackUp.png"),
    new GreenfootImage("mAttackDown.png"),
    new GreenfootImage("mAttackRight.png"),
    new GreenfootImage("mAttackLeft.png")
    };
    
    private GreenfootImage[] rangeSprites = {
    new GreenfootImage("rUpIdle.png"),
    new GreenfootImage("rUpMove1.png"),
    new GreenfootImage("rUpMove2.png"),
    new GreenfootImage("rDownIdle.png"),
    new GreenfootImage("rDownMove1.png"),
    new GreenfootImage("rDownMove2.png"),
    new GreenfootImage("rRightIdle.png"),
    new GreenfootImage("rRightMove1.png"),
    new GreenfootImage("rRightMove2.png"),
    new GreenfootImage("rLeftIdle.png"),
    new GreenfootImage("rLeftMove1.png"),
    new GreenfootImage("rLeftMove2.png")
    };
    
    //array-ul 'currentSprites' va contine animatiile caracterului in functie de modul de atac
    private GreenfootImage[] currentSprites = new GreenfootImage[12];
    
    public Hero()
    {
        speed = 3;
        damage = 20;
        maxHealth = 80;
        health = maxHealth;
        attackCooldown = 1000;
        lvl = 1;
        xp = 0;
        maxXp = 12;
        System.arraycopy(meleeSprites, 0, currentSprites, 0, 12);
        
        lvlStatus = new Label("Nivel: " + lvl, 30);
        xpStatus = new Label("Xp: " + xp + "/" + maxXp, 30);
        healthStatus = new Label("Viata: " + health + "/" + maxHealth, 30);
    }

    public void act() 
    {
        //System.out.println("arr[" + Dungeon1.room +"][" + Dungeon1.level +"]");
        idleAnimation();
        move();
        attack();
        meleeAnim();
        changeAttackStart();
        changeAttackCooldown();
        showReward();
        gameOver();
    }
    
    
    /**
     * Method move
     *
     * Functia ajuta la deplasarea si animarea caracterului 
     */
    void move()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            direction = 1;
            if(upCollision()) //executa miscarea daca nu exista un zid in fata
            {
                movingAnimation(currentSprites[0], currentSprites[1], currentSprites[2]);
                setLocation(getX(), getY() - speed);
            }
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            direction = 2;
            if(downCollision())
            {
                movingAnimation(currentSprites[3], currentSprites[4], currentSprites[5]);
                setLocation(getX(), getY() + speed);
            }
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            direction = 3;
            if(rightCollision())
            {
                movingAnimation(currentSprites[6], currentSprites[7], currentSprites[8]);
                setLocation(getX() + speed, getY());
            }
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            direction = 4;
            if(leftCollision())
            {
                movingAnimation(currentSprites[9], currentSprites[10], currentSprites[11]);
                setLocation(getX() - speed, getY());
            }
        }
    }
    
    /**
     * Method movingAnimation
     *
     * @param idle 
     * @param mv1 
     * @param mv2
     * 
     * Metoda animeaza miscarea caracterului prin schimbarea treptata a pozitiei la fiecare 10 act-uri
     */
    void movingAnimation(GreenfootImage idle, GreenfootImage mv1, GreenfootImage mv2)
    {
        animationCounter++;
        if (animationCounter == 5)
        {
            setImage(mv1);
        }
        if (animationCounter == 15)
        {
            setImage(idle);
        }
        if (animationCounter == 25)
        {
            setImage(mv2);
        }
        if (animationCounter == 35)
        {
            setImage(idle);
            animationCounter = 0;
        }
    }
    
    /**
     * Method idleAnimation
     *
     *  Metoda readuce caracterul in pozitia "idle" dupa ce miscarea este finalizata pentru a preveni animatia eronata
     */
    void idleAnimation()
    {
        if(animCounter == 0) //daca nu ruleaza animatia de atac atunci ruleaza animatia idle
        {
            if(!Greenfoot.isKeyDown("up") && direction == 1)
            {
                setImage(currentSprites[0]);
            }
            else if(!Greenfoot.isKeyDown("down") && direction == 2)
            {
                setImage(currentSprites[3]);
            }
            else if(!Greenfoot.isKeyDown("right") && direction == 3)
            {
                setImage(currentSprites[6]);
            }
            else if(!Greenfoot.isKeyDown("left") && direction == 4)
            {
                setImage(currentSprites[9]);
            }
        }
    }
    
    /**
     * Collision System
     * 
     * Sistemul de coliziune este format din functiile upCollision, downCollision, rightCollision si leftCollision
     * 
     * Sistemul impiedica trecerea prin obiecte solide a caracterului (pereti, inamici)
     */
    boolean upCollision()
    {
        Actor upWall = getOneObjectAtOffset(0, -30, Wall.class);
        Actor upEnemy = getOneObjectAtOffset(0, -30, Enemy.class);
        if(upWall != null || upEnemy != null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    boolean downCollision()
    {
        Actor downWall = getOneObjectAtOffset(0, 30, Wall.class);
        Actor downEnemy = getOneObjectAtOffset(0, 30, Enemy.class);
        if(downWall != null || downEnemy != null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    boolean rightCollision()
    {
        Actor rightWall = getOneObjectAtOffset(15, 0, Wall.class);
        Actor rightEnemy = getOneObjectAtOffset(15, 0, Enemy.class);
        if(rightWall != null || rightEnemy != null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    boolean leftCollision()
    {
        Actor leftWall = getOneObjectAtOffset(-15, 0, Wall.class);
        Actor leftEnemy = getOneObjectAtOffset(-15, 0, Enemy.class);
        if(leftWall != null || leftEnemy != null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    
    /**
     * Attack System
     *
     * Sistemul de atac este format din functiile attack, changeAttackStart, changeAttackCooldown, meleeAnim, meleeAtack, toggleMeleeAnim si rangeAttack
     * 
     * Sistemul permite caracterului sa atace un inamic atat din apropiere cat si de la departare
     * 
     * !!In momentul in care se comuta intre cele doua atacuri caracterul nu va putea ataca pentru o perioada de timp
     * 
     *  Method attack
     *  
     *  Metoda permite caracterului sa atace in modul stabilit folosind tasta space
     */
    void attack()
    {
        if(Greenfoot.isKeyDown("space") && attackTimer.millisElapsed() > attackCooldown)
        {
            if(chooseAttack == 1)
            {
                animCounter++; //porneste timer-ul pentru animatie
                meleeAttack();
            }
            else if(chooseAttack == 2)
            {
                rangeAttack();
            }
            attackTimer.mark(); //folosit pentru cooldown
        }
    }

    /**
     * Method changeAttackStart
     *
     * Metoda permite caracterului sa comute intre cele doua moduri de atac folosind tasta 's'
     * 
     * Va exista o perioada scurta in care eroul nu va putea ataca atunci cand va schimba armele
     */
    void changeAttackStart()
    {
        //Daca tasta 's' este apasata atunci caracterul comuta intre cele doua moduri de atac
        if(sDown != Greenfoot.isKeyDown("s"))
        {
            sDown = !sDown;
            if(sDown)
            {
                frameCounter = 1; //se atribuie valoarea 1 pentru a executa metoda changeAttackCoolDown()
                
                //3,4 sunt valori reziduale folosite pentru a evita folosirea atacului in timpul schimbului
                
                System.arraycopy(noWeaponSprites, 0, currentSprites, 0, 12); //Schimba setul de animatii al caracterului
                if(chooseAttack == 1)
                {
                    chooseAttack = 3;
                }
                else if(chooseAttack == 2)
                {
                    chooseAttack = 4;
                }
            }
        }
    }

    /**
     * Method changeAttackCooldown
     *
     * Metoda functioneaza ca un timer pentru schimbarea atacului si se ocupa si de schimbarea animatiei
     */
    void changeAttackCooldown()
    {
        if (frameCounter >= 1 && frameCounter <= 100)
        {
            frameCounter++;
            if(chooseAttack == 4 && frameCounter == 100)
            {
                System.arraycopy(meleeSprites, 0, currentSprites, 0, 12);
                chooseAttack = 1;
                frameCounter = 0; //se atribuie valoarea 0 pentru a opri din executie metoda
            }
            else if(chooseAttack == 3 && frameCounter == 100)
            {
                System.arraycopy(rangeSprites, 0, currentSprites, 0, 12);
                chooseAttack = 2;
                frameCounter = 0;
            }
        }
    }
    
    /**
     * Method meleeAnim
     *
     *  Functia se ocupa de animatia de atac de aproape in functie de orientare
     */
    void meleeAnim()
    {
        if(animCounter >= 1)
        {
            animCounter++;
            if(direction == 1)
            {
                togglMeleeAnim(currentSprites[0], meleeSprites[12]);
            }
            if(direction == 2)
            {
                togglMeleeAnim(currentSprites[3], meleeSprites[13]);
            }
            if(direction == 3)
            {
                togglMeleeAnim(currentSprites[6], meleeSprites[14]);
            }
            if(direction == 4)
            {
                togglMeleeAnim(currentSprites[9], meleeSprites[15]);
            }
        }
    }
    
    /**
     * Method togglMeleeAnim
     *
     * @param idle
     * @param attack 
     * 
     * Functia se ocupa cu schimbul frame-urilor din animatie
     */
    void togglMeleeAnim(GreenfootImage idle, GreenfootImage attack)
    {
        if(animCounter == 5)
        {
            setImage(attack);
        }
        if(animCounter == 15)
        {
            setImage(idle);
            animCounter = 0;
        }
    }
    
    /**
     * Method meleeAttack
     *
     * Functia se ocupa cu atacul inamicului
     */
    void meleeAttack()
    {
        //Caracterul ataca inamicul cu care se intersecteaza
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        if(enemy != null)
        {
            enemy.setHealth(enemy.getHealth() - damage);
        }
    }

    /**
     * Method rangeAttack
     *
     * Functia se ocupa cu atacul de la distanta
     *
     * Functia creaza obiecte in functie de orientarea caracterului
     */
    void rangeAttack()
    {
        //Caracterul ataca de la distanta folosind obiectele din clasa Arrow
        Arrow arrow = new Arrow(this);
        getWorld().addObject(arrow, getX(), getY());
        //Setarea directiei sagetii in functie de orientarea caracterului
        if(direction == 1)
        {
            arrow.setRotation(270);
        }
        if(direction == 2)
        {
            arrow.setRotation(90);
        }
        if(direction == 3)
        {
            arrow.setRotation(0);
        }
        if(direction == 4)
        {
            arrow.setRotation(180);
        }
    }
        
    /**
     * Method Status
     * 
     * Functia se ocupa cu actualizarea cantitatii de viata ramasa si totala a caracterului
     */
    void updateHealthStatus()
    {
        if(health >= 0)
        {
            healthStatus.setValue("Health: " + health + "/" + maxHealth);
        }
        else
        {
            healthStatus.setValue("Health: " + 0  + "/" + maxHealth);
        }
        healthStatus.updateImage();
    }
    
    /**
     * Method addXp
     *
     * @param _amount Cantitatea de experienta adaugata
     * 
     * Functia adauga experienta caracterului
     */
    void addXp(int _amount)
    {
        xp += _amount;
        if(xp >= maxXp)
        {
            xp -= maxXp;
            lvl++;
            lvlStatus.setValue("Nivel: " + lvl);
            lvlStatus.updateImage();
            levelUpReward();
            maxXp += (int)maxXp/4; // La fiecare nivel adauga 1/4 exp in plus fata de nivelul anterior
        }
        xpStatus.setValue("Xp:" + xp + "/" + maxXp);
        xpStatus.updateImage();
    }
    
    /**
     * Method levelUpReward
     *
     * Se ocupa cu recompensa jucatorului pentru cresterea in nivel
     * 
     * Recompensa este aleasa aleatoriu si calculata in functie de nivel
     */
    void levelUpReward()
    {
        int reward = Greenfoot.getRandomNumber(7);
        switch(reward)
        {
            case 0: //ii mareste viata maxima
                maxHealth += 10 + 5*lvl;
                health += 10 + 5*lvl;
                textReward = new Label("Viata maxima a crescut la " + maxHealth + " si ai fost vindecat cu " + 10 + 5*lvl + "HP", 30);
                updateHealthStatus();
                break;
                
            case 1: // ii mareste damage-ul
                damage += 2 + lvl;
                textReward = new Label("Atacul a crescut la " + damage, 30);
                break;
                
            case 2: //vindeca eroul
                health = maxHealth;
                updateHealthStatus();
                textReward = new Label("Ai fost vindecat", 30);
                break;
                
            case 3: //creste viteza de atac la distanta
                Arrow.setSpeed(Arrow.getSpeed() + 1);
                textReward = new Label("Viteza atacului la distanta a crescut", 30);
                break;
                
            case 4: //creste damage-ul
                Arrow.setDamage(Arrow.getDamage() + 3 + lvl);
                textReward = new Label("Daunele atacului la distanta a crescut la " + Arrow.getDamage(), 30);
                break;
                
            case 5: //creste viteza de atac
                attackCooldown -= lvl*15;
                textReward = new Label("Viteza de atac a crescut", 30);
                break;
                
            case 6: //Creste viteza de miscare
                speed += 1;
                textReward = new Label("Viteza de miscare a crescut", 30);
                break;
        }
        rewardTrigger = true;
        rewardTimer.mark();
        getWorld().addObject(textReward, Dungeon1.WIDTH/2, 60);
    }
    
    /**
     * Method showReward
     *
     * Functia sterge dupa un anumit timp textul pe care se afla recompensa pentru cresterea in nivel
     */
    void showReward()
    {
        if(rewardTrigger && rewardTimer.millisElapsed() > 3600)
        {
            getWorld().removeObject(textReward);
            rewardTrigger = false;
        }
    }
    
    /**
     * Method gameOver
     *
     * Functia se ocupa cu sfarsitul jocului daca eroul ramane fara viata
     */
    void gameOver()
    {
        //Opreste jocul in momentul in care caracterul moare
        if (health <= 0)
        {
            Greenfoot.setWorld(new GameOver());
        }
    }
    
    public Label getHealthStatus()
    {
        return healthStatus;
    }
    
    public Label getXpStatus()
    {
        return xpStatus;
    }
    
    public Label getLvlStatus()
    {
        return lvlStatus;
    }
    
    public int getAttackCooldown()
    {
        return attackCooldown;
    }
    
    public void setAttackCooldown(int _amount)
    {
        attackCooldown = _amount;
    }
    
        public int getDamage()
    {
        return damage;
    }
    
    public void setDamage(int _amount)
    {
        damage = _amount;
    }
}