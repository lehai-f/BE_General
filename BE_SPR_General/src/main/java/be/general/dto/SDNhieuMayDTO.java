package be.general.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SDNhieuMayDTO {
    private String maKH;
    ArrayList<MayFormDTO> listMay;
}
