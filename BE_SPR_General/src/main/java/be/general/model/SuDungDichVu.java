package be.general.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SuDungDichVu {
    
    @EmbeddedId
    private SuDungDichVuID sddvID;
    
    private int soLuong;
}
