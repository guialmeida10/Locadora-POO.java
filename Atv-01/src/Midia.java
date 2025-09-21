public class Midia {
    String tipo;
    String descricao;
    float valor;
    boolean status;

    public Midia() {
        tipo = "";
        descricao = "";
        valor = 0;
        status = true;
    }

    public Midia(String tipo, String descricao, float valor) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public void alterarStatus() {
        if (status == true) {
            status = false;
        } else {
            status = true;
        }
    }

    public String retornaDados() {
        return "Tipo: " + tipo + "\nDescrição: " + descricao + "\nValor: " + valor + "\nStatus: " + status;
    }


}