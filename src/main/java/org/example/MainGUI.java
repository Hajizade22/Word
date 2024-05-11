package org.example;

import org.example.db.SQLiteConnectionExample;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainGUI extends JFrame {
    private JComboBox<String> resultComboBox;
    private JButton bankOfRepublicButton;
    private JButton abcButton;
    private JButton ferrumButton;

    public MainGUI() {
        setTitle("Astara rayon Məhkəməsi");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        List<String> proqramSozleri = SQLiteConnectionExample.proqramSozleri();
        Font titleFont = new Font("Arial", Font.PLAIN, 24);
        JLabel titleLabel = new JLabel(proqramSozleri.get(0), SwingConstants.CENTER);
        titleLabel.setFont(titleFont);
        add(titleLabel, gbc);

        JLabel selectLabel = new JLabel(proqramSozleri.get(1), SwingConstants.CENTER);
        selectLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(selectLabel, gbc);


        resultComboBox = new JComboBox<>(new String[]{"", proqramSozleri.get(2), proqramSozleri.get(3)});
        resultComboBox.setSelectedIndex(0);
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(resultComboBox, gbc);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));

        List<String> allowedWords = SQLiteConnectionExample.muessiseAdlari();
        bankOfRepublicButton = new JButton(allowedWords.get(0));
        abcButton = new JButton(allowedWords.get(1));
        ferrumButton = new JButton(allowedWords.get(2));
        buttons.add(bankOfRepublicButton);
        buttons.add(abcButton);
        buttons.add(ferrumButton);
        buttonPanel.add(buttons, BorderLayout.CENTER);
        gbc.gridy = 3;
        add(buttonPanel, gbc);

        JLabel authorLabel = new JLabel(proqramSozleri.get(4), SwingConstants.RIGHT);
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.PAGE_END;
        add(authorLabel, gbc);

        setVisible(true);


        bankOfRepublicButton.setVisible(false);
        abcButton.setVisible(false);
        ferrumButton.setVisible(false);


        resultComboBox.addActionListener(e -> {
            String selectedResult = (String) resultComboBox.getSelectedItem();
            if (selectedResult != null) {
                switch (selectedResult) {
                    case "İddia təmin edildi":
                        bankOfRepublicButton.setVisible(true);
                        abcButton.setVisible(false);
                        ferrumButton.setVisible(false);
                        break;
                    case "İddia qismən təmin edildi":

                        abcButton.setVisible(true);
                        ferrumButton.setVisible(true);
                        bankOfRepublicButton.setVisible(false);
                        break;
                    default:
                        bankOfRepublicButton.setVisible(false);
                        abcButton.setVisible(false);
                        ferrumButton.setVisible(false);
                        break;
                }
            }
        });


        bankOfRepublicButton.addActionListener(e -> {
            try {

                String[] prompts = SQLiteConnectionExample.bankOfRepublicSuallar().toArray(new String[0]);
                String[] values = new String[prompts.length];

                JDialog dialog = new JDialog((Frame)null, "Məlumatları qeyd edin", true);
                dialog.setLayout(new GridLayout(prompts.length + 1, 2));

                JTextField[] textFields = new JTextField[prompts.length];
                for (int i = 0; i < prompts.length; i++) {
                    JLabel label = new JLabel(prompts[i]);
                    label.setFont(new Font("Arial", Font.ITALIC| Font.BOLD, 20));
                    dialog.add(label);

                    textFields[i] = new JTextField();
                    textFields[i].setFont(new Font("Arial", Font.ITALIC| Font.BOLD,30));
                    dialog.add(textFields[i]);
                }


                JButton okButton = new JButton("Qətnamə yarat");
                JButton cancelButton = new JButton("İmtina");
                dialog.add(okButton);
                dialog.add(cancelButton);


                okButton.addActionListener(okEvent -> {

                    for (int i = 0; i < prompts.length; i++) {
                        values[i] = textFields[i].getText();
                    }
                    dialog.dispose();
                });


                cancelButton.addActionListener(cancelEvent -> {
                    Arrays.fill(values, null);
                    dialog.dispose();
                });


                dialog.setSize(1500, 900);
                dialog.setVisible(true);

                BankOfRepublicDocument.processDocument(values);
                JOptionPane.showMessageDialog(this, "Qətnamə uğurla yaradıldı", "Uğurlu", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Xəta baş verdi: " + ex.getMessage(), "Xəta", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });


        abcButton.addActionListener(e -> {
            try {
                String[] prompts = SQLiteConnectionExample.bankOfRepublicSuallar().toArray(new String[0]);
                String[] values = new String[prompts.length];


                JDialog dialog = new JDialog((Frame)null, "Məlumatları qeyd edin", true);
                dialog.setLayout(new GridLayout(prompts.length + 1, 2));


                JTextField[] textFields = new JTextField[prompts.length];
                for (int i = 0; i < prompts.length; i++) {
                    JLabel label = new JLabel(prompts[i]);
                    label.setFont(new Font("Arial", Font.ITALIC| Font.BOLD, 20));
                    dialog.add(label);

                    textFields[i] = new JTextField();
                    textFields[i].setFont(new Font("Arial", Font.ITALIC| Font.BOLD,30));
                    dialog.add(textFields[i]);
                }


                JButton okButton = new JButton("Qətnamə yarat");
                JButton cancelButton = new JButton("İmtina");
                dialog.add(okButton);
                dialog.add(cancelButton);


                okButton.addActionListener(okEvent -> {

                    for (int i = 0; i < prompts.length; i++) {
                        values[i] = textFields[i].getText();
                    }
                    dialog.dispose(); // Закрытие диалогового окна
                });

                // Действие при нажатии кнопки "Отмена"
                cancelButton.addActionListener(cancelEvent -> {
                    Arrays.fill(values, null); // Очистка массива значений
                    dialog.dispose(); // Закрытие диалогового окна
                });

                // Установка размеров окна и его видимость
                dialog.setSize(1500, 900);
                dialog.setVisible(true);

                AbcDocument.processDocument(values);
                JOptionPane.showMessageDialog(this, "Qətnamə uğurla yaradıldı", "Uğurlu", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Xəta baş verdi " + ex.getMessage(), "Xəta", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        ferrumButton.addActionListener(e -> {
            try {

                String[] prompts = {"Hakimin adını qeyd edin:","Cavabdehin adını qeyd edin:","Müqavilə tarixini qeyd edin:","Müqavilə nömrəsini qeyd edin :","Əsas borcu qeyd edin:","Cərimə borcu qeyd edin:","Dövlət rüsumunu qeyd edin:", "Cavabdeh krediti kim ilə bağlayıb:", "Məhsulun ümumi dəyərini qeyd edin:",
                        "Məhsul neçə ay müddətinə verilmişdir:", "Maliyyə arayışının tarixini qeyd edin", "Maliyyə arayışında borcun hansı tarixə olduğunu qeyd edin:", "Cəmi nə qədər pul borclu olduğunu qeyd edin (Əsas borc + cərimə):"
                       ,"Bildirişin tarixinin qeyd edin:" , "Dövlət büdcəsinə ödənilən rüsumun tarixini qeyd edin:","Qəbzin nömrəsini qeyd edin:"
                        , "Cərimə məbləği azaldılaraq neçə manat saxlanılsın:", "Ümumi nə qədər məbləğ qət edilsin (Əsas borc + azaldılmış cərimə):"
                        ,"Sədrlik edən:"};
                String[] values = new String[prompts.length];

                JDialog dialog = new JDialog((Frame)null, "Məlumatları qeyd edin", true);
                dialog.setLayout(new GridLayout(prompts.length + 1, 2));

                JTextField[] textFields = new JTextField[prompts.length];
                for (int i = 0; i < prompts.length; i++) {
                    JLabel label = new JLabel(prompts[i]);
                    label.setFont(new Font("Arial", Font.ITALIC| Font.BOLD, 20));
                    dialog.add(label);

                    textFields[i] = new JTextField();
                    textFields[i].setFont(new Font("Arial", Font.ITALIC| Font.BOLD,30));
                    dialog.add(textFields[i]);
                }


                JButton okButton = new JButton("Qətnamə yarat");
                JButton cancelButton = new JButton("İmtina");
                dialog.add(okButton);
                dialog.add(cancelButton);


                okButton.addActionListener(okEvent -> {

                    for (int i = 0; i < prompts.length; i++) {
                        values[i] = textFields[i].getText();
                    }
                    dialog.dispose();
                });


                cancelButton.addActionListener(cancelEvent -> {
                    Arrays.fill(values, null);
                    dialog.dispose();
                });


                dialog.setSize(1500, 900);
                dialog.setVisible(true);

                FerrumDocument.processDocument(values);
                JOptionPane.showMessageDialog(this, "Qətnamə uğurla yaradıldı", "Uğurlu", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Xəta baş verdi: " + ex.getMessage(), "Xəta", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}
