package com.netcracker.java_concurrency_basics;

import java.awt.*;

/**
 * Rectangular area in a coordinate space,
 * specified by a top left point, its width, height and name.
 */

//можно сделать его имьютебл
public class RectangularArea {
    private volatile String name;
    private Point topLeft;
    private int width;
    private int height;

    private final Object lockResize = new Object();
    private final Object lockTranslate = new Object();
    private final Object lockRename = new Object();

    public RectangularArea(String s, Point p, int w, int h) {
        name = s;
        topLeft = new Point(p);         //клонирование для сохранения объекта (поинт может потом модифицироваться)
        width = w;
        height = h;
    }

    public int getHeight() {
        synchronized (lockResize) {
            return height;
        }
    }

    public int getWidth() {
        synchronized (lockResize) {
            return width;
        }
    }

    public Point getLocation() {
        synchronized (lockTranslate) {
            return new Point(topLeft);
        }
    }

    public String getName() {
        return name;
    }

    public void resize(int factor) {
        synchronized (lockResize) {
            width *= factor;
            height *= factor;
        }
    }

    public void translate(Point p) {
        synchronized (lockTranslate) {
            topLeft.x += p.x;
            topLeft.y += p.y;
        }
    }

    public void rename(String s) {
            name = s;
    }
}