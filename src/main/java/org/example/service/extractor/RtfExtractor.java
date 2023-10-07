package org.example.service.extractor;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class RtfExtractor implements FileDataExtractor {
    @Override
    public String extract(File file) throws IOException, BadLocationException {
        JEditorPane pane = new JEditorPane();
        pane.setContentType("text/rtf");
        RTFEditorKit rtfKit = new RTFEditorKit();

        FileInputStream fis = new FileInputStream(file);
        InputStreamReader i = new InputStreamReader(fis,"UTF-8");
        rtfKit.read(i, pane.getDocument(), 0);
        String st = pane.getDocument().getText(0, pane.getDocument().getLength());
        return st;
    }
}
