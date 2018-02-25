import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon here.
 * 
 * @author Andrei Nicusor
 * @version 1.1
 */
public class Dungeon extends World
{

    public Dungeon()
    {    
        super(800, 600 ,1);
        prepare();
    }
    
    private void prepare()
    {
        Hero hero = new Hero();
        addObject(hero,731,334);
        HealthStatus healthstatus = new HealthStatus(hero);
        addObject(healthstatus,97,54);
        RangeEnemy rangeenemy = new RangeEnemy(hero);
        addObject(rangeenemy,188,225);
        RangeEnemy rangeenemy2 = new RangeEnemy(hero);
        addObject(rangeenemy2,190,342);
        CloseEnemy closeenemy = new CloseEnemy(hero);
        addObject(closeenemy,723,54);
        CloseEnemy closeenemy2 = new CloseEnemy(hero);
        addObject(closeenemy2,534,62);
        rangeenemy.setLocation(173,181);
        rangeenemy2.setLocation(189,347);
        Chest chest = new Chest("a", " ", " ", " ", " ", 'a');
        addObject(chest,614,585);
        Wall wall = new Wall(20, 100);
        addObject(wall,421,352);
        Wall wall2 = new Wall(100, 100);
        addObject(wall2,230,469);
        wall2.setLocation(131,474);
        removeObject(wall2);
        removeObject(wall);
        Wall wall3 = new Wall(800, 20);
        addObject(wall3,70,426);
        wall3.setLocation(399,592);
        Wall wall4 = new Wall(800, 20);
        addObject(wall4,426,17);
        wall4.setLocation(401,9);
        Wall wall5 = new Wall(20, 600);
        addObject(wall5,43,312);
        wall5.setLocation(10,289);
        Wall wall6 = new Wall(20, 600);
        addObject(wall6,494,323);
        wall6.setLocation(494,323);
        wall6.setLocation(494,323);
        wall6.setLocation(494,323);
        wall6.setLocation(494,323);
        wall6.setLocation(494,323);
        wall6.setLocation(494,323);
        wall6.setLocation(790,294);
    }
}
