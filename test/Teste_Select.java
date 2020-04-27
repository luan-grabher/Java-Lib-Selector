
import Selector.Pasta;
import java.io.File;


public class Teste_Select {


    public static void main(String[] args) {
        String lugar = "G:\\Contábil\\Clientes\\CB Porto Alegre Comercio de Alimentos Ltda\\Escrituração mensal\\2019\\Extratos\\12.2019";
        File lugarr = new File(lugar);
        
        File getnet = Pasta.procura_arquivo(lugarr, "banri;.ofx", "");
        
        if(getnet != null){
            System.out.println(getnet.getAbsoluteFile());
        }else{
            System.out.println("NAO ENCONTROU");
        }
    }
    
}
