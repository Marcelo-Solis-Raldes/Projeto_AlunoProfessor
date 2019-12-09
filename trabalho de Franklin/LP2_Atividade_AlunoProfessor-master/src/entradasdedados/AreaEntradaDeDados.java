
package entradasdedados;

import javax.swing.JOptionPane;
import modelo.AreaModel;

public class AreaEntradaDeDados {

    public AreaModel entradaArea(){
        AreaModel area = new AreaModel();
        area.setDescricao(JOptionPane.showInputDialog("Entre com a descrição da Área: "));
        
        return area;
    }

    public AreaModel novaEntradaArea(AreaModel area){
        area.setDescricao(JOptionPane.showInputDialog("Entre com a nova descrição da Área: "));
        
        return area;
    }
    
    public int informarID(String acao){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID de quem deseja "+acao+": "));
        
        return id;
    }
    
}
