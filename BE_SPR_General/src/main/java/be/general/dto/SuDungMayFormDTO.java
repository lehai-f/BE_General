package be.general.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SuDungMayFormDTO {
    
    @NotEmpty
    private String maKH;
    
    @NotEmpty
    private String maMay;
    
    private LocalDate ngaySD;
    
    @NotEmpty
    private String gioSD;
    
    private int thoiGianSD;
}
