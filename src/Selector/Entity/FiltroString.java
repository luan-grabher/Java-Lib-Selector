package Selector.Entity;

import java.util.ArrayList;
import java.util.List;

public class FiltroString {

    private List<String> possui = new ArrayList<>();
    private List<String> naoPossui = new ArrayList<>();

    public FiltroString() {
    }

    public FiltroString(String possuiENaoPossui) {
        try {
            String[] possui_naoPossui_Split = possuiENaoPossui.split("#");
            if (possui_naoPossui_Split.length == 2) {
                construirComStrings(possui_naoPossui_Split[0], possui_naoPossui_Split[1]);
            } else if (possui_naoPossui_Split.length == 1) {
                construirComStrings(possuiENaoPossui, "");
            }
        } catch (Exception e) {
        }
    }

    public FiltroString(String possuiStr, String naoPossuiStr) {
        construirComStrings(possuiStr, naoPossuiStr);
    }

    private void construirComStrings(String possuiStr, String naoPossuiStr) {
        String[] possuiSplit = possuiStr.split(";");
        String[] naoPossuiSplit = naoPossuiStr.split(";");

        for (String argumento : possuiSplit) {
            this.possui.add(argumento);
        }
        for (String argumento : naoPossuiSplit) {
            this.naoPossui.add(argumento);
        }
    }

    public FiltroString(List<String> possui, List<String> naoPossui) {
        this.possui = possui;
        this.naoPossui = naoPossui;
    }

    public void setPossui(List<String> possui) {
        this.possui = possui;
    }

    public void setNaoPossui(List<String> naoPossui) {
        this.naoPossui = naoPossui;
    }

    public boolean éFiltroDaString(String str) {
        String stringComparada = str.toLowerCase();
        boolean possui_tudo = true;
        boolean nao_possui_nada = true;

        for (String p : possui) {
            p = p.toLowerCase();
            if (stringComparada.contains(p) == false) {
                possui_tudo = false;
                break;
            }
        }

        if (possui_tudo) {
            for (String n : naoPossui) {
                n = n.toLowerCase();
                if (!"".equals(n)) {
                    if (stringComparada.contains(n)) {
                        nao_possui_nada = false;
                        break;
                    }
                }

            }
        }

        return possui_tudo && nao_possui_nada;
    }

    public String getPossui() {
        return printList(possui);
    }

    public String getNaoPossui() {
        return printList(naoPossui);
    }

    public String getListPossuiStr(String separador){
        return printList(possui, separador);
    }
    
    public String getListNaoPossuiStr(String separador){
        return printList(naoPossui, separador);
    }
    
    public String printList(List<String> list){
        return printList(list, " ");
    }
    
    public String printList(List<String> list, String separador) {
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (String l : list) {
                sb.append(l).append(separador);
            }
            String strFinal = sb.toString();
            strFinal = strFinal.substring(0, strFinal.length());

            return strFinal;
        }else{
            return "";
        }
    }

}
