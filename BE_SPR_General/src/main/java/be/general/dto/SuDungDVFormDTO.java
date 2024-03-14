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
}
