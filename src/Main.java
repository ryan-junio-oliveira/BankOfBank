import com.bankofbank.Account;
import com.bankofbank.Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame;
    private JTextField campoNumeroConta;
    private JTextField campoValor;
    private JList<Account> listaContas;
    private Bank bank;

    public Main() {
        initializeFrame();
        bank = new Bank();
        createUI();
    }

    private void initializeFrame() {
        frame = new JFrame("Banco");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
    }

    private void createUI() {
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        createComponents(painel);

        frame.getContentPane().add(painel);
        frame.setVisible(true);
    }

    private void createComponents(JPanel painel) {
        JLabel labelNumeroConta = new JLabel("Número da conta:");
        campoNumeroConta = new JTextField(10);
        JLabel labelValor = new JLabel("Valor:");
        campoValor = new JTextField(10);
        listaContas = new JList<>();
        listaContas.setPreferredSize(new Dimension(200, 100));
        JScrollPane scrollPane = new JScrollPane(listaContas);

        JButton botaoDepositar = createButton("Depositar", e -> depositar());
        JButton botaoSacar = createButton("Sacar", e -> sacar());
        JButton botaoCriarConta = createButton("Criar Conta", e -> criarConta());
        JButton botaoDeletarConta = createButton("Deletar Conta", e -> deletarConta());
        JButton botaoExibirDetalhes = createButton("Exibir Detalhes", e -> exibirDetalhes());

        painel.add(labelNumeroConta);
        painel.add(campoNumeroConta);
        painel.add(labelValor);
        painel.add(campoValor);
        painel.add(botaoDepositar);
        painel.add(botaoSacar);
        painel.add(botaoCriarConta);
        painel.add(botaoDeletarConta);
        painel.add(scrollPane);
        painel.add(botaoExibirDetalhes);
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }

    private void depositar() {
        String valorText = campoValor.getText();
        if (valorText.isEmpty()) {
            showErrorDialog("Informe um valor para continuar.");
            return;
        }

        double valor = Double.parseDouble(campoValor.getText());
        Account account = listaContas.getSelectedValue();
        if (account == null) {
            showErrorDialog("Selecione uma conta para continuar.");
            return;
        }

        boolean result = bank.depositar(account.getNumberAccount(), valor);
        if (result) {
            showSuccessDialog("Depósito realizado com sucesso.");
        } else {
            showErrorDialog("Não foi possível realizar o depósito.");
        }
        updateAccountList();
    }

    private void sacar() {
        String valorText = campoValor.getText();
        if (valorText.isEmpty()) {
            showErrorDialog("Informe um valor para continuar.");
            return;
        }

        double valor = Double.parseDouble(campoValor.getText());
        Account account = listaContas.getSelectedValue();
        if (account == null) {
            showErrorDialog("Selecione uma conta para continuar.");
            return;
        }

        boolean result = bank.sacar(account.getNumberAccount(), valor);
        if (result) {
            showSuccessDialog("Saque realizado com sucesso.");
        } else {
            showErrorDialog("Não foi possível realizar o saque.");
        }
        updateAccountList();
    }

    private void criarConta() {
        try {
            int numeroConta = Integer.parseInt(campoNumeroConta.getText());
            double valor = Double.parseDouble(campoValor.getText());
            Account account = new Account(numeroConta, valor);
            bank.insertAccount(account);
            updateAccountList();
        } catch (NumberFormatException exception) {
            showErrorDialog("Número de conta ou valor inválido(s)");
        }
    }

    private void deletarConta() {
        try {
            Account account = listaContas.getSelectedValue();
            if (account == null) {
                showErrorDialog("Selecione uma conta para continuar.");
                return;
            }

            boolean result = bank.deleteAccount(account.getNumberAccount());
            if (result) {
                showSuccessDialog("Conta deletada com sucesso.");
            } else {
                showErrorDialog("Nenhuma conta encontrada.");
            }
            updateAccountList();
        } catch (NumberFormatException exception) {
            showErrorDialog("Não foi possível deletar a conta.");
        }
    }

    private void updateAccountList() {
        listaContas.setListData(bank.getAccounts().toArray(new Account[0]));
    }

    private void exibirDetalhes() {
        Account account = listaContas.getSelectedValue();
        if (account != null) {
            JOptionPane.showMessageDialog(null,
                    "Número da conta: " + account.getNumberAccount() + "\n" +
                            "Saldo: " + account.getBalance(),
                    "Detalhes da Conta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro ao processar operação", JOptionPane.ERROR_MESSAGE);
    }

    private void showSuccessDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Sucesso ao processar operação", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new Main();
    }
}