package com.pokemon.toronto.game.com.pokemon.toronto.input;

import com.badlogic.gdx.Gdx;

/**
 * Created by Gregory on 6/5/2017.
 */
public class MyInput {
    //Variables
    private static boolean mouseReleased = false;
    private static boolean mouseDown = false;
    private static boolean pMouseDown = false;
    private static int[] currentMouseLocation = new int[2];
    private static boolean dragging = false;

    private static boolean tapped = false;

    private static boolean panning = false;
    private static float deltaX = 0;
    private static float deltaY = 0;

    public static void pan(int x, int y, float dx, float dy) {
        panning = true;
        deltaX = dx;
        deltaY = dy;
        currentMouseLocation[0] = x;
        currentMouseLocation[1] = y;
    }

    public static void stopPan() {
        panning = false;
    }

    public static void resetDeltas() {
        deltaX = 0;
        deltaY = 0;
    }

    public static boolean isPanning() {
        return panning;
    }

    public static float getDeltaX() {
        return deltaX;
    }

    public static float getDeltaY() {
        return deltaY;
    }

    public static void tap(int x, int y) {
        currentMouseLocation[0] = x;
        currentMouseLocation[1] = y;
        tapped = true;
    }

    public static boolean tapped() {
        return tapped;
    }


    public static void setDrag() {
        dragging = true;
    }

    public static void stopDrag() {
        dragging = false;
    }

    public static boolean isDragging() {
        return dragging;
    }
    /**
     * Update the touch.
     * - Set previous mouse state to the current mouse state
     * - Reset current mouse state
     */
    public static void update() {
        tapped = false;
        pMouseDown = mouseDown;
        mouseReleased = false;
        mouseDown = false;
    }

    /**
     * Set the mouse down at location (x, y)
     * @param x The x location of the mouse down.
     * @param y The y location of the mouse down.
     */
    public static void setMouseDown(int x, int y) {
        mouseDown = true;
        currentMouseLocation[0] = x;
        currentMouseLocation[1] = y;
    }

    /**
     * Set the mouse release location at (x, y)
     * @param x The x location of the mouse release.
     * @param y The y location of the mouse release.
     */
    public static void setMouseReleased(int x, int y) {
        mouseReleased = true;
        dragging = false;
        currentMouseLocation[0] = x;
        currentMouseLocation[1] = y;
    }

    /**
     * Return whether or not a click happened.
     * A click occurs when the previous mouse state was up
     *  and the current state is down.
     * @return Whether or not a click occurred.
     */
    public static boolean clicked() {
        return (!pMouseDown && mouseDown);
    }


    /**
     * Return whether or not the touch has been just released.
     * @return Whether or not a touch release happened.
     */
    public static boolean touchReleased() {
        return mouseReleased;
    }

    /**
     * Return whether or not the touch is down.
     * @return Whether or not the touch is down.
     */
    public static boolean isDown() {
        return mouseDown;
    }


    /**
     * Return the current x location.
     * @return The x location.
     */
    public static int getX() {
        return currentMouseLocation[0];
    }

    /**
     * Return the current y location.
     * @return The y location.
     */
    public static int getY() {
        return currentMouseLocation[1];
    }
}
