
package automation;

import org.openqa.selenium.WebDriver;

/**
 * @author Anderson
 *
 */
public class CampoTreinamentoPage {
	private DSL dsl;

	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	/********* Cadastro nome ************/

	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);
	}

	/********* Cadastro sobrenome ************/

	public void setSobrenome(String sobrenome) {
		dsl.escrever("elementosForm:sobrenome", sobrenome);
	}

	/********* Cadastro Sexo ************/

	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}

	public void setSexoFeminino() {
		dsl.clicarRadio("elementosForm:sexo:1");
	}

	/********* Cadastro Comida ************/

	public void setComidaFavoritaCarne() {
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
	}

	public void setComidaFavoritaFrango() {
		dsl.clicarRadio("elementosForm:comidaFavorita:1");
	}

	public void setComidaFavoritaPizza() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}

	public void setComidaFavoritaVegetariano() {
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
	}

	/********* Cadastro Escolaridade ************/

	public void setEscolaridade(String escolaridade) {
		dsl.selecionarCombo("elementosForm:escolaridade", escolaridade);
	}

	/********* Cadastro Esportes ************/

	public void setEsporte(String... esportes) {
		for (String esporte : esportes) {
			dsl.selecionarCombo("elementosForm:esportes", esporte);
		}
	}

	/********* Botao Cadastrar ************/

	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}

	/********* Obter Resultado cadastro ************/

	public String obterResultadoCadastro() {
		return dsl.obterTexto("resultado");
	}

	/********* Obter Nome cadastro ************/

	public String obterNomeCadastro() {
		return dsl.obterTexto("descNome");
	}

	/********* Obter Sobrenome cadastro ************/

	public String obterSobrenomeCadastro() {
		return dsl.obterTexto("descSobrenome");
	}

	/********* Obter Sexo cadastro ************/

	public String obterSexoCadastro() {
		return dsl.obterTexto("descSexo");
	}

	/********* Obter Comida cadastro ************/

	public String obterComidaCadastro() {
		return dsl.obterTexto("descComida");
	}

	/********* Obter Escolaridade cadastro ************/

	public String obterEscolaridadeCadastro() {
		return dsl.obterTexto("descEscolaridade");
	}

	/********* Obter Esporte cadastro ************/

	public String obterEsporteCadastro() {
		return dsl.obterTexto("descEsportes");
	}

}