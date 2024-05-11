package org.example;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.example.db.SQLiteConnectionExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FerrumDocument {
    private static final String filePath = "C:\\Users\\Haci\\OneDrive\\Рабочий стол\\Ferrum sablon.docx";

    public static void processDocument(String[] values) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
            List<String> allowedWords = SQLiteConnectionExample.FerrumKapital1();
            Map<String, String> replacements = new HashMap<>();
            for (int i = 0; i < allowedWords.size(); i++) {
                replacements.put(allowedWords.get(i), values[i]);
            }
            for (XWPFParagraph paragraph : doc.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    if (text != null) {
                        for (String word : allowedWords) {
                            if (text.contains(word)) {
                                text = text.replace(word, replacements.get(word));
                                run.setText(text, 0);
                            }
                        }
                    }
                }
            }
            String outputFileName = "Astara018" + System.currentTimeMillis() + ".docx";
            FileOutputStream out = new FileOutputStream(outputFileName);
            doc.write(out);
            out.close();
            doc.close();
        } else {
            System.out.println("Файл не найден.");
        }
    }
}
