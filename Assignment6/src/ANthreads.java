/*
 * 
2. Create two threads, let the first thread print out number 1 to 52, another thread print out A to Z.
The result shows on the screen should be: “12A34B56C…”
 */
public class ANthreads {
	
	public static void main(String[] args) {
		
		Athreads A=new Athreads();
		Nthreads N=new Nthreads();
		A.setN(N);
		N.setA(A);
		
		A.start();
		N.start();
		
	}
}
	
class Nthreads extends Thread{
	
	private Athreads A;

	public void setA(Athreads A) {
		this.A=A;
	
	}
	@Override
	public synchronized void run(){
		for(int i=1; i<52; i+=2){
			System.out.print(""+i+(i+1));
			synchronized (A) {
				A.notify();
			}
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

}
class Athreads extends Thread{
	
	private Nthreads N;

	public void setN(Nthreads N) {
		this.N=N;
	
	}
	@Override
	public synchronized void run(){
		for(char a='A';a<='Z';a++ ){
			
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.print(a);
			synchronized (N) {
				N.notify();
			}
		}
	}
	

}
