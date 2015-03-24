package de.jodamob.android.autolayout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertArrayEquals;

@RunWith(RobolectricTestRunner.class)
public class NameConverterTest {

    @Test
    public void test() {
        assertArrayEquals(new String[]{"name_converter_test","name_converter","name"}, NameConverter.convertToResourceName(NameConverterTest.this));
    }
}
