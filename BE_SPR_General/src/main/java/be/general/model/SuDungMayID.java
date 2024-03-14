package be.general.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SuDungMayID implements Serializable{
    private String maKH;
    
    private String maMay;
    
    private LocalDate ngaySD;
    
    private String gioSD;

    @Override
    public String toString() {
        return "SuDungMayID [maKH=" + maKH + ", maMay=" + maMay + ", ngaySD=" + ngaySD + ", gioSD=" + gioSD + "]";
    }
     
}
