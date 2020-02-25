package seppe.alpaerts.notedroid.model;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.time.LocalDate;

public class Note implements Serializable {

    private String titel;
    private String inhoud;
    private LocalDate aanmaakdatum;
    private LocalDate laatstewijzigingen;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Note(String titel, String inhoud) {
        this.titel = titel;
        this.inhoud = inhoud;
        this.aanmaakdatum = LocalDate.now();
        this.laatstewijzigingen = LocalDate.now();
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public LocalDate getAanmaakdatum() {
        return aanmaakdatum;
    }

    public void setAanmaakdatum(LocalDate aanmaakdatum) {
        this.aanmaakdatum = aanmaakdatum;
    }

    public LocalDate getLaatstewijzigingen() {
        return laatstewijzigingen;
    }

    public void setLaatstewijzigingen(LocalDate laatstewijzigingen) {
        this.laatstewijzigingen = laatstewijzigingen;
    }


    @Override
    public String toString() {
        return "Note{" +
                "titel='" + titel + '\'' +
                ", inhoud='" + inhoud + '\'' +
                ", aanmaakdatum=" + aanmaakdatum +
                ", laatstewijzigingen=" + laatstewijzigingen +
                '}';
    }
}

