package be.general.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    
    @ManyToOne()
    @JoinColumn(name = "maMay")
    private May sdMay;
    
    @ManyToOne()
    @JoinColumn(name = "maKH")
    private KhachHang sdmKH;
    
    private LocalDate ngaySD;
    
    private LocalTime gioSD;
     
}
