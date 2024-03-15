package be.general.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MayFormDTO {
    private String maMay;
    
    private LocalDate ngaySD;

    private String gioSD;
    
    private int thoiGianSD;
}