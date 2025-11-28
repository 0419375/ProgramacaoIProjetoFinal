package com.example;

import java.util.ArrayList;
// import java.util.Random;

public class Pedido {

    private int pedidoId;
    private ArrayList<Item> itens = new ArrayList<Item>();
    // private Random random = new Random();
    private int status = 0; //0 = não confirmado, 1 = em andamento, 2 ou maior = concluído

    public Pedido() {
        // this.pedidoId = random.nextInt(9999) + 1;
        this.pedidoId = App.pedidos.size()+1;
    }

    public void adicionarItem(String nome, double preco){
        Item novo = new Item(nome, preco);
        itens.add(novo);
    }

    public void removerItem(int index){
        if (!itens.isEmpty() && itens.size() > index-1) {
            itens.remove(index-1);
        }
    }

    public double calculaTotal(){
        double valorTotal = 0.00;
        for (int i = 0; i < itens.size(); i++) {
            valorTotal += itens.get(i).getPreco();
        }
        return valorTotal;
    }

    public void updateStatus(){
        this.status++;
    }

    public int getStatus(){
        return status;
    }

    public void clear(){
        itens.clear();
    }

    public Item get(int index){
        return itens.get(index);
    }

    public int getSize(){
        return itens.size();
    }

    public int getPedidoId(){
        return this.pedidoId;
    }

}
