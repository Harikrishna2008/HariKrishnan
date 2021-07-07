package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Teacher")
public class Teachermodel {

    private int RollNumber;
    private String FirstName;
    private String LastName;
    private String FathersName;  
    private String MothersName;
    private String BloodGroup;
    private String ContractType;
    private String Dob;
    private String MobileNumber;
    private String HomeNumber;
    private String Address;
    private int Pincode;
    private String AdhaarNumber;
    private String Roles;
    private String Active;
    private String JoiningDate;
    private String TcDate;

     /*public Teacher(int RollNumber, String FirstName, String LastName, String FathersName, String MothersName, String BloodGroup, String ContractType, String Dob, String MobileNumber, String HomeNumber, String Address, int Pincode, String AdhaarNumber, String Roles, int Std, String Active, String JoiningDate, String TcDate) {
                this.RollNumber = RollNumber;
                this.FirstName = FirstName;
                this.LastName = LastName;
                this.FathersName = FathersName;
                this.MothersName = MothersName;
                this.BloodGroup = BloodGroup;
                this.ContractType = ContractType;
                this.Dob = Dob;
                this.MobileNumber = MobileNumber;
                this.HomeNumber = HomeNumber;
                this.Address = Address;
                this.Pincode = Pincode;
                this.AdhaarNumber = AdhaarNumber;
                this.Roles = Roles;
                this.Active = Active;
                this.JoiningDate = JoiningDate;
                this.TcDate = TcDate;
                System.out.println("Student: " + FirstName);
        }
        */
     
        
        
        public int getRollNumber() {
        	System.out.println("getRollNumber " + RollNumber);
		     return RollNumber;
	    }

	     public void setRollNumber(int rollNumber) {
	    	 System.out.println("getRollNumber " + RollNumber);
		     this.RollNumber = rollNumber;
	    }

	    public String getFirstName() {
	    	System.out.println("getFirstNumber " + FirstName);
		    return FirstName;
	    }

	    public void setFirstName(String firstName) {
	    	System.out.println("getRollNumber " + RollNumber);
		    this.FirstName = firstName;
	    }
 
	    public String getLastName() {
	    	System.out.println("getLastName " + LastName);
		    return LastName;
	    }

	    public void setLastName(String lastName) {
		     this.LastName = lastName;
	    }

	    public String getFathersName() {
	    	System.out.println("getFathersName " + FathersName);
		    return FathersName;
	    }

	    public void setFathersName(String fathersName) {
		    this.FathersName = fathersName;
	    }

	    public String getMothersName() {
	    	System.out.println("getMothersName " + MothersName);
		    return MothersName;
	    }

	    public void setMothersName(String mothersName) {
		    this.MothersName = mothersName;
	    }

	    public String getBloodGroup() {
	    	System.out.println("getBloodGroup " + BloodGroup);
	     	return BloodGroup;
	    }

	    public void setBloodGroup(String bloodGroup) {
		    this.BloodGroup = bloodGroup;
	    }

	     public String getContractType() {
	    	System.out.println("getContractType " + ContractType);
			return ContractType;
		}

		public void setContractType(String contractType) {
			ContractType = contractType;
		}

		public String getMobileNumber() {
	    	 System.out.println("getMobileNumber " + MobileNumber);
		     return MobileNumber;
	    }

	     public void setMobileNumber(String MobileNumber) {
		     this.MobileNumber = MobileNumber;
	    }

	     public String getHomeNumber() {
	    	 System.out.println("getHomeNumber " + HomeNumber);
		     return HomeNumber;
	    }

	     public void setHomeNumber(String homeNumber) {
		     this.HomeNumber = homeNumber;
	    }

	     public String getAddress() {
	    	 System.out.println("getAddress " + Address); 
		     return Address;
	    }

	     public void setAddress(String address) {
		     this.Address = address;
	    }

	      public int getPincode() {
	    	  System.out.println("getPincode " + Pincode);
		     return Pincode;
	    }

	      public void setPincode(int pincode) {
		     this.Pincode = pincode;
	    }

	      public String getAdhaarNumber() {
	    	  System.out.println("getRollNumber " + RollNumber);
		      return AdhaarNumber;
	    }
 
	     public void setAdhaarNumber(String AdhaarNumber) {
		     this.AdhaarNumber = AdhaarNumber;
	    }
  
	     public String getRoles() {
	    	 System.out.println("getRoles " + Roles);
		     return Roles;
	    }

	     public void setRoles(String Roles) {
		    this.Roles = Roles;
	    }

	     public String getDob() {
	    	 System.out.println("getDob " + Dob);
		     return Dob;
	    }
	     
	     public void setDob(String Dob) {
		    this.Dob = Dob;
	     }

		public String getActive() {
		    System.out.println("getActive " + Active);
			return Active;
		}

		public void setActive(String active) {
			this.Active = active;
		}

		public String getJoiningDate() {
			System.out.println("getJoiningDate " + JoiningDate);
			return JoiningDate;
		}

		public void setJoiningDate(String joiningDate) {
			this.JoiningDate = joiningDate;
		}

		public String getTcDate() {
			System.out.println("getTcDate " + TcDate);
			return TcDate;
		}

		public void setTcDate(String tcDate) {
			this.TcDate = tcDate;
		}
	     
}