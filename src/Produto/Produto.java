package Produto;

public class Produto {
	
	private String nome;
	private int quantidade;
	private int id;
	
	public Produto(String nome, int quantidade) {
		setNome(nome);
		setQuantidade(quantidade);
		
	}
	public Produto(String nome, int quantidade, int id) {
		setNome(nome);
		setQuantidade(quantidade);
		setId(id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
