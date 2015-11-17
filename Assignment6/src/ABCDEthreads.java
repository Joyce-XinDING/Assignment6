/*
 * 1. Create five threads, let them print out “A”, “B”, “C”, “D”, “E” individually.
The result shows on the screen should be: “ABCDEABCDEABCDE…...”
*/
public class ABCDEthreads {

	public static void main(String[] args) {

		AAthreads A = new AAthreads();
		Bthreads B = new Bthreads();
		Cthreads C = new Cthreads();
		Dthreads D = new Dthreads();
		Ethreads E = new Ethreads();

		A.setB(B);
		B.setC(C);
		C.setD(D);
		D.setE(E);
		E.setA(A);

		A.start();
		B.start();
		C.start();
		D.start();
		E.start();
		}
	}

class AAthreads extends Thread{

	private Bthreads B;
	public void setB(Bthreads B) {
           this.B=B;
	}

	@Override
	public synchronized void run(){
		while(true){
			synchronized (this) {		
				System.out.print("A");
				synchronized (B) {
					B.notify();
				}
				try{
					this.wait();                       
				}catch(InterruptedException e){
					e.printStackTrace();

		}
	}
	}
}
}

class Bthreads extends Thread{
	private Cthreads C;
	public void setC(Cthreads C) {
		this.C=C;
	}
	@Override
	public synchronized void run(){
		while(true){
			try{
				wait();
			}catch(InterruptedException e){

				e.printStackTrace();

		}
			System.out.print("B");
			synchronized (C) {
				C.notify();

		}
	}
	}

}

class Cthreads extends Thread{
	private Dthreads D;

	public void setD(Dthreads D) {
		this.D=D;

		}

	@Override

	public synchronized void run(){
		while(true){
			try{
				wait();
			}catch(InterruptedException e){

				e.printStackTrace();

			}
			System.out.print("C");
			synchronized (D) {
			  D.notify();
		}
		}
		}
		   }

class Dthreads extends Thread{
	private Ethreads E;

	public void setE(Ethreads E) {
			this.E=E;

		}

		@Override

	public synchronized void run(){
		while(true){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
		}

			System.out.print("D");
			synchronized (E) {

			 E.notify();
		 }
		}
		}

	}

class Ethreads extends Thread{
	private AAthreads A;
	public void setA(AAthreads A) {
		this.A=A;
		}
	@Override
	public synchronized void run(){
		while(true){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
		}

		  System.out.print("E");
		  synchronized (A) {
			  
			  A.notify();

		}
	}
	}
}
  
		
	


