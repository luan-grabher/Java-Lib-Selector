package Selector;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Arquivo {

    /**
     *  Mostra janela para escolha de um arquivo
     *  @return File do arquivo escolhido
     */
    public static File selecionar(String local, String nomeTipo, String tipo) {
        File arquivo;
        arquivo = new File(local);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(nomeTipo, tipo));
        fileChooser.setAcceptAllFileFilterUsed(false);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            arquivo = selectedFile;
        }

        return arquivo;
    }

    /**
     *  Verifica e mostra JFrame
     */
    public static boolean verifica(String local_arquivo, String extensao) {
        return verifica(local_arquivo, extensao, true);
    }

    /**
     *  Verifica se o arquivo existe e é da extensão correta
     *  @return Se o arquivo existe e é da extensão passada
     */
    public static boolean verifica(String local_arquivo, String extensao, boolean mostrarJframe) {
        boolean retorno = false;
        String local = local_arquivo.toLowerCase();
        extensao = extensao.toLowerCase();
        if (local.length() <= 5) {
            showError("O local do arquivo não pode ficar em branco!",mostrarJframe);
        } else if (extensao.equals(local.substring(local.length() - extensao.length(), local.length()))) {
            //VERIFICAR SE ARQUIVO EXISTE
            File arq = new File(local);

            if (arq.exists() == false) {
                showError("O arquivo não existe!", mostrarJframe);
            } else {
                retorno = true;
            }
        } else {
            showError("Deve ser um arquivo " + extensao + "!", mostrarJframe);
        }

        return retorno;
    }

    
    /**
     *  Mostra erro por JFrame ou System out
     */
    private static void showError(String message, boolean jframe) {
        if (jframe) {
            JOptionPane.showMessageDialog(null,
                    message,
                    " Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
            System.out.println(message);
        }
    }
}
