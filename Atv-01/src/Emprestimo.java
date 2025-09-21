public class Emprestimo {
    String data;
    String cliente;
    Midia[] midias;

    public Emprestimo(){
        cliente = "";
        data = "";
        midias = new Midia[5];
    }


    public void impressaoDados() {
        System.out.println("Data: " + data);
        System.out.println("Cliente: " + cliente);
        System.out.println("Mídias emprestadas:");
        for (Midia midia : midias) {
            System.out.println(midia.retornaDados());
        }
    }
}

/*public void impressaoDados() {
    System.out.println("Data: " + data);
    System.out.println("Cliente: " + cliente);
    System.out.println("Mídias emprestadas:");
    for (int i = 0; i < midias.length; i++) {
        System.out.println(midias[i].retornaDados());
    }
}
*/