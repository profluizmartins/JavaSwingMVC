public class Main {

    public static void main(String[] args) {

        ProdutoService ps = new ProdutoService();

        try {
            Produto p1 = new Produto("Notebook", 3500, 5);
            ps.adicionarProduto(p1);

            Produto p2 = new Produto("Mouse", 90, 10);
            ps.adicionarProduto(p2);

            Produto novo = new Produto("Mouse Gamer", 120, 8);
            novo.setId(2);
            ps.atualizarProduto(novo);

            ps.removerProduto(1);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

class Produto {

    private int id;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

class ProdutoService {

    public void adicionarProduto(Produto p) {
        validar(p);
        System.out.println("Produto cadastrado: " + p.getNome());
    }

    public void atualizarProduto(Produto p) {
        if (p.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        validar(p);
        System.out.println("Dados atualizados: " + p.getNome());
    }

    public void removerProduto(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        System.out.println("Produto removido (ID " + id + ")");
    }

    private void validar(Produto p) {
        if (p.getNome() == null || p.getNome().trim().equals("")) {
            throw new IllegalArgumentException("Nome não pode ficar vazio.");
        }
        if (p.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço inválido.");
        }
        if (p.getQuantidade() < 0) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }
    }
}
