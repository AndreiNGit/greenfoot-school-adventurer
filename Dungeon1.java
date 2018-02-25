import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon1 extends World
{
    protected final static int WIDTH = 900;
    protected final static int HEIGHT = 600;
    protected final static int CELL_SIZE = 1;
    protected static Hero hero;
    protected static Dungeon1[][] worldArr = new Dungeon1[4][4];
    protected static int room;
    protected static int level;
    
    public Dungeon1(boolean _var)
    {
        super(WIDTH, HEIGHT, CELL_SIZE);
        
        if(!_var)
        {
            hero = new Hero();
            room = 0;
            level = 0;
            
            worldArr[0][0] = new R00();
            worldArr[1][0] = new R10();
            worldArr[2][0] = new R20();
            worldArr[3][0] = new R30();
            worldArr[0][1] = new R01();
            worldArr[1][1] = new R11();
            worldArr[2][1] = new R21();
            worldArr[3][1] = new R31();
            worldArr[0][2] = new R02();
            worldArr[1][2] = new R12();
            worldArr[2][2] = new R22();
            worldArr[3][2] = new R32();
            worldArr[0][3] = new R03();
            worldArr[1][3] = new R13();
            worldArr[2][3] = new R23();
            worldArr[3][3] = new R33();
            
            worldArr[0][0].addObject(hero, WIDTH/2, HEIGHT/2);
            worldArr[0][0].addObject(hero.getHealthStatus(), WIDTH/2 - 200, 20);
            worldArr[0][0].addObject(hero.getXpStatus(), WIDTH/2 + 200, 20);
            worldArr[0][0].addObject(hero.getLvlStatus(), WIDTH/2, 20);
            
            setWorlds();
            setPaintOrder(Hero.class);
        }
    }
    
    protected void setWorlds()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                setBackground(i,j);
            }
        }
    }
    
    protected void setBackground(int i, int j)
    {
        GreenfootImage bg = new GreenfootImage(WIDTH, HEIGHT);
        bg.setColor(Color.GRAY);
        bg.fill();
        worldArr[i][j].setBackground(bg);
    }
    
    protected void prepareRoom(int width, int height, boolean upDoor, boolean downDoor, boolean rightDoor, boolean leftDoor)
    {
        int centerX = WIDTH/2;
        int centerY = HEIGHT/2;    
        int wallHeight = 50;
        
        Floor floor = new Floor(width, height);
        Wall topWall = new Wall(width + wallHeight*2, wallHeight, 1);
        Wall downWall = new Wall(width + wallHeight*2, wallHeight, 2);
        Wall rightWall = new Wall(height, wallHeight, 3);
        Wall leftWall = new Wall(height, wallHeight, 4);
        
        addObject(floor, centerX, centerY);
        addObject(topWall, centerX, centerY - height/2 - wallHeight/2);
        addObject(downWall, centerX, centerY + height/2 + wallHeight/2 - 1);
        addObject(rightWall, centerX + width/2 + wallHeight/2 - 1, centerY);
        addObject(leftWall, centerX - width/2 - wallHeight/2 + 1, centerY - 1);
        
        
        if(upDoor)
        {
            Door uDoor = new Door();
            addObject(uDoor, centerX, centerY - height/2 - wallHeight/2 + 6);
            uDoor.setImage("upDoor2.png");
        }
        if(downDoor)
        {
            Door dDoor = new Door();
            addObject(dDoor, centerX, centerY + height/2 + wallHeight/2 - 6);
            dDoor.setImage("downDoor2.png");
        }
        if(rightDoor)
        {
            Door rDoor = new Door();
            addObject(rDoor, centerX + width/2 + wallHeight/2 - 6, centerY);
            rDoor.setImage("rightDoor2.png");
        }
        if(leftDoor)
        {
            Door lDoor = new Door();
            addObject(lDoor, centerX - width/2 - wallHeight/2 + 6, centerY);
            lDoor.setImage("leftDoor2.png");
        }
    }
}