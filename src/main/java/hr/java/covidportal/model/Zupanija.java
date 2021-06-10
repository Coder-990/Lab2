package main.java.hr.java.covidportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Zupanija extends ImenovaniEntitet{

    Integer brojStanovnikaZupanije;

    public Zupanija(String naziv, Integer brojStanovnikaZupanije) {
        super(naziv);
        this.naziv = naziv;
        this.brojStanovnikaZupanije = brojStanovnikaZupanije;
    }

  /*  public String getNazivZupanije() {
        return nazivZupanije;
    }

    public void setNazivZupanije(String nazivZupanije) {
        this.nazivZupanije = nazivZupanije;
    }

    public Integer getBrojStanovnikaZupanije() {
        return brojStanovnikaZupanije;
    }

    public void setBrojStanovnikaZupanije(Integer brojStanovnikaZupanije) {
        this.brojStanovnikaZupanije = brojStanovnikaZupanije;
    }

*/

}
