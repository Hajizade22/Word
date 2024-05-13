package org.example.ABC;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.example.db.SQLiteConnectionExample;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ABCtelefonDocument {
    private static final String filePath = "C:\\Users\\Haci\\OneDrive\\Рабочий стол\\Abc sablon.docx";

    public static void processDocument(String[] values) throws IOException {
        List<byte[]> fileDataList = SQLiteConnectionExample.wordFiles();
        if (!fileDataList.isEmpty()) {
            byte[] fileData = fileDataList.get(1);
            XWPFDocument doc = new XWPFDocument(new ByteArrayInputStream(fileData));
            List<String> allowedWords = SQLiteConnectionExample.ABC1Telefon();
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
