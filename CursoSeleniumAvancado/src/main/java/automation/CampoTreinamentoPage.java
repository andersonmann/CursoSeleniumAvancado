
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

	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);
	}

	public void setSobrenome(String sobrenome) {
		dsl.escrever("elementosForm:sobrenome", sobrenome);
	}

	/********* Sexo ************/

	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}

	public void setSexoFeminino() {
		dsl.clicarRadio("elementosForm:sexo:1");
	}

	/********* Comida ************/

	public void setComidaFavoritaCarne() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}

	public void setComidaFavoritaFrango() {
		dsl.clicarRadio("elementosForm:sexo:1");
	}

	public void setComidaFavoritaPizza() {
		dsl.clicarRadio("elementosForm:sexo:2");
	}

	public void setComidaFavoritaVegetariano() {
		dsl.clicarRadio("elementosForm:sexo:3");
	}

	/********* Escolaridade ************/

	public void setEscolaridade(String escolaridade) {
		dsl.selecionarCombo("elementosForm:escolaridade", escolaridade);
	}

	

}
