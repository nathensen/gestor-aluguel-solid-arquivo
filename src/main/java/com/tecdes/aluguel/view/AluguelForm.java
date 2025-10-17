package com.tecdes.aluguel.view;

import com.tecdes.aluguel.controller.AluguelController;
import com.tecdes.aluguel.model.Aluguel;
import com.tecdes.aluguel.model.AluguelCasa;
import com.tecdes.aluguel.model.AluguelApartamento;
import com.tecdes.aluguel.model.AluguelComercial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AluguelForm extends JFrame {
    private JTextField txtValor;
    private JTextField txtMeses;
    private JComboBox<String> cmbTipo;
    private JTextArea txtResultado;
    private AluguelController controller;

    public AluguelForm(AluguelController controller) {
        this.controller = controller;
        setTitle("Gestor de Aluguéis");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de entrada
        JPanel pnlEntrada = new JPanel(new GridLayout(3, 2));
        pnlEntrada.add(new JLabel("Valor Mensal:"));
        txtValor = new JTextField();
        pnlEntrada.add(txtValor);

        pnlEntrada.add(new JLabel("Meses:"));
        txtMeses = new JTextField();
        pnlEntrada.add(txtMeses);

        pnlEntrada.add(new JLabel("Tipo de Aluguel:"));
        cmbTipo = new JComboBox<>(new String[]{"Casa", "Apartamento", "Comercial"});
        pnlEntrada.add(cmbTipo);

        add(pnlEntrada, BorderLayout.NORTH);

        // Área de resultado
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        // Botões
        JPanel pnlBotoes = new JPanel();
        JButton btnProcessar = new JButton("Processar");
        JButton btnSalvar = new JButton("Salvar Histórico");
        JButton btnRecarregar = new JButton("Recarregar Histórico");

        pnlBotoes.add(btnProcessar);
        pnlBotoes.add(btnSalvar);
        pnlBotoes.add(btnRecarregar);
        add(pnlBotoes, BorderLayout.SOUTH);

        // Eventos
        btnProcessar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processarAluguel();
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Histórico salvo!");
            }
        });

        btnRecarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(controller.listarAlugueis());
            }
        });

        setVisible(true);
    }

    private void processarAluguel() {
        try {
            double valor = Double.parseDouble(txtValor.getText());
            int meses = Integer.parseInt(txtMeses.getText());
            String tipo = (String) cmbTipo.getSelectedItem();

            Aluguel aluguel;
            switch (tipo) {
                case "Casa":
                    aluguel = new AluguelCasa(valor, meses);
                    break;
                case "Apartamento":
                    aluguel = new AluguelApartamento(valor, meses);
                    break;
                case "Comercial":
                    aluguel = new AluguelComercial(valor, meses);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo inválido");
            }

            String resultado = controller.processarAluguel(aluguel);
            txtResultado.append(resultado + "\n");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe valores válidos!");
        }
        
    }
}