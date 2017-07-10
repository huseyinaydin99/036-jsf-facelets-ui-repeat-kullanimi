/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siteadi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author husey
 */
@ManagedBean
@RequestScoped
public class YonetimliBean implements Serializable {

    /**
     * Creates a new instance of YonetimliBean
     */
    private String numarasi, adiSoyadi;
    private BigDecimal maasi;
    private int yasi;
    private final static ArrayList<Personel> personels = new ArrayList<Personel>(Arrays.asList(new Personel("1", "Hüseyin Aydın", new BigDecimal(5000), 23),
            new Personel("2", "Ceyda Koç", new BigDecimal(5500), 23),
            new Personel("3", "Eren Ertaş", new BigDecimal(3500), 23),
            new Personel("4", "Doğan Özdoğan", new BigDecimal(5100), 23)));

    public YonetimliBean() {
    }

    public ArrayList<Personel> getPersonels() {
        return personels;
    }

    

    public String getNumarasi() {
        return numarasi;
    }

    public void setNumarasi(String numarasi) {
        this.numarasi = numarasi;
    }

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public BigDecimal getMaasi() {
        return maasi;
    }

    public void setMaasi(BigDecimal maasi) {
        this.maasi = maasi;
    }

    public int getYasi() {
        return yasi;
    }

    public void setYasi(int yasi) {
        this.yasi = yasi;
    }
    
    public void kayitEkle(){
        personels.add(new Personel(this.numarasi, this.adiSoyadi, this.maasi, this.yasi));
    }
    
    public void kayitSil(Personel personel){
        personels.remove(personel);
    }
    
    public String kayitDuzenle(Personel personel){
        personel.setDuzenle(true);
        return null;
    }
    
    public String degisikligiKaydet(){
        for(Personel personel : personels){
            personel.setDuzenle(false);
        }
        return null;
    }
    
    private boolean artanSiralama = true;
    
    public String siralamaPersonelAdiSoyadi(){
        if(artanSiralama){
            Collections.sort(personels, new Comparator<Personel>() {
                @Override
                public int compare(Personel o1, Personel o2) {
                    return o1.getAdiSoyadi().compareTo(o2.getAdiSoyadi());
                }
            });
            artanSiralama = false;
        }
        else{
            Collections.sort(personels, new Comparator<Personel>() {
                @Override
                public int compare(Personel o1, Personel o2) {
                    return o2.getAdiSoyadi().compareTo(o1.getAdiSoyadi());
                }
            });
            artanSiralama = true;
        }
        return null;
    }
    
    public String siralamaPersonelMaasi(){
        if(artanSiralama){
            Collections.sort(personels, new Comparator<Personel>() {
                @Override
                public int compare(Personel o1, Personel o2) {
                    return o1.getMaasi().compareTo(o2.getMaasi());
                }
            });
            artanSiralama = false;
        }
        else{
            Collections.sort(personels, new Comparator<Personel>() {
                @Override
                public int compare(Personel o1, Personel o2) {
                    return o2.getMaasi().compareTo(o1.getMaasi());
                }
            });
            artanSiralama = true;
        }
        return null;
    }

}
