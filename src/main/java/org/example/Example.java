////package org.example;
////
////public class Example {
////
////        public static void main(String[] args) throws IOException {
////            Scanner scanner = new Scanner(System.in);
////            String filePathBankOfRepublic = "C:\\Users\\Haci\\OneDrive\\Рабочий стол\\qt.docx";
////            String filePathAbc = "C:\\Users\\Haci\\OneDrive\\Рабочий стол\\Abc sablon.docx";
////            System.out.println("Zəhmət olmazsa hansı Qətnamə nümünəsini seçmək istədiyinizi qeyd edin :\n" + "1: Bank Respublika\n" + "2: ABC Telecom");
////            System.out.print("Rəqəm daxil edin: ");
////            int number = scanner.nextInt();
////
////            scanner.nextLine();
////
////            if (number == 1) {
////                File file = new File(filePathBankOfRepublic);
////                if (file.exists()) {
////
////                    XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
////
////
////                    List<String> allowedWords = Arrays.asList("first", "second", "Name", "date", "contractNumber", "main", "percentage", "total", "rusum", "month", "yearlyPercentage", "cemKredit", "third");
////
////
////                    Map<String, String> replacements = new HashMap<>();
////
////
////                    String[] prompts = {"Hakimin adını qeyd edin: ", "Katibin adını qeyd edin: ", "Cavabdehin adını qeyd edin: ", "Müqavilə tarixini qeyd edin: ", "Müqavilə nömrəsini qeyd edin (Misal 012CASA və ya 012REST): ", "Əsas borcu qeyd edin: ", "Faiz borcu qeyd edin: ", "Cəm məbləği qeyd edin: ", "Dövlət rüsumunu qeyd edin: ", "Kredit müştəriyə neçə aylıq verilib: ", "Kredit neçə faizlə verilibdir : ", "Neçə manat məbləğində kredit verilmişdir: ", "Sədrlik edən"};
////
////
////                    for (int i = 0; i < allowedWords.size(); i++) {
////                        System.out.println(prompts[i]);
////                        String newWord = scanner.nextLine();
////                        replacements.put(allowedWords.get(i), newWord);
////                    }
////
////                    for (XWPFParagraph paragraph : doc.getParagraphs()) {
////                        for (XWPFRun run : paragraph.getRuns()) {
////                            String text = run.getText(0);
////                            if (text != null) {
////                                for (String word : allowedWords) {
////                                    if (text.contains(word)) {
////                                        text = text.replace(word, replacements.get(word));
////                                        run.setText(text, 0);
////                                    }
////                                }
////                            }
////                        }
////                    }
////
////
////                    String outputFileName = "новый_документ_" + System.currentTimeMillis() + ".docx";
////
////
////                    FileOutputStream out = new FileOutputStream(outputFileName);
////                    doc.write(out);
////                    out.close();
////                    doc.close();
////
////                    System.out.println("Документ успешно изменен. Новый документ сохранен как '" + outputFileName + "'.");
////                } else {
////                    System.out.println("Файл не найден.");
////                }
////            } else if (number == 2) {
////                File file2 = new File(filePathAbc);
////                if (file2.exists()) {
////
////                    XWPFDocument doc = new XWPFDocument(new FileInputStream(file2));
////
////
////                    List<String> allowedWords = Arrays.asList("first", "second", "Name", "total", "rusum", "date", "serialNumber", "models", "mehsulunUmumiDeyeri", "neceAyliqVerilib", "ilkinOdenis", "everyMonth", "odenilmemisHisse", "musteriyeQuzest", "bugunedekOdenis", "neQederCerimeQalsin", "cerimeAzaldilandanSonraQalanMebleq", "third");
////
////
////                    Map<String, String> replacements = new HashMap<>();
////
////
////                    String[] prompts = {"Hakimin adını qeyd edin: ", "Katibin adını qeyd edin: ", "Cavabdehin adını qeyd edin: ", "Əsas borcu qeyd edin: ", "Dövlət rüsumunu qeyd edin: ", "Müqavilə tarixini qeyd edin", "İMEİ kodu daxil edin : ", "Məhsulun modelini qeyd edin: ", "Məhsulun ümumi dəyərini qeyd edin", "Məhsul neçə ay müddətinə verilmişdir", "İlkin ödəniş varsa qeyd edin", "Aylıq ödənişi qeyd edin", "Ödənilməmiş hissəni qeyd edin", "Müştəriyə güzəşt olunan hissəni qeyd edin", "Bugünədək ödənişləri qeyd edin", "Cərimə məbləği nə qədər saxlanılsın", "Cərimə azaldıldıqdan sonra ümumi qalan məbləği qeyd edin", "Sədrlik edən"};
////
////
////                    for (int i = 0; i < allowedWords.size(); i++) {
////                        System.out.println(prompts[i]);
////                        String newWord = scanner.nextLine();
////                        replacements.put(allowedWords.get(i), newWord);
////                    }
////
////                    for (XWPFParagraph paragraph : doc.getParagraphs()) {
////                        for (XWPFRun run : paragraph.getRuns()) {
////                            String text = run.getText(0);
////                            if (text != null) {
////                                for (String word : allowedWords) {
////                                    if (text.contains(word)) {
////                                        text = text.replace(word, replacements.get(word));
////                                        run.setText(text, 0);
////                                    }
////                                }
////                            }
////                        }
////                    }
////
////                    String outputFileName = "новый_документ_" + System.currentTimeMillis() + ".docx";
////
////
////                    FileOutputStream out = new FileOutputStream(outputFileName);
////                    doc.write(out);
////                    out.close();
////                    doc.close();
////
////                    System.out.println("Документ успешно изменен. Новый документ сохранен как '" + outputFileName + "'.");
////                } else {
////                    System.out.println("Файл не найден.");
////                }
////            }
////        }
////    }
////
////
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//import org.apache.poi.xwpf.usermodel.XWPFRun;
//
//class BankOfRepublicDocument {
//    private static final String filePath = "C:\\Users\\Haci\\OneDrive\\Рабочий стол\\qt.docx";
//
//    public static void processDocument(Scanner scanner) throws IOException {
//        File file = new File(filePath);
//        if (file.exists()) {
//            XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
//            List<String> allowedWords = Arrays.asList("first", "second", "Name", "date", "contractNumber", "main", "percentage", "total", "rusum", "month", "yearlyPercentage", "cemKredit", "third");
//            Map<String, String> replacements = new HashMap<>();
//            String[] prompts = {"Hakimin adını qeyd edin: ", "Katibin adını qeyd edin: ", "Cavabdehin adını qeyd edin: ", "Müqavilə tarixini qeyd edin: ", "Müqavilə nömrəsini qeyd edin (Misal 012CASA və ya 012REST): ", "Əsas borcu qeyd edin: ", "Faiz borcu qeyd edin: ", "Cəm məbləği qeyd edin: ", "Dövlət rüsumunu qeyd edin: ", "Kredit müştəriyə neçə aylıq verilib: ", "Kredit neçə faizlə verilibdir : ", "Neçə manat məbləğində kredit verilmişdir: ", "Sədrlik edən"};
//            for (int i = 0; i < allowedWords.size(); i++) {
//                System.out.println(prompts[i]);
//                String newWord = scanner.nextLine();
//                replacements.put(allowedWords.get(i), newWord);
//            }
//            for (XWPFParagraph paragraph : doc.getParagraphs()) {
//                for (XWPFRun run : paragraph.getRuns()) {
//                    String text = run.getText(0);
//                    if (text != null) {
//                        for (String word : allowedWords) {
//                            if (text.contains(word)) {
//                                text = text.replace(word, replacements.get(word));
//                                run.setText(text, 0);
//                            }
//                        }
//                    }
//                }
//            }
//            String outputFileName = "новый_документ_" + System.currentTimeMillis() + ".docx";
//            FileOutputStream out = new FileOutputStream(outputFileName);
//            doc.write(out);
//            out.close();
//            doc.close();
//            System.out.println("Документ успешно изменен. Новый документ сохранен как '" + outputFileName + "'.");
//        } else {
//            System.out.println("Файл не найден.");
//        }
//    }
//}
//
//class AbcDocument {
//    private static final String filePath = "C:\\Users\\Haci\\OneDrive\\Рабочий стол\\Abc sablon.docx";
//
//    public static void processDocument(Scanner scanner) throws IOException {
//        File file = new File(filePath);
//        if (file.exists()) {
//            XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
//            List<String> allowedWords = Arrays.asList("first", "second", "Name", "total", "rusum", "date", "serialNumber", "models", "mehsulunUmumiDeyeri", "neceAyliqVerilib", "ilkinOdenis", "everyMonth", "odenilmemisHisse", "musteriyeQuzest", "bugunedekOdenis", "neQederCerimeQalsin", "cerimeAzaldilandanSonraQalanMebleq", "third");
//            Map<String, String> replacements = new HashMap<>();
//            String[] prompts = {"Hakimin adını qeyd edin: ", "Katibin adını qeyd edin: ", "Cavabdehin adını qeyd edin: ", "Əsas borcu qeyd edin: ", "Dövlət rüsumunu qeyd edin: ", "Müqavilə tarixini qeyd edin", "İMEİ kodu daxil edin : ", "Məhsulun modelini qeyd edin: ", "Məhsulun ümumi dəyərini qeyd edin", "Məhsul neçə ay müddətinə verilmişdir", "İlkin ödəniş varsa qeyd edin", "Aylıq ödənişi qeyd edin", "Ödənilməmiş hissəni qeyd edin", "Müştəriyə güzəşt olunan hissəni qeyd edin", "Bugünədək ödənişləri qeyd edin", "Cərimə məbləği nə qədər saxlanılsın", "Cərimə azaldıldıqdan sonra ümumi qalan məbləği qeyd edin", "Sədrlik edən"};
//            for (int i = 0; i < allowedWords.size(); i++) {
//                System.out.println(prompts[i]);
//                String newWord = scanner.nextLine();
//                replacements.put(allowedWords.get(i), newWord);
//            }
//            for (XWPFParagraph paragraph : doc.getParagraphs()) {
//                for (XWPFRun run : paragraph.getRuns()) {
//                    String text = run.getText(0);
//                    if (text != null) {
//                        for (String word : allowedWords) {
//                            if (text.contains(word)) {
//                                text = text.replace(word, replacements.get(word));
//                                run.setText(text, 0);
//                            }
//                        }
//                    }
//                }
//            }
//            String outputFileName = "новый_документ_" + System.currentTimeMillis() + ".docx";
//            FileOutputStream out = new FileOutputStream(outputFileName);
//            doc.write(out);
//            out.close();
//            doc.close();
//            System.out.println("Документ успешно изменен. Новый документ сохранен как '" + outputFileName + "'.");
//        } else {
//            System.out.println("Файл не найден.");
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Zəhmət olmazsa hansı Qətnamə nümünəsini seçmək istədiyinizi qeyd edin :\n" + "1: Bank Respublika\n" + "2: ABC Telecom");
//        System.out.print("Rəqəm daxil edin: ");
//        int number = scanner.nextInt();
//        scanner.nextLine(); // Consume newline left-over
//
//        if (number == 1) {
//            BankOfRepublicDocument.processDocument(scanner);
//        } else if (number == 2) {
//            AbcDocument.processDocument(scanner);
//        } else {
//            System.out.println("Düzgün rəqəm daxil edilmədi.");
//        }
//    }
//}
