package be.general.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SuDungDVFormDTO {
	
	@NotEmpty
	private String maKH;
	
	@NotEmpty
	private String maDV;
	
	
	private LocalDate ngaySD;
	
	@NotEmpty
	private String gioSD;

	private int soLuong;
	
	private int donGia;

	public SuDungDVFormDTO(@NotEmpty String maKH, @NotEmpty String maDV, LocalDate ngaySD, @NotEmpty String gioSD,
			int soLuong) {
		super();
		this.maKH = maKH;
		this.maDV = maDV;
		this.ngaySD = ngaySD;
		this.gioSD = gioSD;
		this.soLuong = soLuong;
	}
	
	
}
