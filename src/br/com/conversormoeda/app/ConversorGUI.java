package br.com.conversormoeda.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversor de Moedas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setResizable(false);  //

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(8, 1, 5, 5));

        JTextField valorField = new JTextField();
        JComboBox<String> deMoeda = new JComboBox<>(new String[]{"USD", "BRL", "ARS", "COP", "CLP", "BOB"});
        JComboBox<String> paraMoeda = new JComboBox<>(new String[]{"USD", "BRL", "ARS", "COP", "CLP", "BOB"});

        JButton converterButton = new JButton("Converter");

        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setLineWrap(true);
        resultadoArea.setWrapStyleWord(true);
        resultadoArea.setEditable(false);
        resultadoArea.setPreferredSize(new Dimension(350, 80));

        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel.add(new JLabel("Valor:"));
        panel.add(valorField);
        panel.add(new JLabel("De:"));
        panel.add(deMoeda);
        panel.add(new JLabel("Para:"));
        panel.add(paraMoeda);
        panel.add(converterButton);
        panel.add(scrollPane);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        converterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valorTexto = valorField.getText();
                String de = (String) deMoeda.getSelectedItem();
                String para = (String) paraMoeda.getSelectedItem();

                try {
                    double valor = Double.parseDouble(valorTexto);
                    br.com.conversormoeda.service.ExchangeRateAPI api = new br.com.conversormoeda.service.ExchangeRateAPI();
                    api.configurarMoedasDeConversao(de, para);
                    api.setValor(valor);
                    String resultado = api.realizarConversao();
                    resultadoArea.setText(resultado);
                } catch (Exception ex) {
                    resultadoArea.setText("Erro: Digite somente números e utilize ponto (.) para separar decimais " + ex.getMessage());
                }
            }
        });
    }
}
