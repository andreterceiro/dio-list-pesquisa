import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;

    /**
     * Construtor
     */
    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    /**
     * Permite adicionar um livro à lista de livros
     */
    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        Livro livro = new Livro(titulo, autor, anoPublicacao);
        this.livroList.add(livro);
    }

    /**
     * Permite pesquisar um ou mais livros na lista de livros por autor
     *
     * @param autor Autor a ser pesquisado
     * 
     * @return Retorna uma lista de livros do autor desejado
     */
    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosParaRetorno = new ArrayList<>();
        
        for (Livro livro: this.livroList) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosParaRetorno.add(livro);
            }
        }

        return livrosParaRetorno;
    }

    /**
     * Permite pesquisar um ou mais livros por um intervalo de anos
     * 
     * @param anoInicial Limite inicial para o ano do livro
     * @param anoFinal   Limite final para o ano do livro
     *
     * @return Retorna a lista de livros que tem o ano de publicação entre os anos informados
     */
    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosParaRetorno = new ArrayList<>();
        
        for (Livro livro: this.livroList) {
            int anoPublicacaoLivro = livro.getAnoPublicacao();
            if (anoPublicacaoLivro >= anoInicial && anoPublicacaoLivro <= anoFinal) {
                livrosParaRetorno.add(livro);
            }
        }

        return livrosParaRetorno;
    }

    /**
     * Permite pesquisar 1 livro pelo seu título.
     * Retorna apenas a primeira ocorrência na lista de livros
     * 
     * @param titulo Título a ser pesquisado
     * 
     * @return Retorna o Livro encontrado 
     */
    public Livro pesquisarPorTitulo(String titulo) {        
        for (Livro livro: this.livroList) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    /**
     * Método main a ser invocado cia CLI para estes manuais
     * @param args
     */
    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2020);
        catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2021);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2022);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2023);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 1994);

        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 2"));
        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 4"));
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2020, 2022));
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2020, 2021));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));
    }
}