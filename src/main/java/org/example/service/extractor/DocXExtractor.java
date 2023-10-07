package org.example.service.extractor;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DocXExtractor implements FileDataExtractor{

    @Override
    public String extract(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        XWPFDocument document = new XWPFDocument(inputStream);
        XWPFWordExtractor extractor = new XWPFWordExtractor(document);

        String fileData = extractor.getText();

        return fileData;
    }
}
