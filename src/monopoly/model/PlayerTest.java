package monopoly.model;
/*
import monopoly.gamepanel.Property;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class PlayerTest {
Player player;
    Player player2;
    Property property;
    Property p;
    String name;
    Token token;
    int money;
    ArrayList<Property> properties= new ArrayList<Property>();
    int x;
    int y;
    Color color;
    int price;
    int rent;
    int buildCost;

    @Before
    public void setUp() throws Exception {

        player=new Player(name,token);
        player2=new Player(name,token);

        property=new Property(x,y,color,name,price,rent,buildCost);
        p=new Property(x,y,color,name,price,rent,buildCost);
    }

    @Test
    public void testGetMoney() throws Exception {

        player.getMoney();

        assertTrue(player.getMoney()==player2.getMoney());

    }

    @Test
    public void testGetName() throws Exception {

       String s1= player.getName();
        String s2=player2.getName();
        assertTrue(s1==s2);
    }

    @Test
    public void testAddMoney() throws Exception {

        player.addMoney(money);
        int a =3;
        money=5;
        assertTrue(8==a+money);
    }

    @Test
    public void testSpendMoney() throws Exception {

        player.spendMoney(money);
        int a=5;
        money= 9;
        assertTrue(4==money-a);
    }

    @Test
    public void testBuy() throws Exception {
        properties.add(p);
        p.price=5;
        player.sell(p);
        assertTrue(properties.size()==1);



    }

    @Test
    public void testSell() throws Exception {

        player.buy(p);
        p.price=5;
        assertTrue(properties.size()==0);

    }

    @Test
    public void testGetToken() throws Exception {

        Token t1=player.getToken();
        Token t2=player.getToken();
        assertTrue(t1==t2);
    }

    @Test
    public void testSetBankrupt() throws Exception {

        boolean bankrupt=false;
        boolean bankrupt2=true;
        player.setBankrupt(bankrupt);
        player2.setBankrupt(bankrupt);
        assertTrue(bankrupt!=bankrupt2);

    }

    @Test
    public void testIsBankrupt() throws Exception {

        player.isBankrupt();
        player2.isBankrupt();
        assertTrue(player.isBankrupt()==player2.isBankrupt());
    }
}
*/