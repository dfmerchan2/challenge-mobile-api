package co.com.yape.mobile.utilities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ValueScroll {
    LARGE_SCROLL(2),
    MEDIUM_SCROLL(5),
    SMALL_SCROLL1(10);

    private final int size;
}
