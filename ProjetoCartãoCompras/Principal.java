package ProjetoCartãoCompras;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o valor limite do cartão: ");
        double limite = leitura.nextDouble();
        CartãoDeCredito cartãoDeCredito = new CartãoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite o item a ser comprado: ");
            String descricao = leitura.next();

            System.out.println("Digite o valor para compra: ");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao,valor);
            boolean compraRealizada = cartãoDeCredito.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar: ");
                sair = leitura.nextInt();
            }
            else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }

        System.out.println("_____________________________");
        System.out.println("Compras Realizadas:\n");
        Collections.sort(cartãoDeCredito.getCompras());
        for (Compra a : cartãoDeCredito.getCompras()) {
            System.out.println(a.getDescricao() + " : " +a.getValor());
        }
        System.out.println("\nSaldo do cartão: " +cartãoDeCredito.getSaldo());
    }
}
