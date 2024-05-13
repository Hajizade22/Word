package org.example;

import org.example.ABC.ABCmehsulDocument;
import org.example.ABC.ABCtelefonDocument;
import org.example.BankOfRepublic.BankOfRepublicDocument;
import org.example.Ferrum.FerrumDocument;
import org.example.Ferrum.FerrumKatibliDocument;
import org.example.KapitalBank.KapitalBankDocument;
import org.example.Unibank.UnibankDocument;
import org.example.Unibank.UnibankLimitDocument;
import org.example.Unibank.UnibankOfertaDocument;
import org.example.db.SQLiteConnectionExample;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainGUI extends JFrame {
    private JComboBox<String> resultComboBox;
    private JButton bankOfRepublicButton;
    private JButton abcButton;
    private JButton ferrumButton;
    private JButton ferrumKatibliButton;
    private JButton abcmehsulButton;
    private JButton unibankButton;
    private JButton unibankOfertaButton;
    private JButton unibankLimitButton;
    private JButton KapitalBankButton;

    public MainGUI() {
        setTitle("Astara rayon Məhkəməsi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        try {
            BufferedImage backgroundImage = ImageIO.read(new File("C:\\Users\\Haci\\IdeaProjects\\Word\\src\\main\\java\\org\\example\\court_gavel.jpg"));
            setContentPane(new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        List<String> proqramSozleri = SQLiteConnectionExample.proqramSozleri();
        Font titleFont = new Font("Times New Roman", Font.BOLD, 48);
        JLabel titleLabel = new JLabel(proqramSozleri.get(0), SwingConstants.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(0, 0, 0, 180));
        add(titleLabel, gbc);

        JLabel selectLabel = new JLabel(proqramSozleri.get(1), SwingConstants.CENTER);
        selectLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        selectLabel.setForeground(Color.WHITE);
        selectLabel.setOpaque(true);
        selectLabel.setBackground(new Color(0, 0, 0, 180));
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(selectLabel, gbc);

        resultComboBox = new JComboBox<>(new String[]{"", proqramSozleri.get(2), proqramSozleri.get(3)});
        resultComboBox.setSelectedIndex(0);
        resultComboBox.setOpaque(false);
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        resultComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(resultComboBox, gbc);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        List<String> allowedWords = SQLiteConnectionExample.muessiseAdlari();
        bankOfRepublicButton = new JButton(allowedWords.get(0));
        abcButton = new JButton(allowedWords.get(1));
        ferrumButton = new JButton(allowedWords.get(2));
        abcmehsulButton=new JButton(allowedWords.get(3));
        ferrumKatibliButton = new JButton(allowedWords.get(4));
        unibankButton = new JButton(allowedWords.get(5));
        unibankOfertaButton = new JButton(allowedWords.get(6));
        KapitalBankButton = new JButton(allowedWords.get(7));
        unibankLimitButton = new JButton(allowedWords.get(8));
        bankOfRepublicButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        abcButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        ferrumButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        abcmehsulButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        ferrumKatibliButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        unibankButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        unibankOfertaButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        unibankLimitButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        KapitalBankButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        buttons.add(bankOfRepublicButton);
        buttons.add(abcButton);
        buttons.add(ferrumButton);
        buttons.add(abcmehsulButton);
        buttons.add(ferrumKatibliButton);
        buttons.add(unibankButton);
        buttons.add(unibankOfertaButton);
        buttons.add(unibankLimitButton);
        buttons.add(KapitalBankButton);
        buttons.setOpaque(false);
        buttonPanel.add(buttons, BorderLayout.CENTER);
        buttonPanel.setOpaque(false);
        gbc.gridy = 3;
        add(buttonPanel, gbc);

        JLabel authorLabel = new JLabel(proqramSozleri.get(4), SwingConstants.RIGHT);
        authorLabel.setForeground(Color.WHITE);
        authorLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.PAGE_END;
        authorLabel.setOpaque(true);
        authorLabel.setBackground(new Color(0, 0, 0, 100));
        add(authorLabel, gbc);



        setVisible(true);

        bankOfRepublicButton.setVisible(false);
        abcButton.setVisible(false);
        ferrumButton.setVisible(false);
        abcmehsulButton.setVisible(false);
        ferrumKatibliButton.setVisible(false);
        unibankButton.setVisible(false);
        unibankOfertaButton.setVisible(false);
        unibankLimitButton.setVisible(false);
        KapitalBankButton.setVisible(false);

        resultComboBox.addActionListener(e -> {
            String selectedResult = (String) resultComboBox.getSelectedItem();
            if (selectedResult != null) {
                if (selectedResult.equals(proqramSozleri.get(2))) {
                    bankOfRepublicButton.setVisible(true);
                    unibankButton.setVisible(true);
                    unibankOfertaButton.setVisible(true);
                    unibankLimitButton.setVisible(true);
                    KapitalBankButton.setVisible(true);
                    abcButton.setVisible(false);
                    ferrumButton.setVisible(false);
                    abcmehsulButton.setVisible(false);
                    ferrumKatibliButton.setVisible(false);
                } else if (selectedResult.equals(proqramSozleri.get(3))) {
                    abcButton.setVisible(true);
                    ferrumButton.setVisible(true);
                    abcmehsulButton.setVisible(true);
                    ferrumKatibliButton.setVisible(true);
                    bankOfRepublicButton.setVisible(false);
                    unibankButton.setVisible(false);
                    unibankOfertaButton.setVisible(false);
                    unibankLimitButton.setVisible(false);
                    KapitalBankButton.setVisible(false);
                } else {
                    bankOfRepublicButton.setVisible(false);
                    abcButton.setVisible(false);
                    ferrumButton.setVisible(false);
                    abcmehsulButton.setVisible(false);
                    ferrumKatibliButton.setVisible(false);
                    unibankButton.setVisible(false);
                    unibankOfertaButton.setVisible(false);
                    unibankLimitButton.setVisible(false);
                    KapitalBankButton.setVisible(false);
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
        unibankButton.addActionListener(e -> {
            try {

                String[] prompts = SQLiteConnectionExample.Unibank2().toArray(new String[0]);
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

                UnibankDocument.processDocument(values);
                JOptionPane.showMessageDialog(this, "Qətnamə uğurla yaradıldı", "Uğurlu", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Xəta baş verdi: " + ex.getMessage(), "Xəta", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
        unibankOfertaButton.addActionListener(e -> {
            try {

                String[] prompts = SQLiteConnectionExample.Unibank2Oferta().toArray(new String[0]);
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

                UnibankOfertaDocument.processDocument(values);
                JOptionPane.showMessageDialog(this, "Qətnamə uğurla yaradıldı", "Uğurlu", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Xəta baş verdi: " + ex.getMessage(), "Xəta", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        unibankLimitButton.addActionListener(e -> {
            try {

                String[] prompts = SQLiteConnectionExample.Unibank2Limit().toArray(new String[0]);
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

                UnibankLimitDocument.processDocument(values);
                JOptionPane.showMessageDialog(this, "Qətnamə uğurla yaradıldı", "Uğurlu", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Xəta baş verdi: " + ex.getMessage(), "Xəta", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
        KapitalBankButton.addActionListener(e -> {
            try {

                String[] prompts = SQLiteConnectionExample.KapitalBank2().toArray(new String[0]);
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

                KapitalBankDocument.processDocument(values);
                JOptionPane.showMessageDialog(this, "Qətnamə uğurla yaradıldı", "Uğurlu", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Xəta baş verdi: " + ex.getMessage(), "Xəta", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
        abcButton.addActionListener(e -> {
            try {
                String[] prompts = SQLiteConnectionExample.ABC2Telefon().toArray(new String[0]);
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

                ABCtelefonDocument.processDocument(values);
                JOptionPane.showMessageDialog(this, "Qətnamə uğurla yaradıldı", "Uğurlu", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Xəta baş verdi " + ex.getMessage(), "Xəta", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        abcmehsulButton.addActionListener(e -> {
            try {
                String[] prompts = SQLiteConnectionExample.ABC2Mehsul().toArray(new String[0]);
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

                ABCmehsulDocument.processDocument(values);
                JOptionPane.showMessageDialog(this, "Qətnamə uğurla yaradıldı", "Uğurlu", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Xəta baş verdi " + ex.getMessage(), "Xəta", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
        ferrumButton.addActionListener(e -> {
            try {

                String[] prompts = SQLiteConnectionExample.FerrumKapital2().toArray(new String[0]);
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

        ferrumKatibliButton.addActionListener(e -> {
            try {

                String[] prompts = SQLiteConnectionExample.FerrumKapital2Katibli().toArray(new String[0]);
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

                FerrumKatibliDocument.processDocument(values);
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