package org.example.Irshad;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.example.db.SQLiteConnectionExample;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class IrshadDocument {

    public static void processDocument(String[] values) throws IOException {
        List<byte[]> fileDataList = SQLiteConnectionExample.wordFiles();
        if (!fileDataList.isEmpty()) {
            byte[] fileData = fileDataList.get(10);
            XWPFDocument doc = new XWPFDocument(new ByteArrayInputStream(fileData));
            List<String> allowedWords = SQLiteConnectionExample.Irshad1();
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
            String outputPath = showSaveFileDialog();
            if (outputPath != null) {
                String outputFileName = outputPath + File.separator + "Astara" + System.currentTimeMillis() + ".docx";
                FileOutputStream out = new FileOutputStream(outputFileName);
                doc.write(out);
                out.close();
                doc.close();
                System.out.println("Документ успешно изменен. Новый документ сохранен как '" + outputFileName + "'.");
            } else {
                System.out.println("Отменено пользователем.");
            }
        } else {
            System.out.println("Файл не найден.");
        }
    }

    private static String showSaveFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Выберите папку для сохранения файла");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            return fileToSave.getAbsolutePath();
        }
        return null;
    }
}
