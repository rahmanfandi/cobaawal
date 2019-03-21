/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ub.government.sispdb.model_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import org.ub.government.sispdb.model.Propinsi;
import org.ub.government.sispdb.model.Propinsi;

/**
 *
 * @author yhawin
 */
public class TableModel_WilayahPropinsi extends AbstractTableModel{
    List <Propinsi> list = new ArrayList <Propinsi>();
    //private String[] columnNames = {“Nama”, “NIM”,”Jurusan”, “Alamat”};

    public TableModel_WilayahPropinsi(List<Propinsi> list){
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
    		//SORRY DIDEFINISIKAN SECARA MANUAL
        return 2;
    }
    
    //NAMA COLUMN DIPAKE JFRAME DIDEFINISIKAN DISINI
    @Override
    public String getColumnName(int column){
//        switch(column){
//        case 0:
//            return ("ID");
//        case 1:
//            return("KODE1");
//        case 2:
//            return("DESKRIPSI");
//        default:
//            return null;
//        }
        switch(column){
	        case 0:
	            return ("KODE1");
	        case 1:
	            return("DESKRIPSI");
	        default:
            return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
//        switch(columnIndex){
//            case 0:
//                return list.get(rowIndex).getID();
//            case 1:
//                return list.get(rowIndex).getKode1().trim();
//            case 2:
//                return list.get(rowIndex).getDescription().trim();
////            case 3:
////                return list.get(rowIndex).getNotes();
//            default:
//                return null;
//        }
        
        switch(columnIndex){
	        case 0:
	            return list.get(rowIndex).getKode1();
	        case 1:
	            return list.get(rowIndex).getDescription() ;
	        default:
	        		return null;
        }
        
    }
    
     /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }
    
    //TAMBAHAN KITA
    public Propinsi get(int index){
        return list.get(index);
    }

    public void insert(Propinsi object){
        list.add(object);
        fireTableRowsInserted(getRowCount()-1,getRowCount()-1);
    }
    public void update(Propinsi object, int index){
        list.set(index, object);
        fireTableRowsUpdated(index,index);
    }
    public void delete(int index){
        list.remove(index);
        fireTableRowsDeleted(index,index);
    }
    
}
