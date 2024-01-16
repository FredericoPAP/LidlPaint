import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls  implements KeyboardHandler {

    private Player player;
    private boolean spacePressed;
    private boolean deletePressed;

    private Grid grid;

    public Controls (Player player, Grid grid) {
        this.player = player;
        this.grid= grid;
        init();
    }

    private void init() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent pressedUp = new KeyboardEvent();
        pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedUp.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(pressedUp);

        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(pressedDown);

        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(pressedLeft);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(pressedRight);

        KeyboardEvent pressedSpace = new KeyboardEvent();
        pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(pressedSpace);

        KeyboardEvent releasedSpace = new KeyboardEvent();
        releasedSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(releasedSpace);

        KeyboardEvent pressedD = new KeyboardEvent();
        pressedD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedD.setKey(KeyboardEvent.KEY_D);
        keyboard.addEventListener(pressedD);

        KeyboardEvent releasedD = new KeyboardEvent();
        releasedD.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedD.setKey(KeyboardEvent.KEY_D);
        keyboard.addEventListener(releasedD);

        KeyboardEvent pressedS = new KeyboardEvent();
        pressedS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedS.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(pressedS);

        KeyboardEvent pressedC = new KeyboardEvent();
        pressedC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedC.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(pressedC);

        KeyboardEvent pressedL = new KeyboardEvent();
        pressedL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedL.setKey(KeyboardEvent.KEY_L);
        keyboard.addEventListener(pressedL);

    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int keyboardKey = keyboardEvent.getKey();

        switch (keyboardKey) {

            case KeyboardEvent.KEY_UP:
                if (deletePressed) {
                    player.delete();
                }
                if (spacePressed) {
                    player.draw();
                }
                player.moveUp();

                break;
            case KeyboardEvent.KEY_DOWN:
                if (deletePressed) {
                    player.delete();
                }
                if (spacePressed) {
                    player.draw();
                }
                player.moveDown();

                break;
            case KeyboardEvent.KEY_RIGHT:
                if (deletePressed) {
                    player.delete();
                }
                if (spacePressed) {
                    player.draw();
                }
                player.moveRight();
                break;
            case KeyboardEvent.KEY_LEFT:
                if (deletePressed) {
                    player.delete();
                }
                if (spacePressed) {
                    player.draw();
                }
                player.moveLeft();
                break;
            case KeyboardEvent.KEY_SPACE:
                player.draw();
                spacePressed = true;
                break;
            case KeyboardEvent.KEY_D:
                player.delete();
                deletePressed = true;
                break;
            case KeyboardEvent.KEY_S:
                grid.saveFile();
                break;
            case KeyboardEvent.KEY_C:
                grid.cleanGrid();
                break;
            case KeyboardEvent.KEY_L:
                grid.loadFile();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        int keyboardKey = keyboardEvent.getKey();

        switch (keyboardKey) {
            case KeyboardEvent.KEY_SPACE:
                spacePressed = false;
                break;
            case KeyboardEvent.KEY_D:
                deletePressed = false;
                break;
        }
    }
}
