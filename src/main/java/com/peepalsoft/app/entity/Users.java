package com.peepalsoft.app.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.peepalsoft.app.auth.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.peepalsoft.app.entity.BaseEntity;
import com.peepalsoft.app.entity.Staffs;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {
	      @UniqueConstraint(columnNames = {"username", "staffs_code"})
	      })
public class Users extends BaseEntity {
	
	@Id
	@NotNull
	@Size(min = 4, max = 20)
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private boolean status;
	
	@OneToOne
	@JoinColumn(updatable = false)
	private Staffs staffs;
	
	//doesn't create a new column
	@Transient
	private String confirmpassword;
	
	@Transient
	private String newpassword;
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( 
        name = "users_roles", 
        joinColumns = @JoinColumn(
          name = "user_username", referencedColumnName = "username"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    private Collection<Role> roles;
	
	

}
