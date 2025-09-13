package org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetomany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="one_to_one_address")
public class Address {
    @NotBlank
    private String country;
    @NotBlank
    private String state;
    
    //cascade is to delete children(List<Passport>) when parent(address) is delete
    //cascade is only parent -> child operation 
    //orphanremoval will delete if children(List<Passport>) removed deleted from passport table to
    //also deletes children(List<Passport>) from passport table if pointing to null address
    //but orphan removal alone cant nullify on parent removal, works on child only
    //orphan is both parent to child and child operation
    @OneToMany(mappedBy = "address",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Passport> passports = new ArrayList<>(); 

    @Id
    @Column(unique = true)
    private int zip;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

	public List<Passport> getPassport() {
		return passports;
	}

	public void setPassport(List<Passport> passport) {
		this.passports = passport;
	}
	
	
    public void addPassport(Passport passport) {
        passports.add(passport);
        passport.setAddress(this); // maintain bidirectional consistency
    }
    
    public void deletePassport(Passport passport) {
        passports.remove(passport);
        passport.setAddress(this); // maintain bidirectional consistency
    }

	@Override
	public String toString() {
		return "Address [ zip=" + zip + ", passport=" + passports + "]";
	}

    
}
