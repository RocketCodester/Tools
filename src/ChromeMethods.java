
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class ChromeMethods extends KeyboardMethods {

    public ChromeMethods() throws AWTException {
    }
    //Opens Chrome at url specified and wait 5000 milliseconds
    public void chrome_Open(String url) throws IOException {
        Runtime.getRuntime().exec("cmd /c \"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\" -incognito " + url);
        delay(5000);
    }

    //Opens Chrome at url specified and wait # of milliseconds specified
    public void chrome_Open(String url, int msec) throws IOException {
        Runtime.getRuntime().exec("cmd /c \"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\" -incognito" + url);
        delay(msec);
    }

    public void chrome_MakeFullscreen() {
        int k[] = {KeyEvent.VK_ALT, KeyEvent.VK_SPACE, KeyEvent.VK_X};
        type(k, 2000 + ThreadLocalRandom.current().nextInt(-5, 5));// <editor-fold defaultstate="collapsed" desc="Deprecated">
        /*keyPress(KeyEvent.VK_ALT);
        keyPress(KeyEvent.VK_SPACE);
        type(KeyEvent.VK_X);
        keyRelease(KeyEvent.VK_SPACE);
        keyRelease(KeyEvent.VK_ALT);*/
        // </editor-fold>
    }

    public void chrome_clearData() {
        typeCap(KeyEvent.VK_F6, 2000); //Switch to Address Bar
        typeString("chrome://settings/clearbrowserdata", 0);
        type(KeyEvent.VK_ENTER, 3000);
        click(1082, 757, 3000); // Click "Clear browsing data" confirmation button
        type(KeyEvent.VK_ENTER);  // Press enter to ensure history is cleared
    }

    public void chrome_Close() {
        type(KeyEvent.VK_Q, true, true, 3000);
    }

}
