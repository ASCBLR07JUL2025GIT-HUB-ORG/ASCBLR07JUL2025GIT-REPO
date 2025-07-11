package com.demo.inheritance;

public class AbstractClassDemo {
	public static void main(String[] args) {
			Education education = null;
//			Cannot instantiate the type Education
//			education = new Education();
			ITCompany itCompany = new ITCompany();
			itCompany.expense();
			itCompany.teaching();
	
			ManufacturingCompany manufacturingCompany = new ManufacturingCompany();
			manufacturingCompany.expense();
			manufacturingCompany.teaching();
			
			Individual individual = new Individual();
			individual.expense();
			individual.teaching();		
	}
}

// 0 or n abstract methods
abstract class Education {
	public Education() {
		System.out.println("Eudcation()");
	}

//	concrete methods
	public void expense() {
		System.out.println("Expense are taken care of....");
	}
	
	abstract void teaching();
}

 class ITCompany extends Education {
	@Override
	void teaching() {
		System.out.println("Classroom Dev Training");
	}
}

class ManufacturingCompany extends Education {
	@Override
	void teaching() {
	System.out.println("Field work");
		
	}
}

class Individual extends Education {
	@Override
	void teaching() {
	System.out.println("Traditional learning");
		
	}
//	annotation provide metadata
	@Override
	public void expense() {
		System.out.println("Expense needs to be taken care by the learner....");
	}
}