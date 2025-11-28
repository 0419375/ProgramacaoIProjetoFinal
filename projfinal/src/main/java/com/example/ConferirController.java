package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class ConferirController implements Initializable{
    
    Pedido novo = App.pedidos.get(App.pedidos.size()-1);
    

    @FXML
    TextArea taPedido;
    @Override
    public void initialize(URL location, ResourceBundle resources){
        updatePedido();
    }

    @FXML
    private void cancela() throws IOException{
        App.pedidos.remove(App.pedidos.size()-1);
        App.setRoot("pedir");
    }

    @FXML
    private void confirma() throws IOException{
        novo.updateStatus();
        App.setRoot("pedir");
    }
    private void updatePedido() {
        taPedido.clear();
        for (int i = 0; i < novo.getSize(); i++) {
            taPedido.setText(taPedido.getText() + "-" + novo.get(i).getNome() + "\t"
                    + novo.get(i).getPreco() + "\n");
        }
        taPedido.setText(String.format(taPedido.getText() + "Valor total:\t%.2f", novo.calculaTotal()));
    }
}
