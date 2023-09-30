package my_project;

import java.util.Scanner;

public class Cramers_rule {
	
	public static double det(double[][] x) {		
		
		double summ = 0;
		double num1 = 0;
		double num2 = 0;
		
		
			for(int i=0; i<x.length;i++) {
				for(int j=0; j < x.length;j++) { 
				
					for(int k=0; k < x[j].length;k++) { 
					
						if(i == 0) {
							if(j == 0 || j == 1 && k == 0) {
								continue;

							}
							num1 = x[j][k];
							summ += x[0][0] * num1;
						}
					
						if(i == 1) {
							if( j == 0 && k == 0 || j == 1 ) {
								continue;

							}
						num2 = x[j][k];
						summ += -1 * x[1][0] * num2;
						}
					}
					
					}
				
				
				
			}// end of first for loop
			
			return summ;
	} // end of method
		
		public static double det3(double[][] x) {
			
			double[][] m1 = new double[2][2]; 
			double[][] m2 = new double[2][2]; 
			double[][] m3 = new double[2][2]; 
			double sum = 0;
			
			for(int i=0; i<x.length;i++) {
				
				for(int j=0; j < x.length;j++) { // row
				
					for(int k=0; k < x[j].length;k++) {  // col
					
						if(i == 0) {
							if(j == 0 || j == 1 && k == 0 || j == 2 && k == 0 ) {
								continue;

							}
							m1[j-1][k-1] = x[j][k];
	
						}

						
						if(i == 1) {
							if(  j == 0 && k == 0 || j == 1 || j == 2 && k == 0 ) {
								continue;

								}
								if(j == 0) {
									m2[j][k-1] = x[j][k];	
									}
								if(j != 0) {
									m2[j-1][k-1] = x[j][k];	
									}
							}
						
						if(i == 2) {
							if((j == 0 && k == 0) || (j == 1 && k == 0) || j == 2 ) {
								continue;

								}
							
								m3[j][k-1] = x[j][k];
							}
						
						}
					
					}
				
				
				
			}// end of first for loop
			
			sum = x[0][0] * det(m1) - x[1][0] * det(m2) + x[2][0] * det(m3);
			
			return sum;
		}
		
	public static double solution_x(double[][] x, int a, int b) {
			
			double denominator = det(x);
			double temp = x[0][0];
			double temp1 = x[1][0];
			
			
			x[0][0] = a;
			x[1][0] = b;
			
			double nenominator = det(x);
			x[0][0] = temp;
			x[1][0] = temp1;
			
			
			if(denominator == 0.0000000000) {
				System.out.print("\n\n\t\t\t\tNo solution \"Undefinded\"");
				System.exit(-1);
			}
			double solution = nenominator/denominator;
			
			
			return solution;
			}
	
	public static double solution_x(double[][] x, int a, int b, int c) {
		
		double denominator = det3(x);
		double temp = x[0][0];
		double temp1 = x[1][0];
		double temp2 = x[2][0];
		
		x[0][0] = a;
		x[1][0] = b;
		x[2][0] = c;
		double nenominator = det3(x);
		x[0][0] = temp;
		x[1][0] = temp1;
		x[2][0] = temp2;
		
		if(denominator == 0.0000000000) {
			System.out.print("\n\n\t\t\t\tNo solution \"Undefinded\"");
			System.exit(-1);
		}
		double solution = nenominator/denominator;
		
		
		return solution;
		}
	
	
	public static double solution_y(double[][] x, int a, int b) {
		
		double denominator = det(x);
		double temp = x[0][1];
		double temp1 = x[1][1];
	
		
		x[0][1] = a;
		x[1][1] = b;
		
		double nenominator = det(x);
		x[0][1] = temp;
		x[1][1] = temp1;
		
		double solution = nenominator/denominator;
		
		
		return solution;
		}

	public static double solution_y(double[][] x, int a, int b, int c) {
		
		double denominator = det3(x);
		double temp = x[0][1];
		double temp1 = x[1][1];
		double temp2 = x[2][1];
		
		x[0][1] = a;
		x[1][1] = b;
		x[2][1] = c;
		double nenominator = det3(x);
		x[0][1] = temp;
		x[1][1] = temp1;
		x[2][1] = temp2;
		double solution = nenominator/denominator;
		
		
		return solution;
		}
	
	public static double solution_z(double[][] x, int a, int b, int c) {
		
		double denominator = det3(x);
		double temp = x[0][2];
		double temp1 = x[1][2];
		double temp2 = x[2][2];
		
		x[0][2] = a;
		x[1][2] = b;
		x[2][2] = c;
		double nenominator = det3(x);
		x[0][2] = temp;
		x[1][2] = temp1;
		x[2][2] = temp2;
		
		
		double solution = nenominator/denominator;
		
		
		return solution;
		}

	public static void main(String[] args) {
		
		Scanner scnr =  new Scanner(System.in);
		System.out.println("\n\t\t\tFinding Solution of Linear equation using Cramer's Rule");
		System.out.println("\t\t\t-------------------------------------------------");
		System.out.print("\nEnter the number of unknowns in your equation: ");
		int nu = scnr.nextInt();
		double[][] array;
		char a;
		int c,d,e;
		
		while(nu != 2 && nu != 3) {
			System.out.println("\nPlease enter 2 or 3!");
			System.out.print("\nEnter the number of unknowns in your equation: ");
			nu = scnr.nextInt();
		}
		
		if(nu == 2) {
			System.out.println();
			array = new double[2][2];
			a = 'x';
			c=0;d=0;
			
			for(int i = 0; i< 2; i++) {
				
				if(i == 0) {
					System.out.println("First Equation: \n");
					
				}
				if(i == 1) {
					System.out.println("\nSecond Equation: \n");
				}
				
				for(int k = 0; k < 2; k++) {
					
					if(i == 0 && k == 0 || i == 1 && k == 0 ) {
						a = 'x';
					}
					
					if(i == 0 && k == 1 || i == 1 && k == 1 ) {
						a = 'y';
					}
					

					System.out.printf("Enter the %c value: ", a );
					int m = scnr.nextInt();
					array[i][k] = m;
		
				}
				switch(i) {
				case 0:
					System.out.print("Enter the constant value : ");
					c = scnr.nextInt();
					break;
				case 1:
					System.out.print("Enter the constant value : ");
					d = scnr.nextInt();
					break;
				
				
				}
			}
			String x = "";
			String x1 = "";
			
			String y = "";
			String y1 = "";
			
			
			
			if(array[0][0] > 0) {
				x = String.format("%.1f",array[0][0] );
			}
			else {
				x = String.format("-%.1f",array[0][0] );
			}
			if(array[1][0] > 0) {
				x1 = String.format("%.1f",array[1][0] );
			}
			else {
				x1 = String.format("-%.1f",array[1][0] );
			}
			
			//
			if(array[0][1] > 0) {
				y = String.format("+%.1f",array[0][1] );
			}
			else {
				y = String.format("%.1f",array[0][1] );
			}
			if(array[1][1] > 0) {
				y1 = String.format("+%.1f",array[1][1] );
			}
			else {
				y1 = String.format("%.1f",array[1][1] );
			}
			
			//
			
			
			
			System.out.println("\n\nEquation 1: \t"+ x +"x "+ y +"y = "+ c);
			System.out.println("Equation 2: \t"+ x1 +"x "+ y1 +"y = "+ d);
			
			
			
			System.out.println("\nThe solution for x is : " + solution_x(array, c,d));
			System.out.println("The solution for y is : " + solution_y(array, c,d));
			
			
			
		}
		
		
		
		if(nu == 3) {
			System.out.println();
			array = new double[3][3];
			a = 'x';
			c=0;d=0;e=0;
			for(int i = 0; i< 3; i++) {
				
				if(i == 0) {
					System.out.println("First Equation: \n");
					
				}
				else if(i == 1) {
					System.out.println("\nSecond Equation: \n");
				}
				else {
					
					System.out.println("\nThird Equation: \n");
				}
				for(int k = 0; k < 3; k++) {
					
					if(i == 0 && k == 0 || i == 1 && k == 0 || i == 2 && k == 0 ) {
						a = 'x';
					}
					
					if(i == 0 && k == 1 || i == 1 && k == 1 || i == 2 && k == 1) {
						a = 'y';
					}
					if(i == 0 && k == 2 || i == 1 && k == 2 || i == 2 && k == 2) {
						a = 'z';
					}

					System.out.printf("Enter the %c value: ", a );
					int m = scnr.nextInt();
					array[i][k] = m;
		
				}
				switch(i) {
				case 0:
					System.out.print("Enter the constant value : ");
					c = scnr.nextInt();
					break;
				case 1:
					System.out.print("Enter the constant value : ");
					d = scnr.nextInt();
					break;
				case 2:
					System.out.print("Enter the constant value : ");
					e = scnr.nextInt();
					break;
				}
				
			}
			
			String x = "";
			String x1 = "";
			String x2 = "";
			String y = "";
			String y1 = "";
			String y2 = "";
			String z = "";
			String z1 = "";
			String z2 = "";
			
			if(array[0][0] > 0) {
				x = String.format("%.1f",array[0][0] );
			}
			else {
				x = String.format("-%.1f",array[0][0] );
			}
			if(array[1][0] > 0) {
				x1 = String.format("%.1f",array[1][0] );
			}
			else {
				x1 = String.format("-%.1f",array[1][0] );
			}
			if(array[2][0] > 0) {
				x2 = String.format("%.1f",array[2][0] );
			}
			else {
				x2 = String.format("-%.1f",array[2][0] );
			}
			//
			if(array[0][1] > 0) {
				y = String.format("+%.1f",array[0][1] );
			}
			else {
				y = String.format("%.1f",array[0][1] );
			}
			if(array[1][1] > 0) {
				y1 = String.format("+%.1f",array[1][1] );
			}
			else {
				y1 = String.format("%.1f",array[1][1] );
			}
			if(array[2][1] > 0) {
				y2 = String.format("+%.1f",array[2][1] );
			}
			else {
				y2 = String.format("%.1f",array[2][1] );
			}
			//
			if(array[0][2] > 0) {
				z = String.format("+%.1f",array[0][2] );
			}
			else {
				z = String.format("%.1f",array[0][2] );
			}
			if(array[1][2] > 0) {
				z1 = String.format("+%.1f",array[1][2] );
			}
			else {
				z1 = String.format("%.1f",array[1][2] );
			}
			if(array[2][2] > 0) {
				z2 = String.format("+%.1f",array[2][2] );
			}
			else {
				z2 = String.format("%.1f",array[2][2] );
			}
			
			
			System.out.println("\n\nEquation 1: \t"+ x +"x "+ y +"y " + z +"z = "+ c);
			System.out.println("Equation 2: \t"+ x1 +"x "+ y1 +"y " + z1 +"z = "+ d);
			System.out.println("Equation 3: \t"+ x2 +"x "+ y2 +"y " + z2 +"z = "+ e);
			
			
			System.out.println("\nThe solution for x is : " + solution_x(array, c,d,e));
			System.out.println("The solution for y is : " + solution_y(array, c,d,e));
			System.out.println("The solution for z is : " + solution_z(array, c,d,e));
			
		}

		
		}
	}
	
