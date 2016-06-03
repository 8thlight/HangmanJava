package com.hangman;

import java.util.ArrayList;
import java.util.List;

class FakeWriter implements Writer {
    List<String> lines;

    FakeWriter() {
        lines = new ArrayList<String>();
    }

    public void writeLine(String line) {
        lines.add(line);
    }

    List<String> writtenLines() {
        return lines;
    }
}
