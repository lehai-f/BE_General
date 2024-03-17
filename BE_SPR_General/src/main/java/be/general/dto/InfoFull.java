package be.general.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoFull {
	private String maKH;

	private String tenKH;

	private String maMay;

	private String viTri;

	private String trangThai;

	private LocalDate ngayBatDauSDMay;

	private String gioBatDauSDMay;

	private Integer thoiGianSDMay;

	private String maDV;

	private LocalDate ngaySuDungDV;

	private String gioSuDungDV;

	private Integer soLuongSDDV;

	private Integer tongTien;
}
