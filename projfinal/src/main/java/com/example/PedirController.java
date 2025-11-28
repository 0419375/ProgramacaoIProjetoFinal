package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PedirController {

    Pedido novo = new Pedido();

    @FXML
    TextArea taPedido;
    @FXML
    TextField tfItemNum;
    @FXML
    Button btRemover;
    @FXML
    Button btClear;

    @FXML
    private void addLancheSimples() {
        novo.adicionarItem("Lanche", 12.99);
        updatePedido();
    }

    @FXML
    private void addBebida() {
        novo.adicionarItem("Bebida", 6.99);
        updatePedido();
    }

    @FXML
    private void addPorcao() {
        novo.adicionarItem("Porção", 6.99);
        updatePedido();
    }

    @FXML
    private void addLanchePremium() {
        novo.adicionarItem("Lanche Premium", 99.99);
        updatePedido();
    }

    @FXML
    private void removerItem() {
        if (tfItemNum.getText() != "") {
            int num = Integer.parseInt(tfItemNum.getText());
            novo.removerItem(num);
            updatePedido();
        }
    }

    @FXML
    private void clearPedido() {
        novo.clear();
        updatePedido();
    }

    @FXML
    private void confirma() throws IOException{
        App.pedidos.add(novo);
        App.setRoot("conferir");
    }

    private void updatePedido() {
        taPedido.clear();
        for (int i = 0; i < novo.getSize(); i++) {
            taPedido.setText(taPedido.getText() + "[" + (i + 1) + "]\t" + novo.get(i).getNome() + "\t"
                    + novo.get(i).getPreco() + "\n");
        }
    }
}