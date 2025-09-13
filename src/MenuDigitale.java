import javax.swing.*;   // Per l'interfaccia grafica.
import java.awt.*;  // Per l'interfaccia grafica.
import java.awt.event.*;    // Per gli eventi.

import java.io.BufferedWriter;      // Scrittura su file.
import java.io.FileOutputStream;    // Scrittura su file.
import java.io.IOException;         // Gestione eccezioni.
import java.io.OutputStreamWriter;  // Scrittura su file.
import java.nio.charset.StandardCharsets;   // Per la specifica dello standard del file.

public class MenuDigitale extends JFrame implements ActionListener {
    private double finalPrice = 0.00;
    private JFrame f;
    private JPanel buttonPanel, cardPanel;
    private JPanel primoPiattoPanel, secondoPiattoPanel, contornoPanel, dessertPanel, bibitePanel;
    private JLabel titleLabel;   // Crea una scritta.
    private JButton primoPiattoBtn, secondoPiattoBtn, contornoBtn, dessertBtn, bibiteBtn;
    private CardLayout cardLayout;
    private JPanel buttonPanel_Low;
    private JButton aggiungiPortataBtn, confermaBtn;

    public MenuDigitale() {     // Metodo Costruttore.
        f = new JFrame();
        f.setTitle("Menù Digitale");
        f.setSize(573, 400);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        titleLabel = new JLabel("MENÙ DIGITALE");
        titleLabel.setLayout(new BorderLayout());
        f.add(titleLabel, BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        f.add(buttonPanel);

        buttonPanel.setLayout(new GridLayout(1,5));

        primoPiattoBtn = new JButton("Primi Piatti");
        primoPiattoBtn.addActionListener(this);
        buttonPanel.add(primoPiattoBtn);

        secondoPiattoBtn = new JButton("Secondi Piatti");
        secondoPiattoBtn.addActionListener(this);
        buttonPanel.add(secondoPiattoBtn);

        contornoBtn = new JButton("Contorni");
        contornoBtn.addActionListener(this);
        buttonPanel.add(contornoBtn);

        dessertBtn = new JButton("Desserts");
        dessertBtn.addActionListener(this);
        buttonPanel.add(dessertBtn);

        bibiteBtn = new JButton("Bibite");
        bibiteBtn.addActionListener(this);
        buttonPanel.add(bibiteBtn);


        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        f.add(cardPanel);


        primoPiattoPanel = new JPanel();
        primoPiattoPanel.setLayout(new BoxLayout(primoPiattoPanel, BoxLayout.Y_AXIS));
        cardPanel.add(primoPiattoPanel, "Primi Piatti");
        primoPiattoPanel.setLayout(new GridLayout(11,2));

        secondoPiattoPanel = new JPanel();
        secondoPiattoPanel.setLayout(new BoxLayout(secondoPiattoPanel, BoxLayout.Y_AXIS));
        cardPanel.add(secondoPiattoPanel, "Secondi Piatti");
        secondoPiattoPanel.setLayout(new GridLayout(11,2));

        contornoPanel = new JPanel();
        contornoPanel.setLayout(new BoxLayout(contornoPanel, BoxLayout.Y_AXIS));
        cardPanel.add(contornoPanel, "Contorni");
        contornoPanel.setLayout(new GridLayout(9,2));

        dessertPanel = new JPanel();
        dessertPanel.setLayout(new BoxLayout(dessertPanel, BoxLayout.Y_AXIS));
        cardPanel.add(dessertPanel, "Desserts");
        dessertPanel.setLayout(new GridLayout(11,2));

        bibitePanel = new JPanel();
        bibitePanel.setLayout(new BoxLayout(bibitePanel, BoxLayout.Y_AXIS));
        cardPanel.add(bibitePanel, "Bibite");
        bibitePanel.setLayout(new GridLayout(11,2));

        // Aggiungi i checkbox ai pannelli corrispondenti
        primoPiattoPanel.add(new JCheckBox("Carbonara - €13.05"));
        primoPiattoPanel.add(new JCheckBox("Pasta al Sugo - €07.10"));
        primoPiattoPanel.add(new JCheckBox("Pasta al Pesto - €08.50"));
        primoPiattoPanel.add(new JCheckBox("Spaghetti aglio e olio - €08.00"));

        secondoPiattoPanel.add(new JCheckBox("Tagliata di Manzo - €16.00"));
        secondoPiattoPanel.add(new JCheckBox("Cotoletta di Pollo - €07.50"));
        secondoPiattoPanel.add(new JCheckBox("Arrosticini di Pecora x50 - €15.00"));
        secondoPiattoPanel.add(new JCheckBox("Tartare di Tonno - €22.85"));

        contornoPanel.add(new JCheckBox("Insalata - €02.50"));
        contornoPanel.add(new JCheckBox("Songino - €02.80"));
        contornoPanel.add(new JCheckBox("Rucola - €02.80"));
        contornoPanel.add(new JCheckBox("Pomodori - €03.20"));
        contornoPanel.add(new JCheckBox("Patatine fritte €04.00"));
        contornoPanel.add(new JCheckBox("Spinaci - €02.00"));
        contornoPanel.add(new JCheckBox("Broccoli - €02.10"));
        contornoPanel.add(new JCheckBox("Olive - €01.80"));
        contornoPanel.add(new JCheckBox("Salame - €04.20"));
        contornoPanel.add(new JCheckBox("Taralli - €04.00"));

        dessertPanel.add(new JCheckBox("Tiramisù - €10.00"));
        dessertPanel.add(new JCheckBox("Semifreddo al Pistacchio - €13.00"));
        dessertPanel.add(new JCheckBox("Pannacotta al Lampone - €09.00"));
        dessertPanel.add(new JCheckBox("Sorbetto al Limone - €05.00"));

        bibitePanel.add(new JCheckBox("Acqua Minerale - €01.00"));
        bibitePanel.add(new JCheckBox("Acqua Frizzante - €01.10"));
        bibitePanel.add(new JCheckBox("Coca Cola - €02.50"));
        bibitePanel.add(new JCheckBox("Fanta - €02.50"));



        primoPiattoBtn.setEnabled(false);

        primoPiattoPanel.setVisible(true);

        secondoPiattoPanel.setVisible(false);
        contornoPanel.setVisible(false);
        dessertPanel.setVisible(false);
        bibitePanel.setVisible(false);


        // BOTTONI DI SOTTO:

        buttonPanel_Low = new JPanel();
        buttonPanel_Low.setLayout(new FlowLayout());
        f.add(buttonPanel_Low);

        buttonPanel_Low.setLayout(new GridLayout(1,2));

        aggiungiPortataBtn = new JButton("Aggiungi");
        aggiungiPortataBtn.addActionListener(this);
        buttonPanel_Low.add(aggiungiPortataBtn);

        confermaBtn = new JButton("Conferma Ordine");
        confermaBtn.addActionListener(this);
        confermaBtn.setBackground(Color.GREEN);
        buttonPanel_Low.add(confermaBtn);


        
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == primoPiattoBtn) {
            primoPiattoBtn.setEnabled(false);
            secondoPiattoBtn.setEnabled(true);
            contornoBtn.setEnabled(true);
            dessertBtn.setEnabled(true);
            bibiteBtn.setEnabled(true);

            cardPanel.setVisible(true);
            cardLayout.show(cardPanel, "Primi Piatti");

        } else if (e.getSource() == secondoPiattoBtn) {
            secondoPiattoBtn.setEnabled(false);
            primoPiattoBtn.setEnabled(true);
            contornoBtn.setEnabled(true);
            dessertBtn.setEnabled(true);
            bibiteBtn.setEnabled(true);

            cardPanel.setVisible(true);
            cardLayout.show(cardPanel, "Secondi Piatti");

        } else if (e.getSource() == contornoBtn) {
            contornoBtn.setEnabled(false);
            primoPiattoBtn.setEnabled(true);
            secondoPiattoBtn.setEnabled(true);
            dessertBtn.setEnabled(true);
            bibiteBtn.setEnabled(true);

            cardPanel.setVisible(true);
            cardLayout.show(cardPanel, "Contorni");
        
        } else if (e.getSource() == dessertBtn) {
            dessertBtn.setEnabled(false);
            primoPiattoBtn.setEnabled(true);
            secondoPiattoBtn.setEnabled(true);
            contornoBtn.setEnabled(true);
            bibiteBtn.setEnabled(true);

            cardPanel.setVisible(true);
            cardLayout.show(cardPanel, "Desserts");

        } else if (e.getSource() == bibiteBtn) {
            bibiteBtn.setEnabled(false);
            primoPiattoBtn.setEnabled(true);
            secondoPiattoBtn.setEnabled(true);
            contornoBtn.setEnabled(true);
            dessertBtn.setEnabled(true);

            cardPanel.setVisible(true);
            cardLayout.show(cardPanel, "Bibite");
        
    
        } else if (e.getSource() == aggiungiPortataBtn) {
            aggiungiPortataBtn.setEnabled(false);
            String nuovoPiatto = JOptionPane.showInputDialog(null, "Inserisci il nome della nuova portata:\n[PORTATA] - €[XX.XX]", "Aggiungi nuova portata", JOptionPane.PLAIN_MESSAGE);

            if (nuovoPiatto != null && !nuovoPiatto.isEmpty() ) {

                String last5char = nuovoPiatto.substring(nuovoPiatto.length() - 5);
                //Object verificaPrezzo = Double.parseDouble(last5char);

                if (last5char.matches("\\d{2}\\.\\d{2}")){

                    JCheckBox nuovoCheckbox = new JCheckBox(nuovoPiatto);
                    // Aggiungi il nuovo checkbox al pannello corrispondente
                    if (!primoPiattoBtn.isEnabled()) {
                        primoPiattoPanel.add(nuovoCheckbox);
                    } else if (!secondoPiattoBtn.isEnabled()) {
                        secondoPiattoPanel.add(nuovoCheckbox);
                    } else if (!contornoBtn.isEnabled()) {
                        contornoPanel.add(nuovoCheckbox);
                    } else if (!dessertBtn.isEnabled()) {
                        dessertPanel.add(nuovoCheckbox);
                    }
                    cardPanel.revalidate();
                    cardPanel.repaint();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Non hai inserito il prezzo della portata!\nRicordati di aggiungere la portata come scritto nell'esempio.\nRiprova.", "Avviso", 2);
                }                
            }
            else if (nuovoPiatto != null){
                JOptionPane.showMessageDialog(this, "Devi inserire il nome e il prezzo di una nuova portata.\nRiprova.", "Avviso", 2);
            }
            aggiungiPortataBtn.setEnabled(true);


        } else if (e.getSource() == confermaBtn) {
            confermaBtn.setEnabled(false);
            confermaBtn.setBackground(null);
            StringBuilder ordine = new StringBuilder("Hai ordinato:\n");
            finalPrice = 0.00;

            // Controlla quali checkbox sono selezionati nel primoPiattoPanel
            ordine.append("\nPRIMI PIATTI:\n");
            for (Component component : primoPiattoPanel.getComponents()) {
                if (component instanceof JCheckBox) {
                    JCheckBox checkbox = (JCheckBox) component;
                    if (checkbox.isSelected()) {
                        String checkboxName = checkbox.getText();
                        String last5char = checkboxName.substring(checkboxName.length() - 5);
                        double prezzoPortata = Double.parseDouble(last5char);

                        finalPrice += prezzoPortata;
                        ordine.append("- "+checkbox.getText()).append("\n");
                    }
                }
            }

            // Controlla quali checkbox sono selezionati nel secondoPiattoPanel
            ordine.append("\nSECONDI PIATTI:\n");
            for (Component component : secondoPiattoPanel.getComponents()) {
                if (component instanceof JCheckBox) {
                    JCheckBox checkbox = (JCheckBox) component;
                    if (checkbox.isSelected()) {
                        String checkboxName = checkbox.getText();
                        String last5char = checkboxName.substring(checkboxName.length() - 5);
                        double prezzoPortata = Double.parseDouble(last5char);

                        finalPrice += prezzoPortata;
                        ordine.append("- "+checkbox.getText()).append("\n");
                    }
                }
            }

            // Controlla quali checkbox sono selezionati nel contornoPanel
            ordine.append("\nCONTORNI:\n");
            for (Component component : contornoPanel.getComponents()) {
                if (component instanceof JCheckBox) {
                    JCheckBox checkbox = (JCheckBox) component;
                    if (checkbox.isSelected()) {
                        String checkboxName = checkbox.getText();
                        String last5char = checkboxName.substring(checkboxName.length() - 5);
                        double prezzoPortata = Double.parseDouble(last5char);

                        finalPrice += prezzoPortata;
                        ordine.append("- "+checkbox.getText()).append("\n");
                    }
                }
            }

            // Controlla quali checkbox sono selezionati nel dessertPanel
            ordine.append("\nDESSERTS:\n");
            for (Component component : dessertPanel.getComponents()) {
                if (component instanceof JCheckBox) {
                    JCheckBox checkbox = (JCheckBox) component;
                    if (checkbox.isSelected()) {
                        String checkboxName = checkbox.getText();
                        String last5char = checkboxName.substring(checkboxName.length() - 5);
                        double prezzoPortata = Double.parseDouble(last5char);

                        finalPrice += prezzoPortata;
                        ordine.append("- "+checkbox.getText()).append("\n");
                    }
                }
            }

            // Controlla quali checkbox sono selezionati nel bibitePanel
            ordine.append("\nBIBITE:\n");
            for (Component component : bibitePanel.getComponents()) {
                if (component instanceof JCheckBox) {
                    JCheckBox checkbox = (JCheckBox) component;
                    if (checkbox.isSelected()) {
                        String checkboxName = checkbox.getText();
                        String last5char = checkboxName.substring(checkboxName.length() - 5);
                        double prezzoPortata = Double.parseDouble(last5char);

                        finalPrice += prezzoPortata;
                        ordine.append("- "+checkbox.getText()).append("\n");
                    }
                }
            }

            finalPrice = Math.round(finalPrice * 100.0) / 100.0;

            int result = JOptionPane.showConfirmDialog(this, ordine.toString()+"\nTOTALE: €"+finalPrice, "Conferma ordine",JOptionPane.OK_CANCEL_OPTION, 1);
            //System.out.println(result);
            if (result==JOptionPane.OK_OPTION) {
                if (finalPrice > 0){
                    Scontrino(ordine);
                    System.exit(0);  // Chiude il programma
                }
                else{
                    JOptionPane.showMessageDialog(this, "Devi ordinare prima di poter confermare l'ordine!\nRiprova.", "Avviso", 2);
                }
            }
            confermaBtn.setEnabled(true);
            confermaBtn.setBackground(Color.GREEN);
        }
    }

    public void Scontrino(StringBuilder ordine) {
        try {
            // Viene aperto un BufferedWriter per scrivere sul file
            BufferedWriter scontrino = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("scontrino.md"), StandardCharsets.UTF_8));

            // Scrive il contenuto Markdown sul file
            scontrino.write("## Scontrino\n# Ristorante: Di Tommaso\n"+ordine.toString()+"*****\n### Totale: €"+finalPrice+"\n\n");

            // Chiude il BufferedWriter dopo aver finito di scrivere
            scontrino.close();

            System.out.println("Lo scontrino è stato erogato con successo.");
        } catch (IOException e) {
            System.err.println("Si è verificato un errore durante l'erogazione dello scontrino: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuDigitale();
            }
        });
    }
}