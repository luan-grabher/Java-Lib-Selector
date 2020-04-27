package Selector;

import Selector.Entity.FiltroString;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Pasta {

    /**
     * Mostra Jframe para escolher uma pasta
     *
     * @return Pasta selecionada no Jframe.
     */
    public static File selecionar() {
        File arquivo = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            arquivo = selectedFile;
        }

        return arquivo;
    }

    /**
     * Verifica uma pasta msotrando o JFrame
     */
    public static boolean verifica(String local_pasta) {
        return verifica(local_pasta, true);
    }

    /**
     * @return Se a pasta Existe
     */
    public static boolean verifica(String local_pasta, boolean msg_jframe) {
        boolean retorno = false;
        String local = local_pasta;
        if (local.length() <= 5) {
            if (msg_jframe) {
                JOptionPane.showMessageDialog(null,
                        " O local esta em branco!",
                        " Alerta", JOptionPane.WARNING_MESSAGE);
            } else {
                System.out.println("O local está em branco!");
            }
        } else {
            //VERIFICAR SE EXISTE
            File arq = new File(local);

            if (arq.getAbsoluteFile().exists() == false) {
                if (msg_jframe) {
                    JOptionPane.showMessageDialog(null,
                            " A pasta não existe!",
                            " Alerta", JOptionPane.WARNING_MESSAGE);
                } else {
                    System.out.println("A pasta não existe!");
                }
            } else {
                retorno = true;
            }
        }

        return retorno;
    }

    /**
     * Procura arquivo apenas com filtro de possuir
     */
    public static File procura_arquivo(File local_arquivo, String possui_no_nome) {
        return procura_arquivo(local_arquivo, possui_no_nome, "");
    }

    /**
     * Retorna o File de um filtro em uma pasta
     *
     * @param local_arquivo File do local onde está o arquivo
     * @param possui_no_nome Argumentos separados por ; que devem estar
     * presentes no nome do arquivo. Inclua a extensão
     * @param nao_possui_no_nome Argumentos separados por ; que não devem estar
     * presentes no nome
     * @return O primeiro arquivo que estar no filtro de possui e não possui no
     * nome. Caso não encontre, retorna null.
     */
    public static File procura_arquivo(File local_arquivo, String possui_no_nome, String nao_possui_no_nome) {
        File arquivo = null;
        if (verifica(local_arquivo.getAbsolutePath(), false)) {
            FiltroString filtro;
            if (!nao_possui_no_nome.equals("")) {
                filtro = new FiltroString(possui_no_nome, nao_possui_no_nome);
            } else {
                filtro = new FiltroString(possui_no_nome);
            }

            File[] s = local_arquivo.listFiles();
            for (File file : s) {
                if (filtro.éFiltroDaString(file.getName())) {
                    arquivo = file;
                    break;
                }
            }
        }
        return arquivo;
    }
}
