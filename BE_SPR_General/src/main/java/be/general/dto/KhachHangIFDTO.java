package be.general.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangIFDTO {
	private String maKH;
	
	private String tenKH;
	
	private List<SuDungDVFormDTO> sddvList = new ArrayList<>();
	
	private List<SuDungMayFormDTO> sdmList = new ArrayList<>();
	
	private int tongTien;
	
	public KhachHangIFDTO(String maKH, String tenKH) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
	}
	
	public void addMay(SuDungMayFormDTO sdm) {
		this.sdmList.add(sdm);
	}
	
	public void addDV(SuDungDVFormDTO sddv) {
		this.sddvList.add(sddv);
	}


}
