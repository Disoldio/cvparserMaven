package org.example.service.extractor;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.swing.*;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PdfExtractor implements FileDataExtractor{

    @Override
    public String extract(File file) throws IOException {
        PDFTextStripper stripper = new PDFTextStripper();
        PDDocument document = Loader.loadPDF(file);

        String text = stripper.getText(document);
        return text;
    }
}
