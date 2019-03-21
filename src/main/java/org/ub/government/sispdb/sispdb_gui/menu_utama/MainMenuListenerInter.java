/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ub.government.sispdb.sispdb_gui.menu_utama;

import java.awt.event.ActionEvent;

/**
 *
 * @author yhawin
 */
public interface MainMenuListenerInter {
   
   public void menuItem_SettingParamenterSistem_ActionPerformed(ActionEvent evt);
   public void menuItem_SettingPengguna_ActionPerformed(ActionEvent evt);
   public void menuItem_SettingLogPengguna_ActionPerformed(ActionEvent evt);
   public void menuItem_SettingInisialisasiDataAwal_ActionPerformed(ActionEvent evt);

   public void menuItem_MasterIkan_ActionPerformed(ActionEvent evt);
   public void menuItem_MasterJenisIkan_ActionPerformed(ActionEvent evt);
   public void menuItem_MasterSubKelas_ActionPerformed(ActionEvent evt);

   public void menuItem_MasterAlatTangkap_ActionPerformed(ActionEvent evt);
   public void menuItem_MasterJenisPerairan_ActionPerformed(ActionEvent evt);
   
   public void menuItem_MasterLokasiUpt_ActionPerformed(ActionEvent evt);

   public void menuItem_MasterWilayahPropinsi_ActionPerformed(ActionEvent evt);
   public void menuItem_MasterWilayahKabupatenKota_ActionPerformed(ActionEvent evt);
   public void menuItem_MasterWilayahKecamatan_ActionPerformed(ActionEvent evt);
   public void menuItem_MasterWilayahDesa_ActionPerformed(ActionEvent evt);
   
   public void menuItem_MasterPemerintahanPemProv_ActionPerformed(ActionEvent evt);
   public void menuItem_MasterPemerintahanPemDa_ActionPerformed(ActionEvent evt);
   public void menuItem_MasterPemerintahanSatker_ActionPerformed(ActionEvent evt);
   public void menuItem_MasterPemerintahanUnitKerja_ActionPerformed(ActionEvent evt);

   
   public void menuItem_TabulasiPerikananTangkapLaut_ActionPerformed(ActionEvent evt);
   public void menuItem_TabulasiPerikananUmumDarat_ActionPerformed(ActionEvent evt);
   public void menuItem_TabulasiLaporanLaporan_ActionPerformed(ActionEvent evt);
   public void menuItem_TabulasiExtractToExcel_ActionPerformed(ActionEvent evt);
   
   public void menuItem_UtilitasDataTabulasiKeExcel_ActionPerformed(ActionEvent evt);
   public void menuItem_UtilitasSycnTaDariExcel_ActionPerformed(ActionEvent evt);
   public void menuItem_UtilitasDataMasterKeExcel_ActionPerformed(ActionEvent evt);
   public void menuItem_UtilitasSycnMasterDariExcel_ActionPerformed(ActionEvent evt);

   public void menuItemLogout_ActionPerformed(ActionEvent evt);
   public void menuItemKeluar_ActionPerformed(ActionEvent evt);
    
}
