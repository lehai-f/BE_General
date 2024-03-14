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
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SuDungDichVuID implements Serializable{
    
    @ManyToOne()
    @JoinColumn(name = "maKH")
    private KhachHang sddvKH;
    
    @ManyToOne()
    @JoinColumn(name = "maDV")
    private DichVu sddvDV;
    
    private LocalDate ngaySD;
    
    private LocalTime gioSD;
    
}
