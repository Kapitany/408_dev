package com.haramiak.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Launcher extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img;
    private int imgX, imgY;
    private boolean incrementX, incrementY;

    @Override
    public void create() {
        imgX = 0;
        imgY = 50;
        incrementX = false;
        incrementY = false;
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
    }

    private void update() {
        if (imgX == Gdx.app.getGraphics().getWidth()) {
            incrementX = false;
        } else if (imgX == 0) {
            incrementX = true;
        }
        if (imgY == Gdx.app.getGraphics().getHeight()) {
            incrementY = false;
        } else if (imgY == 0) {
            incrementY = true;
        }
        if (incrementX) {
            imgX++;
        } else {
            imgX--;
        }
        if (incrementY) {
            imgY++;
        } else {
            imgY--;
        }
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, imgX, imgY);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
