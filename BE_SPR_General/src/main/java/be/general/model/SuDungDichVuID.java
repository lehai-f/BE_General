package be.general.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Embeddable;

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
    
    private String maKH;
    
    private String maDV;

    private LocalDate ngaySD;
    
    private LocalTime gioSD;
    
}
