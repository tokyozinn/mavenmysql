package mavenpackage;

public class Clientes {

	
	private String id;
	private String nome;
	private String cpf;
	
	public String getCpf() {
		return this.cpf;
	}
	public String getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
