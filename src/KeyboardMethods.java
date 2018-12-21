
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.ThreadLocalRandom;

public class KeyboardMethods extends Robot{

    public KeyboardMethods() throws AWTException {
    }

    public void click(int x, int y) {
        mouseMove(x, y);
        mousePress(InputEvent.BUTTON1_MASK);
        mouseRelease(InputEvent.BUTTON1_MASK);
        delay(2000 + ThreadLocalRandom.current().nextInt(-50, 50));
    }

    public void click(int x, int y, int delay) {
        delay(delay + ThreadLocalRandom.current().nextInt(500, 1000));
        mouseMove(x, y);
        mousePress(InputEvent.BUTTON1_MASK);
        mouseRelease(InputEvent.BUTTON1_MASK);
        delay(delay + ThreadLocalRandom.current().nextInt(0, 100));
    }

    public void type(int key) {
        keyPress(key);
        delay(55 + ThreadLocalRandom.current().nextInt(-5, 5));
        keyRelease(key);
        delay(ThreadLocalRandom.current().nextInt(0, 50));
    }

    public void type(int key, int delay) {
        keyPress(key);
        delay(55 + ThreadLocalRandom.current().nextInt(-5, 5));
        keyRelease(key);
        delay(delay + ThreadLocalRandom.current().nextInt(0, 50));
    }

    public void typeFn(int key1, int key2, int delay) {
        keyPress(key1);
        type(key2, 50);
        keyRelease(key1);
    }

    public void typeFn(int key1, int key2, int key3, int delay) {
        keyPress(key1);
        keyPress(key2);
        type(key3, 50);
        keyRelease(key2);
        keyRelease(key1);
    }

    public void typeFn(int key1, int key2, int key3, int key4, int delay) {
        keyPress(key1);
        keyPress(key2);
        keyPress(key3);
        type(key4, 50);
        keyPress(key3);
        keyRelease(key2);
        keyRelease(key1);
    }

    public void typeCap(int key, int delay) {
        typeFn(KeyEvent.VK_SHIFT, key, delay);
        delay(delay + ThreadLocalRandom.current().nextInt(0, 500));
    }

    public void typeCtrl(int key, int delay) {
        typeFn(KeyEvent.VK_CONTROL, key, delay);
        delay(delay + ThreadLocalRandom.current().nextInt(0, 50));
    }

    public void typeAlt(int key, int delay) {
        typeFn(KeyEvent.VK_ALT, key, delay);
        delay(delay + ThreadLocalRandom.current().nextInt(0, 50));
    }

    public void type(int key, boolean ctrl, boolean shift, int delay) {
        if (ctrl == true) {
            keyPress(KeyEvent.VK_CONTROL);
            if (shift == true) {
                typeFn(KeyEvent.VK_SHIFT, key, delay);
            } else {
                type(key, 50);
            }
            keyRelease(KeyEvent.VK_CONTROL);
        } else {
            type(key, 50);
        }
        delay(delay + ThreadLocalRandom.current().nextInt(0, 50));
    }

    public void type(String string, int fns[], int delay) {
        for (int i = 0; i < fns.length; i++) {
            keyPress(fns[i]);
            delay(delay + ThreadLocalRandom.current().nextInt(0, 50));
        }
        typeString(string, delay);
        for (int i = fns.length; i > 0; i--) {
            keyRelease(fns[i]);
            delay(delay + ThreadLocalRandom.current().nextInt(0, 50));
        }
    }

    public void typeString(String string, boolean ctrl, boolean shift, int delay) {
        if (ctrl == true) {
            keyPress(KeyEvent.VK_CONTROL);
            if (shift == true) {
                keyPress(KeyEvent.VK_SHIFT);
                typeString(string, delay);
                keyRelease(KeyEvent.VK_SHIFT);
            } else {
                typeString(string, delay);
            }
            keyRelease(KeyEvent.VK_CONTROL);
        } else {
            typeString(string, delay);
        }
        delay(delay + ThreadLocalRandom.current().nextInt(0, 50));
    }

    // Example a.typeString("Your negative campaign against Judge Keller is false, scurrilous and mean-spirited.", 2000);
    public void typeString(String string, int delay) {
        if (string.contains("")) {
            String[] parts = string.split("");
            for (int i = 0; i < string.length(); i++) {
                switch (parts[i]) {
                    case " ":
                        type(KeyEvent.VK_SPACE, 50);
                        break;
                    case "`":
                        type(KeyEvent.VK_BACK_QUOTE, 50);
                        break;
                    case "~":
                        typeCap(KeyEvent.VK_BACK_QUOTE, 50);
                        break;
                    case "!":
                        typeCap(KeyEvent.VK_1, 50);
                        break;
                    case "@":
                        typeCap(KeyEvent.VK_2, 50);
                        break;
                    case "#":
                        typeCap(KeyEvent.VK_3, 50);
                        break;
                    case "$":
                        typeCap(KeyEvent.VK_4, 50);
                        break;
                    case "%":
                        typeCap(KeyEvent.VK_5, 50);
                        break;
                    case "^":
                        typeCap(KeyEvent.VK_6, 50);
                        break;
                    case "&":
                        typeCap(KeyEvent.VK_7, 50);
                        break;
                    case "*":
                        typeCap(KeyEvent.VK_8, 50);
                        break;
                    case "(":
                        typeCap(KeyEvent.VK_9, 50);
                        break;
                    case ")":
                        typeCap(KeyEvent.VK_0, 50);
                        break;
                    case "_":
                        typeCap(KeyEvent.VK_SUBTRACT, 50);
                        break;
                    case "+":
                        typeCap(KeyEvent.VK_EQUALS, 50);
                        break;
                    case "-":
                        type(KeyEvent.VK_SUBTRACT, 50);
                        break;
                    case "=":
                        type(KeyEvent.VK_EQUALS, 50);
                        break;
                    case "[":
                        type(KeyEvent.VK_OPEN_BRACKET, 50);
                        break;
                    case "]":
                        type(KeyEvent.VK_CLOSE_BRACKET, 50);
                        break;
                    case "\\":
                        type(KeyEvent.VK_BACK_SLASH, 50);
                        break;
                    case ";":
                        type(KeyEvent.VK_SEMICOLON, 50);
                        break;
                    case "'":
                        type(KeyEvent.VK_QUOTE, 50);
                        break;
                    case ",":
                        type(KeyEvent.VK_COMMA, 50);
                        break;
                    case ".":
                        type(KeyEvent.VK_PERIOD, 50);
                        break;
                    case "/":
                        type(KeyEvent.VK_SLASH, 50);
                        break;
                    case "{":
                        typeCap(KeyEvent.VK_OPEN_BRACKET, 50);
                        break;
                    case "}":
                        typeCap(KeyEvent.VK_CLOSE_BRACKET, 50);
                        break;
                    case "|":
                        typeCap(KeyEvent.VK_BACK_SLASH, 50);
                        break;
                    case ":":
                        typeCap(KeyEvent.VK_SEMICOLON, 50);
                        break;
                    case "\"":
                        typeCap(KeyEvent.VK_QUOTE, 50);
                        break;
                    case "<":
                        typeCap(KeyEvent.VK_COMMA, 50);
                        break;
                    case ">":
                        typeCap(KeyEvent.VK_PERIOD, 50);
                        break;
                    case "?":
                        typeCap(KeyEvent.VK_SLASH, 50);
                        break;
                }
                if (isNumeric(parts[i])) {
                    type(Integer.parseInt(parts[i]) + 48);
                } else if (Character.isLetter(string.charAt(i)) && Character.isLowerCase(string.charAt(i))) {
                    String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
                    for (int j = 0; j < alphabet.length; j++) {
                        if (alphabet[j].equals(parts[i])) {
                            type(j + 65, 100);
                        }
                    }
                } else if (Character.isLetter(string.charAt(i)) && Character.isUpperCase(string.charAt(i))) {
                    String[] alphabet2 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
                    for (int j = 0; j < alphabet2.length; j++) {
                        if (alphabet2[j].equals(parts[i])) {
                            typeCap(j + 65, 100);
                        }
                    }
                }

            }
        }
        delay(delay);
    }

    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public void type(int keys[], int delay) {
        for (int i = 0; i < keys.length; i++) {
            type(keys[i]);
            delay(50 + ThreadLocalRandom.current().nextInt(-5, 5));
        }
        delay(delay + ThreadLocalRandom.current().nextInt(0, 50));
    }

    public void type(int keys[], boolean functions[], int delay) {
        for (int i = 0; i < keys.length; i++) {
            type(keys[i]);
            delay(50 + ThreadLocalRandom.current().nextInt(-5, 5));
        }
        delay(delay + ThreadLocalRandom.current().nextInt(0, 50));
    }

    public void scroll(int x1, int y1, int x2, int y2, int delay) {
        mouseMove(x1, y1);
        mousePress(InputEvent.BUTTON1_MASK);
        mouseMove(x2, y2);
        mouseRelease(InputEvent.BUTTON1_MASK);
        delay(delay);
    }
}
