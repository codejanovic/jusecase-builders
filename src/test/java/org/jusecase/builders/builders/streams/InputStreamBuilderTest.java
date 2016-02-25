package org.jusecase.builders.builders.streams;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.jusecase.builders.Builders.a;
import static org.jusecase.builders.Builders.inputStream;

public class InputStreamBuilderTest {
    @Test
    public void inputStreamWithoutAdjustments() throws Exception {
        inputStreamIsEqualTo(a(inputStream()), "");
    }

    @Test
    public void inputStreamWithString() throws Exception {
        inputStreamIsEqualTo(a(inputStream().withString("1234")), "1234");
    }

    @Test(expected = NullPointerException.class)
    public void inputStreamWithResourceThatDoesNotExist() throws Exception {
        a(inputStream().withResource("unknown.txt"));
    }

    @Test
    public void inputStreamWithResource() throws Exception {
        inputStreamIsEqualTo(a(inputStream().withResource("testresource.txt")), "this is a test");
    }

    private void inputStreamIsEqualTo(InputStream inputStream, String expected) throws Exception {
        assertEquals(expected, IOUtils.toString(inputStream));
    }
}