package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AdmController {

    Pedido atual = null;

    @FXML
    TextArea taConcluido;
    @FXML
    TextArea taPedidos;
    @FXML
    TextArea taDetalhes;
    @FXML
    TextField tfSelect;

    @FXML
    public void updateAndamento() {
        taPedidos.clear();
        for (int i = 0; i < App.pedidos.size(); i++) {
            if (App.pedidos.get(i).getStatus() == 1) {
                taPedidos.setText(
                        taPedidos.getText() + "[" + (i + 1) + "] Pedido #" + App.pedidos.get(i).getPedidoId() + "\n");
            }
        }
    }

    public void selectPedido() {
        try {
            if (Integer.parseInt(tfSelect.getText()) <= App.pedidos.size()) {
                atual = App.pedidos.get(Integer.parseInt(tfSelect.getText()) - 1);
                updateDetalhes();
            }
        } catch (Exception e) {}
    }

    public void updateDetalhes() {
        taDetalhes.clear();
        for (int i = 0; i < atual.getSize(); i++) {
            taDetalhes.setText(taDetalhes.getText() + "-" + atual.get(i).getNome() + "\n");
        }
    }

    public void concluir() {
        atual.updateStatus();
        atual = null;
        taDetalhes.clear();
        updateConcluido();
    }

    public void updateConcluido(){
        taConcluido.clear();
        for (int i = 0; i < App.pedidos.size(); i++) {
            if (App.pedidos.get(i).getStatus() == 1) {
                taConcluido.setText(
                        String.format(taConcluido.getText() + "Pedido #" + App.pedidos.get(i).getPedidoId() + "\t%.2f\n", App.pedidos.get(i).calculaTotal()));
            }
        }
    }
}
