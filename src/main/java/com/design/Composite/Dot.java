package com.design.Composite;

import java.awt.*;

public class Dot extends BaseShape{
    Dot(int x, int y, Color color) {
        super(x, y, color);
    }
    private final int DOT_SIZE = 3;

    @Override
    public int getWidth() {
        return DOT_SIZE;
    }

    @Override
    public int getHeight() {
        return DOT_SIZE;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.fillRect(x - 1, y - 1, getWidth(), getHeight());
    }
}
