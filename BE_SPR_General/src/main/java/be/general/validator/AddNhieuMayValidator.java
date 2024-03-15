package be.general.validator;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import be.general.dto.MayFormDTO;
import be.general.dto.SDNhieuMayDTO;


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
    }

}
