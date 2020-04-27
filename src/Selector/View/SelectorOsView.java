package Selector.View;

import Selector.Entity.FiltroString;
import java.io.File;

public class SelectorOsView {

    public static String msgArquivoPastaNaoEncontrado(File pasta, FiltroString filtroProcurado) {
        String possui = filtroProcurado.getPossui();
        String naoPossui = filtroProcurado.getNaoPossui();

        StringBuilder sb = new StringBuilder();
        sb.append("Arquivo/Pasta ");
        sb.append("com '").append(possui).append("' no nome ");
        if (!naoPossui.equals("")) {
            sb.append("e sem '").append(naoPossui).append("' no nome ");
        }
        sb.append("não encontrado na pasta").append(link(pasta));

        return sb.toString();
    }

    private static String link(File file) {
        return "<a href='" + file.getAbsolutePath() + "'>" + file.getName() + "</a>";
    }
}
