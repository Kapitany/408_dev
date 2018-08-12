package com.haramiak.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Launcher extends ApplicationAdapter {

    SpriteBatch batch;
    Texture background;
    Texture kalman;
    Texture bush;

    int kalmanX, kalmanY;
    boolean lastloopD, lastloopA;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("house.jpg");
        kalman = new Texture("kalman.png");
        kalmanX = 0;
        kalmanY = -35;
        lastloopA = lastloopD = false;
    }

    private void update() {
        if (lastloopD) {
            kalmanX+=2;
            kalmanY-=2;
            lastloopD = false;
        }
        if (lastloopA) {
            kalmanX-=2;
            kalmanY-=2;
            lastloopA = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            kalmanX+=2;
            kalmanY+=2;
            lastloopD = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            kalmanX-=2;
            kalmanY+=2;
            lastloopA = true;
        }
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(kalman, kalmanX, kalmanY);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        kalman.dispose();
    }
}
