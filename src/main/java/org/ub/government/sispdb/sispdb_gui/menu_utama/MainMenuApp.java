/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ub.government.sispdb.sispdb_gui.menu_utama;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.ub.government.sispdb.master.ikan_jenis.IkanJenisView;
import org.ub.government.sispdb.master.ikan_subkelas.IkanSubKelasView;
import org.ub.government.sispdb.sispdb_gui.master_ikanjenis.IkanJenis_IntFrame;
import org.ub.government.sispdb.sispdb_gui.master_ikansubkelas.IkanSubKelas_IntFrame;
import org.ub.government.sispdb.sispdb_gui.master_wilayah.WilayahIntFrame;
import org.ub.government.sispdb.sispdb_gui.tabulasi_perikanan_laut.TabulasiPerikananLautIntFrame;
import org.ub.government.sispdb.sispdb_gui.utilitas.tabulasi_to_text.TabExtractToTextFrame;


/**
 *
 * @author yhawin
 */
public class MainMenuApp extends MainMenuFrame implements MainMenuListenerInter{

    WilayahIntFrame masterWilayahView = null;
    
    IkanJenisView masterJenisIkanView = null;
    IkanSubKelasView masterSubKelasView = null;

    TabulasiPerikananLautIntFrame tabulasiPerikananLautView = null;

    TabExtractToTextFrame tabExtractToTextView = null;
    
    public MainMenuApp(){
        initMenuListener();
        initViews();
    }
    public void initMenuListener() {
        getMenuItemParameterSistem().addActionListener(e -> menuItem_SettingParamenterSistem_ActionPerformed(e));
        getMenuItemPengguna().addActionListener(e -> menuItem_SettingPengguna_ActionPerformed(e));
        getMenuItemLogPengguna().addActionListener(e -> menuItem_SettingLogPengguna_ActionPerformed(e));

        getMenuItemIkan().addActionListener(e -> menuItem_MasterIkan_ActionPerformed(e)); //TIDAK ADA
        getMenuItemIkan().setVisible(false); //TIDAK ADA MAKANYA DI UN-VISIBLE
        
        getMenuItemJenisIkan().addActionListener(e -> menuItem_MasterJenisIkan_ActionPerformed(e));
        getMenuItemSubKelas().addActionListener(e -> menuItem_MasterSubKelas_ActionPerformed(e));
        
        getMenuItemWilayahAdministratif().addActionListener(e -> menuItem_MasterWilayahAdministratif_ActionPerformed(e));

        getMenuItemPerikananTangkapLaut().addActionListener(e -> menuItem_TabulasiPerikananTangkapLaut_ActionPerformed(e));
        getMenuItemPerikananUmumDarat().addActionListener(e -> menuItem_TabulasiPerikananTangkapLaut_ActionPerformed(e));

        getMenuItemTabulasiKeText().addActionListener(e -> menuItem_UtilitasDataTabulasiKeExcel_ActionPerformed(e));
        getMenuItemExtractKeExcel().addActionListener(e -> menuItem_UtilitasDataTabulasiKeExcel_ActionPerformed(e));
        
        getMenuItemKeluar().addActionListener(e -> menuItemKeluar_ActionPerformed(e));
        
    }

    @Override
    public void menuItemLogout_ActionPerformed(ActionEvent evt) {
    }

    @Override
    public void menuItem_SettingParamenterSistem_ActionPerformed(ActionEvent evt) {
    }

    @Override
    public void menuItem_SettingPengguna_ActionPerformed(ActionEvent evt) {
    }

    @Override
    public void menuItem_SettingLogPengguna_ActionPerformed(ActionEvent evt) {
    }
    @Override
    public void menuItem_MasterIkan_ActionPerformed(ActionEvent evt) {
    	
    }


    @Override
    public void menuItem_MasterJenisIkan_ActionPerformed(ActionEvent evt) {
        if (masterJenisIkanView ==null) masterJenisIkanView = new IkanJenisView();
        if (! masterJenisIkanView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            masterJenisIkanView.setPreferredSize(dim);
            masterJenisIkanView.setVisible(true);
            getjDesktopPane1().add(masterJenisIkanView);
        }
        masterJenisIkanView.requestFocusInWindow();
        masterJenisIkanView.toFront();
        
    }
    @Override
    public void menuItem_MasterSubKelas_ActionPerformed(ActionEvent evt) {
        if (masterSubKelasView ==null) masterSubKelasView = new IkanSubKelasView();
        if (! masterSubKelasView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            masterSubKelasView.setPreferredSize(dim);
            masterSubKelasView.setVisible(true);
            getjDesktopPane1().add(masterSubKelasView);
        }
        masterSubKelasView.requestFocusInWindow();
        masterSubKelasView.toFront();
        
    }

    @Override
    public void menuItem_MasterWilayahAdministratif_ActionPerformed(ActionEvent evt) {
        if (masterWilayahView ==null) masterWilayahView = new WilayahIntFrame();
        if (! masterWilayahView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            masterWilayahView.setPreferredSize(dim);
            masterWilayahView.setVisible(true);
            getjDesktopPane1().add(masterWilayahView);            
        }
        masterWilayahView.requestFocusInWindow();
        masterWilayahView.toFront();
    }

    @Override
    public void menuItem_TabulasiPerikananTangkapLaut_ActionPerformed(ActionEvent evt) {
        if (tabulasiPerikananLautView ==null) tabulasiPerikananLautView = new TabulasiPerikananLautIntFrame();
        if (! tabulasiPerikananLautView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            tabulasiPerikananLautView.setPreferredSize(dim);
            tabulasiPerikananLautView.setVisible(true);
            getjDesktopPane1().add(tabulasiPerikananLautView);
        }
        tabulasiPerikananLautView.requestFocusInWindow();
        tabulasiPerikananLautView.toFront();
    }

    @Override
    public void menuItem_TabulasiPerikananUmumDarat_ActionPerformed(ActionEvent evt) {
        
    }

    @Override
    public void menuItem_TabulasiLaporanLaporan_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuItem_TabulasiExtractToExcel_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuItem_UtilitasDataTabulasiKeExcel_ActionPerformed(ActionEvent evt) {
        if (tabExtractToTextView ==null) tabExtractToTextView = new TabExtractToTextFrame();
        if (! tabExtractToTextView.isShowing()) {
            Dimension dim = new Dimension(500, 500);
            tabExtractToTextView.setPreferredSize(dim);
            tabExtractToTextView.setVisible(true);
            getjDesktopPane1().add(tabExtractToTextView);
        }
        tabExtractToTextView.requestFocusInWindow();
        tabExtractToTextView.toFront();
    }

    @Override
    public void menuItem_UtilitasSycnTaDariExcel_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuItem_UtilitasDataMasterKeExcel_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuItem_UtilitasSycnMasterDariExcel_ActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuItemKeluar_ActionPerformed(ActionEvent evt) {
    		//Keluar dan merelease semua object pada memory 
    		System.exit(0);
    		
    }
 
    
}
