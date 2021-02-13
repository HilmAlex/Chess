package com.company.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    Player player1 = new Player();
    Player player2 = new Player();
    Game game = new Game(player1, player2);


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void check_color() {
        Assert.assertFalse(game.move(player1));
        game.setColor();
        Assert.assertTrue(game.move(player1));
    }
}