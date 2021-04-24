package teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteDatas {
	
	public static void main(String[] args) {
		
		 new TesteDatas();
	}
	
	public TesteDatas() {
		String dataInicialHTMLPtBr 		= "11/04/2021 11:35:12"; 
		String dataConvertidaPraMysql 	= this.dateTimeFromHTMLtoMYSQL(dataInicialHTMLPtBr);
		String dataConvertidaPraHTMLPtBr= this.dateTimeFromMySqltoHTML(dataConvertidaPraMysql);
		
		String saida = "";
		saida += "\n Data com formato para MYSQL:" + dataConvertidaPraMysql;
		saida += "\n Data com formato para HTML:"  + dataConvertidaPraHTMLPtBr;
		
		System.out.print( saida );
		
	}
	
	
	public String dateTimeFromHTMLtoMYSQL( String htmlStrDate ) {
		// Pego em formato brasileiro a String como dia/mês/ano
		Date date = null;
		String mySqlStrDate = "";
		try {
			// Converto a String pra Date informando o formato inserido pelo usuário no html
			date =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(htmlStrDate);
			// Indico o formato que eu quero de destino no Mysql
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// Mando formatar a variável date como uma String
			mySqlStrDate = dateFormat.format(date);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return(mySqlStrDate);
	}
	
	public String dateTimeFromMySqltoHTML( String mySqlStrDate ) {
		// Pego em formato do MySQL a String como ano-mês-dia
		Date date = null;
		String  htmlStrDate = "";
		try {
			// Converto a String pra Date informando o formato listado no MySql
			date =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(mySqlStrDate);
			// Indico o formato que eu quero de destino no HTML em PtBr
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			// Mando formatar a variável date como uma String
			htmlStrDate = dateFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return(htmlStrDate);
	}
	

}