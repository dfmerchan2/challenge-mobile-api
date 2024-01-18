package co.com.yape.mobile.utilities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ScreenSpecifications {

    public static int getWidthSizeScreen(int scrollSize) {
        return MyDriver.getDriver().manage().window().getSize().getWidth() / scrollSize;
    }

    public static int getHeightSizeScreen(int scrollSize) {
        return MyDriver.getDriver().manage().window().getSize().getHeight() / scrollSize;
    }
}
