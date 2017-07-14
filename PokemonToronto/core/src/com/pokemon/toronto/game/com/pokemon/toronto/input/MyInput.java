package com.pokemon.toronto.game.com.pokemon.toronto.input;

/**
 * Created by Gregory on 6/5/2017.
 */
public class MyInput {
    private static boolean mouseReleased = false;
    private static boolean mouseDown = false;
    private static boolean pMouseDown = false;
    private static int[] currentMouseLocation = new int[2];
    private static boolean dragging = false;

    public static void update() {
        pMouseDown = mouseDown;
        mouseReleased = false;
        mouseDown = false;
    }

    public static void setMouseDown(boolean mouseState, int x, int y) {
        //System.out.println("x: " + x + ", y: " + y);
        mouseDown = mouseState;
        currentMouseLocation[0] = x;
        currentMouseLocation[1] = y;
    }

    public static void setMouseReleased(boolean mouseState, int x, int y) {
        //System.out.println("x: " + x + ", y: " + y);
        mouseReleased = mouseState;
        currentMouseLocation[0] = x;
        currentMouseLocation[1] = y;
    }

    public static boolean clicked() {
        return (!pMouseDown && mouseDown);
    }

    public static boolean touchReleased() {
        return mouseReleased;
    }

    public static boolean isDown() {
        return mouseDown;
    }

    public static int getX() {
        return currentMouseLocation[0];
    }

    public static int getY() {
        return currentMouseLocation[1];
    }
}
