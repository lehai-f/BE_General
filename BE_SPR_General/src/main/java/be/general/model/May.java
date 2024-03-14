package be.general.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class May {
    
    @Id
    private String maMay;
    
    private String viTri;
    
    private String trangThai;
    
    @OneToMany(mappedBy = "sdmID.sdMay", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<SuDungMay> sdmList = new HashSet<SuDungMay>();
}
