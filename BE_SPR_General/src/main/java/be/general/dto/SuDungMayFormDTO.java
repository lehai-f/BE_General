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
    
    private String viTri;
    
    private String trangThai;

	public SuDungMayFormDTO(@NotEmpty String maKH, @NotEmpty String maMay, LocalDate ngaySD, @NotEmpty String gioSD,
			int thoiGianSD) {
		super();
		this.maKH = maKH;
		this.maMay = maMay;
		this.ngaySD = ngaySD;
		this.gioSD = gioSD;
		this.thoiGianSD = thoiGianSD;
	}
    
    
}
