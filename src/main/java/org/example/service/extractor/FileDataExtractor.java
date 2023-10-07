package org.example.service.extractor;

import javax.swing.text.BadLocationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface FileDataExtractor {

    String extract(File file) throws IOException, BadLocationException;
}
