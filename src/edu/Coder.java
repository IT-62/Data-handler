package edu;

import java.io.*;

public class Coder {
    //IN
    public static Reader encryptSymbolsIn(Reader reader, final char key) {
        return new FilterReader(reader) {
            @Override
            public int read() throws IOException {
                return super.read() + key;
            }
        };
    }

    public static Reader decipherSymbolsIn(Reader reader,final char key) {
        return new FilterReader(reader) {
            @Override
            public int read() throws IOException {
                int c = super.read();
                return c > key ? c - key : 255 - key;
            }
        };
    }

    public static InputStream encryptBytesIn(InputStream inputStream, final char key) {
        return new FilterInputStream(inputStream) {
            @Override
            public int read() throws IOException {
                return super.read() + key;
            }
        };
    }

    public static InputStream decipherBytesIn(InputStream inputStream, final char key) {
        return new FilterInputStream(inputStream) {
            @Override
            public int read() throws IOException {
                int c = super.read();
                return c > key ? c - key : 255 - key;
            }
        };
    }

    //OUT

    public static Writer encryptSymbolsOut(Writer writer, final char key) {
        return new FilterWriter(writer) {
            @Override
            public void write(int c) throws IOException {
                super.write(c + key);
            }
        };
    }

    public static Writer decipherSymbolsOut(Writer writer, final char key) {
        return new FilterWriter(writer) {
            @Override
            public void write(int c) throws IOException {
                super.write(c > key ? c - key : 255 - key);
            }
        };
    }

    public static OutputStream encryptBytesOut(OutputStream outputStream, final char key) {
        return new FilterOutputStream(outputStream) {
            @Override
            public void write(int c) throws IOException {
                super.write(c + key);
            }
        };
    }

    public static OutputStream decipherBytesOut(OutputStream outputStream, final char key) {
        return new FilterOutputStream(outputStream) {
            @Override
            public void write(int c) throws IOException {
                super.write(c > key ? c - key : 255 - key);
            }
        };
    }

}
