package be.general.validator;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import be.general.dto.MayFormDTO;
import be.general.dto.SDNhieuMayDTO;

@Service
public class AddNhieuMayValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof SDNhieuMayDTO)) {
            return;
        }
        SDNhieuMayDTO sdm = (SDNhieuMayDTO) target;
        List<MayFormDTO> listMay = sdm.getListMay();
        for (int i = 0; i < listMay.size(); i++) {
			if(listMay.get(i).getMaMay() == null || "".equals(listMay.get(i).getMaMay())){
				errors.rejectValue("listMay[" +i+ "].maMay", null, "MaMay can not Empty");
			}
			if(listMay.get(i).getNgaySD() == null){
				errors.rejectValue("listMay[" +i+ "].ngaySD", null, "NgaySD can not Empty");
			}
			if("".equals(listMay.get(i).getGioSD()) || listMay.get(i).getGioSD() == null){
				errors.rejectValue("listMay[" +i+ "].gioSD", null, "GioSD can not Empty");
			}
		}
    }

}
